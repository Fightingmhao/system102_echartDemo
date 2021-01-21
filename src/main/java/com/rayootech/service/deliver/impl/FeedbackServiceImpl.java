package com.rayootech.service.deliver.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.FeedbackResultVo;
import com.rayootech.bean.Vo.FeedbackVo;
import com.rayootech.bean.deliver.Feedback;
import com.rayootech.mapper.deliver.FeedbackMapper;
import com.rayootech.mapper.recruitment.ViewMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IFeedbackService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 19:43
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService {

    @Autowired
    private ViewMapper viewMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;

    /**
     * 查询需要面试的人
     * @param feedbackVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<Object> selectFeedbackVo(FeedbackVo feedbackVo, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<FeedbackVo> list = feedbackMapper.selectFeedbackVo(feedbackVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<Object> insertFeedback(FeedbackVo feedbackVo) {
        Integer canId = feedbackVo.getCanId();
        Integer viewId = viewMapper.selectViewIdByCanId(canId);
        Feedback feedback = new Feedback();
        feedback.setBackName(feedbackVo.getViewName());
        feedback.setBackResult(feedbackVo.getBackResult());
        feedback.setBackEvalua(feedbackVo.getBackEvalua());
        feedback.setBackOfferLow(feedbackVo.getBackOfferLow());
        feedback.setBackOfferHigh(feedbackVo.getBackOfferHigh());
        feedback.setBackState(feedbackVo.getBackState());
        feedback.setBackCreatetime(new Date());
        feedback.setBackIp(feedbackVo.getBackIp());
        feedback.setViewId(viewId);
        int i = feedbackMapper.insertFeedback(feedback);
        if(i == 1){
            return ResponseVo.success();
        }
        return ResponseVo.error(1,"数据插入失败");
    }

    /**
     * 查询面试结果
     * @param feedbackResultVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<Object> selectFeedbackResult(FeedbackResultVo feedbackResultVo, Integer currentPage, Integer pageSize) {

        List<FeedbackResultVo> list = null;
        String deptype = dataScopeServiceImp.getDeptype(feedbackResultVo.getCanHremail());
        if(deptype.equals("X")){
            feedbackResultVo.setCanHremail(dataScopeServiceImp.getDataScope(feedbackResultVo.getCanHremail()));
            System.out.println(feedbackResultVo.getCanHremail());
            PageHelper.startPage(currentPage, pageSize);
            list = feedbackMapper.selectSaleFeedBackResult(feedbackResultVo);
            System.out.println(list);
        }else if(deptype.equals("J")){
//            feedbackResultVo.setCanHremail(null);
            feedbackResultVo.setCanDept(dataScopeServiceImp.getDeptName(feedbackResultVo.getCanHremail()));
            PageHelper.startPage(currentPage, pageSize);
            list = feedbackMapper.selectViewerByDeptName(feedbackResultVo);
        }else if(deptype.equals("Z")){
            feedbackResultVo.setCanHremail(dataScopeServiceImp.getDataScope(feedbackResultVo.getCanHremail()));
            PageHelper.startPage(currentPage, pageSize);
            list = feedbackMapper.selectFeedBackResult(feedbackResultVo);
        }else {
            feedbackResultVo.setCanHremail(dataScopeServiceImp.getDataScope(feedbackResultVo.getCanHremail()));
            PageHelper.startPage(currentPage, pageSize);
            list = feedbackMapper.selectFeedBackResult(feedbackResultVo);
        }
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }

    /**
     * 查看需要面试的人及面试结果
     * @param feedbackVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<Object> selectFeedbackAll(FeedbackVo feedbackVo, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<FeedbackVo> list = feedbackMapper.selectFeedbackAll(feedbackVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }


}
