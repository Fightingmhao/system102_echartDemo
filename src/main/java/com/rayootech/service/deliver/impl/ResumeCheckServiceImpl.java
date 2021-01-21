package com.rayootech.service.deliver.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.ResumeCheckVo;
import com.rayootech.bean.Vo.ResumeResultVo;
import com.rayootech.bean.deliver.ResumeCheck;
import com.rayootech.bean.recruitment.Candidate;
import com.rayootech.mapper.deliver.ResumeMapper;
import com.rayootech.mapper.recruitment.CandidateMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IResumeCheckService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import com.rayootech.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 16:31
 */
@Service
public class ResumeCheckServiceImpl implements IResumeCheckService {
    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ResumeMapper resumeMapper;


    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;

    /**
     * 查询未审核候选人信息
     * @param resumeCheckVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<Object> selectCanInfoByDeptName(ResumeCheckVo resumeCheckVo, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Candidate> list = candidateMapper.selectCanInfoByDeptName(resumeCheckVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }

    /**
     * 批量插入审核结果
     * @param resumeCheckVos
     * @return
     */
    @Override
    public ResponseVo<Object> insertResumeCheckBatch(ResumeCheckVo[] resumeCheckVos) {
        List<ResumeCheck> resumeCheckList = new ArrayList<ResumeCheck>();
        List<Candidate> candidateList = new ArrayList<Candidate>();
        ResumeCheck resumeCheck = null;
        Candidate candidate = null;
        for(int i = 0;i<resumeCheckVos.length;i++){
            resumeCheck = new ResumeCheck();
            resumeCheck.setCanId(resumeCheckVos[i].getCanId());
            resumeCheck.setCheckState(resumeCheckVos[i].getCanResstate());
            resumeCheck.setCheckName(resumeCheckVos[i].getCheckName());
            resumeCheck.setCheckCreatetime(new Date());
            resumeCheck.setCheckIp(IpUtil.getIpAddr(request));
            resumeCheck.setCheckDept(resumeCheckVos[i].getCanDept());
            resumeCheck.setCheckPubstate(0);
            resumeCheckList.add(resumeCheck);
            candidate = new Candidate();
            candidate.setCanId(resumeCheckVos[i].getCanId());
            candidate.setCanResstate(resumeCheckVos[i].getCanResstate());
            candidateList.add(candidate);
        }

        int i = candidateMapper.updateCandidates(candidateList);

        int j = resumeMapper.insertResumecheckBatch(resumeCheckList);

        if(i > 0 && j > 0){
            return ResponseVo.success();
        }
        return ResponseVo.error(1,"数据插入失败");
    }

    /**
     * 查询简历审核结果
     * @param currentPage
     * @param pageSize
     * @param resumeResultVo
     * @return
     */
    @Override
    public ResponseVo<Object> selectResumeResultVo(Integer currentPage, Integer pageSize, ResumeResultVo resumeResultVo) {
        List<ResumeResultVo> list = null;
        String deptype = dataScopeServiceImp.getDeptype(resumeResultVo.getCanHremail());
        if(deptype.equals("X")){
            resumeResultVo.setCanHremail(dataScopeServiceImp.getDataScope(resumeResultVo.getCanHremail()));
            PageHelper.startPage(currentPage, pageSize);
            list = resumeMapper.selectSaleResumeResultVo(resumeResultVo);
        }else if(deptype.equals("J")){
            resumeResultVo.setCanHremail(null);
            PageHelper.startPage(currentPage, pageSize);
            list = resumeMapper.selectResumeResultVo(resumeResultVo);
        }else if(deptype.equals("Z")){
            resumeResultVo.setCanHremail(dataScopeServiceImp.getDataScope(resumeResultVo.getCanHremail()));
            PageHelper.startPage(currentPage, pageSize);
            list = resumeMapper.selectResumeResultVo(resumeResultVo);
        }else {
            resumeResultVo.setCanHremail(null);
            PageHelper.startPage(currentPage, pageSize);
            list = resumeMapper.selectSaleResumeResultVo(resumeResultVo);
        }
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }


    @Override
    public ResponseVo<Object> insertResumeCheck() {
        List<Candidate> candidates = candidateMapper.selectCandidateAll();
        ResumeCheck resumeCheck = new ResumeCheck();
        for(Candidate candidate : candidates){
            resumeCheck.setCanId(candidate.getCanId());
            resumeCheck.setCheckState(candidate.getCanResstate());
            resumeCheck.setCheckCreatetime(new Date());
            resumeCheck.setCheckIp(IpUtil.getIpAddr(request));
            resumeCheck.setCheckDept(candidate.getCanDept());
            resumeCheck.setCheckPubstate(0);
            resumeMapper.insertResumecheck(resumeCheck);
        }
        return ResponseVo.success("插入成功");
    }



    /**
     * 更新简历审核结果
     * @param resumeResultVo
     * @return
     */
    @Override
    public ResponseVo<Object> updateResumeCheck(ResumeResultVo resumeResultVo) {
        int i = resumeMapper.updateResumecheck(resumeResultVo);
        String canPhone = resumeResultVo.getCanPhone();
        String canProName = resumeResultVo.getCanProName();
        Integer canId = resumeResultVo.getCanId();
        String canPost = resumeResultVo.getCanPost();
        Candidate candidate = new Candidate();
        candidate.setCanId(canId);
        candidate.setCanPhone(canPhone);
        candidate.setCanProName(canProName);
        candidate.setCanPost(canPost);
        int j = candidateMapper.updateCandidate(candidate);
        if(i >=1 && j >= 1){
            return ResponseVo.success();
        }
        return ResponseVo.error(1,"数据更新失败");
    }

    /**
     * 通过ID查询简历审核结果
     * @param canId
     * @return
     */
    @Override
    public ResponseVo<Object> selectResumeResultVoById(Integer canId) {
        ResumeResultVo resumeResultVo = resumeMapper.selectResumeVoById(canId);
        return ResponseVo.success(resumeResultVo);
    }



}
