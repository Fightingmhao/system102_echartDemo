package com.rayootech.service.recruitment.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.TalksResultVo;
import com.rayootech.bean.Vo.TalksVo;
import com.rayootech.bean.recruitment.Talks;
import com.rayootech.mapper.recruitment.TalksMapper;
import com.rayootech.mapper.recruitment.TalksVoMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.recruitment.ITalksService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import com.rayootech.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/1 13:58
 */
@Service
public class TalksServiceImpl implements ITalksService {
    @Autowired
    private TalksMapper talksMapper;
    @Autowired
    private TalksVoMapper talksVoMapper;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;

    @Override
    public ResponseVo<Object> selectTalksList(Integer currentPage, Integer pageSize, TalksVo talksVo) {
        talksVo.setCanHremail(dataScopeServiceImp.getDataScope(talksVo.getCanHremail()));
        PageHelper.startPage(currentPage,pageSize);
        List<Talks> talksList = talksVoMapper.selectTalksList(talksVo);
        PageInfo pageInfo = new PageInfo(talksList);
        pageInfo.setList(talksList);
        return ResponseVo.success(pageInfo);

    }

    @Override
    public List<TalksVo> select() {
        return talksVoMapper.select();
    }

    @Override
    public ResponseVo<Object> insertTalks(TalksVo talksVo) {
        Talks talks = new Talks();
        talks.setCanId(talksVo.getCanId());
        talks.setTalksId(talksVo.getBackId());
        talks.setBackId(talksVo.getBackId());
        talks.setTalksName(talksVo.getBackName());
        talks.setTalksSalary(talksVo.getTalksSalary());
        talks.setTalksTime(talksVo.getTalksTime());
        talks.setTalksState(talksVo.getTalksState());
        talks.setTalksResult(talksVo.getTalksResult());
        talks.setTalksStaffTime(talksVo.getTalksStaffTime());
        talks.setTalksCreatetime(new Date());
        IpUtil ipUtil = new IpUtil();
        talks.setTalksIp(talksVo.getTalksIp());
        int i = talksMapper.insertTalks(talks);
        if (i>0) return ResponseVo.success(0,"添加成功");
        return ResponseVo.error(1,"添加失败");
    }

    @Override
    public ResponseVo<Object> getTalksById(Long talksId) {
        return ResponseVo.success(talksMapper.getTalksById(talksId));
    }

    /**
     * 更新谈判结果
     * @param talks
     * @return
     */
    @Override
    public ResponseVo<Object> updateTalks(Talks talks) {
        talks.setTalksCreatetime(new Date());
        int i = talksMapper.updateTalks(talks);
        if (i>0) return ResponseVo.success(0,"修改成功");
        return ResponseVo.error(1,"修改失败");
    }

    @Override
    public ResponseVo<Object> getOffer() {
        return ResponseVo.success(talksMapper.getOffer());
    }

    /**
     * 查询谈判结果
     * @param talksResultVo
     * @return
     */
    @Override
    public ResponseVo<Object> selectTalksResult(Integer currentPage, Integer pageSize,TalksResultVo talksResultVo) {
        //查询部门
        String deptype = dataScopeServiceImp.getDeptype(talksResultVo.getCanHremail());
        if(deptype.equals("J") ){
            String deptName = dataScopeServiceImp.getDeptName(talksResultVo.getCanHremail());
            talksResultVo.setCanDept(deptName);
            talksResultVo.setCanHremail(null);

        }else if(deptype.equals("Z")){
            talksResultVo.setCanHremail(dataScopeServiceImp.getDataScope(talksResultVo.getCanHremail()));
        }
        PageHelper.startPage(currentPage,pageSize);
        List<TalksResultVo> list = talksMapper.selectTalksResult(talksResultVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }

    /**
     * 通过ID查询谈判结果
     * @param talksId
     * @return
     */
    @Override
    public ResponseVo<Object> selectTalksResultById(Integer talksId) {
        TalksResultVo talksResultVo = talksMapper.selectTalksResultById(talksId);
        return ResponseVo.success(talksResultVo);
    }


}
