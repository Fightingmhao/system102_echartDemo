package com.rayootech.service.recruitment.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.CandidateVo;
import com.rayootech.bean.recruitment.Candidate;
import com.rayootech.mapper.deliver.ResumeMapper;
import com.rayootech.mapper.recruitment.CandidateMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.recruitment.ICandidateService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import com.rayootech.utils.IpUtil;
import com.rayootech.utils.word.ParseFile;
import com.rayootech.utils.word.WordToHtmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 21:01
 */
@Service
public class CandidateServiceImpl implements ICandidateService {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    private WordToHtmlUtil wordToHtmlUtil;

    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;

    /**
     * 查询候选人推荐列表
     *
     * @param candidate 候选人推荐
     * @return 候选人推荐
     */
    @Override
    public ResponseVo<Object> selectCandidateList(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                  @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                  Candidate candidate) {


        List<Candidate> candidateList = null;
        if(dataScopeServiceImp.getDeptype(candidate.getCanHremail()).equals("X")){

            candidate.setCanHremail(dataScopeServiceImp.getDataScope(candidate.getCanHremail()));
            PageHelper.startPage(currentPage,pageSize);
            candidateList = candidateMapper.selectCandidateListBySale(candidate);
        }else{
            candidate.setCanHremail(dataScopeServiceImp.getDataScope(candidate.getCanHremail()));
            PageHelper.startPage(currentPage,pageSize);
            candidateList = candidateMapper.selectCandidateList(candidate);
        }

        PageInfo pageInfo = new PageInfo(candidateList);
        pageInfo.setList(candidateList);
        return ResponseVo.success(pageInfo);
    }

    /**
     * 新增候选人
     *
     * @param candidateVo 候选人推荐
     * @return 结果
     */
//    @Override
//    public ResponseVo<Object> insertCandidate(CandidateVo candidateVo)    {
//        MultipartFile canResumecopy = candidateVo.getCanResumecopy();
//        InputStream inputStream = null;
//        String msg = null;
//        try{
//            inputStream = canResumecopy.getInputStream();
//             msg = FileUtils.msg(inputStream, (int) canResumecopy.getSize());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Candidate candidate = new Candidate();
//
//        candidate.setCanProName(candidateVo.getCanProName());
//        candidate.setCanDept(candidateVo.getCanDept());
//        candidate.setCanName(candidateVo.getCanName());
//        candidate.setCanCard(candidateVo.getCanCard());
//        candidate.setCanSex(candidateVo.getCanSex());
//        candidate.setCanPhone(candidateVo.getCanPhone());
//        candidate.setCanPost(candidateVo.getCanPost());
//        candidate.setCanHrname(candidateVo.getCanHrname());
//        candidate.setCanHremail(candidateVo.getCanHremail());
//        candidate.setCanState(candidateVo.getCanState());
//        candidate.setCanResumecopy(msg);
//        candidate.setCanIp(IpUtil.getIpAddr(request));
//        candidate.setCanCreatetime(new Date());
//        int i = candidateMapper.insertCandidate(candidate);
//        if (i>0) return ResponseVo.success();
//        return ResponseVo.error(1,"添加失败！");
//    }

