package com.rayootech.service.recruitment.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.InterviewVo;
import com.rayootech.bean.Vo.ViewResultVo;
import com.rayootech.bean.recruitment.View;
import com.rayootech.mapper.recruitment.ViewMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.recruitment.IViewService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import com.rayootech.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 14:07
 */
@Service
public class ViewServiceImpl implements IViewService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ViewMapper viewMapper;

    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;


    /**
     * 查询需要预约面试的候选人
     * @param interviewVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<Object> selectViewer(InterviewVo interviewVo, Integer currentPage, Integer pageSize) {
        interviewVo.setCanHremail(dataScopeServiceImp.getDataScope(interviewVo.getCanHremail()));
        PageHelper.startPage(currentPage, pageSize);
        List<InterviewVo> list = viewMapper.selectViewer(interviewVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<Object> insertView(InterviewVo interviewVo) {
        Integer canId = interviewVo.getCanId();
        String canName = interviewVo.getCanName();
        Date viewTime = interviewVo.getViewTime();
        Integer viewState = interviewVo.getViewState();
        Date date = new Date();
        String ipAddr = IpUtil.getIpAddr(request);
        View view = new View(canId,canName,viewTime,date,ipAddr,viewState);
        int i = viewMapper.insertView(view);
        if(i == 1){
            return ResponseVo.success();
        }
        return ResponseVo.error(1,"数据插入失败");
    }

    /**
     * 查询面试信息
     * @param viewResultVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<Object> selectViewResult(ViewResultVo viewResultVo, Integer currentPage, Integer pageSize) {
        viewResultVo.setCanHremail(dataScopeServiceImp.getDataScope(viewResultVo.getCanHremail()));
        PageHelper.startPage(currentPage, pageSize);
        List<ViewResultVo> list = viewMapper.selectViewResult(viewResultVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }

    /**
     * 通过ID查询面试信息
     * @param canId
     * @return
     */
    @Override
    public ResponseVo<Object> selectViewResultById(Integer canId) {
        ViewResultVo viewResultVo = viewMapper.selectViewResultById(canId);
        return ResponseVo.success(viewResultVo);
    }

    /**
     * 更新面试信息
     * @param view
     * @return
     */
    @Override
    public ResponseVo<Object> updateView(View view) {
        int i = viewMapper.updateView(view);
        if(i == 1) {
            return ResponseVo.success();
        }else {
            return ResponseVo.error(1,"数据更新失败");
        }
    }
}