    @Override
    public ResponseVo<Object> insertCandidate(CandidateVo candidateVo) throws Exception {
        System.out.println(candidateVo);
        Candidate candidate = new Candidate();
        MultipartFile canResumecopy = candidateVo.getCanResumecopy();
        if(canResumecopy.getOriginalFilename().contains("doc")){
            String context = uploadSourceNews(canResumecopy);
            if(context == null){
                context = ParseFile.readHtml(canResumecopy.getInputStream());
            }
            candidate.setCanText(context);

        }else{
            candidate.setCanText(candidateVo.getCanText());
        }


//        FileToByteUtil fileToByteUtil = new FileToByteUtil();
//        fileToByteUtil.toByte(canResumecopy);
        byte[] bytes = null;
        try {
            bytes  = canResumecopy.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }


        candidate.setCanResumecopy(Arrays.toString(bytes).replace("[","").replace("]",""));
        candidate.setCanName(candidateVo.getCanName());
        candidate.setCanProName(candidateVo.getCanProName());
        candidate.setCanPost(candidateVo.getCanPost());
        candidate.setCanDept(candidateVo.getCanDept());
        candidate.setCanCard(candidateVo.getCanCard());
        candidate.setCanPhone(candidateVo.getCanPhone());
        candidate.setCanSex(candidateVo.getCanSex());
        candidate.setCanState(candidateVo.getCanState());
        candidate.setCanHremail(candidateVo.getCanHremail());
        candidate.setCanHrname(candidateVo.getCanHrname());
        candidate.setCanIp(candidateVo.getCanIp());
        candidate.setCanCreatetime(new Date());
        int i = candidateMapper.insertCandidate(candidate);
        if (i>0) return ResponseVo.success();
        return ResponseVo.error(1,"添加失败！");
    }


    public String uploadSourceNews(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        if (!".doc".equals(suffixName) && !".docx".equals(suffixName)) {
            throw new Exception();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        String dateDir = formatter.format(LocalDate.now());
//        String directory = imageDir + "/" + dateDir + "/";
        String content = null;
        try {
            InputStream inputStream = file.getInputStream();

//            //将MultipartFile 转 File
//            File file1 = multipartFileToFile(file);


            if (".doc".equals(suffixName)) {
                content = wordToHtmlUtil.Word2003ToHtml(inputStream);
            } else {
                content = wordToHtmlUtil.Word2007ToHtml(file);
            }
        } catch (Exception ex) {
            ResponseVo.error("word to html exception, detail:");
            return null;
        }
        return content;
    }

    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询候选人推荐
     *
     * @param canId 候选人推荐ID
     * @return 候选人推荐
     */
    @Override
    public Candidate selectCandidateById(Integer canId) {
        Candidate candidate = candidateMapper.selectCandidateById(canId);
        return candidate;
    }

    /**
     * 修改候选人推荐
     *
     * @param candidateVo 候选人推荐
     * @return 结果
     */
    @Override
    public ResponseVo<Object> updateCandidate(CandidateVo candidateVo) throws Exception {

        Candidate candidate = new Candidate();
        MultipartFile canResumecopy = candidateVo.getCanResumecopy();
        if(canResumecopy.getOriginalFilename().contains("doc")){
            System.out.println(canResumecopy.getOriginalFilename());
            String context = uploadSourceNews(canResumecopy);
            System.out.println(context);
            candidate.setCanText(context);
        }else{
            candidate.setCanText(candidateVo.getCanText());
        }

        if(canResumecopy.getOriginalFilename().contains("jpg")){
            System.out.println(canResumecopy.getOriginalFilename());
            candidate.setCanResumecopy(null);
        }else{

            byte[] bytes = null;
            try {
                bytes  = canResumecopy.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            candidate.setCanResumecopy(Arrays.toString(bytes).replace("[","").replace("]",""));

        }

        candidate.setCanId(candidateVo.getCanId());
        candidate.setCanName(candidateVo.getCanName());
        candidate.setCanProName(candidateVo.getCanProName());
        candidate.setCanPost(candidateVo.getCanPost());
        candidate.setCanDept(candidateVo.getCanDept());
        candidate.setCanCard(candidateVo.getCanCard());
        candidate.setCanPhone(candidateVo.getCanPhone());
        candidate.setCanSex(candidateVo.getCanSex());
        candidate.setCanState(candidateVo.getCanState());
        candidate.setCanHremail(candidateVo.getCanHremail());
        candidate.setCanHrname(candidateVo.getCanHrname());

        int i = candidateMapper.updateCandidate(candidate);
        if (i>0) return ResponseVo.success();
        return ResponseVo.error(1,"更新失败！");
    }

    @Override
    public String selectResumeById(Integer canId) {
        return candidateMapper.selectCandidateById(canId).getCanResumecopy();
    }


}
