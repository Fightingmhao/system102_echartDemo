package com.rayootech.service.recruitment;

import com.rayootech.bean.Vo.InterviewVo;
import com.rayootech.bean.Vo.ViewResultVo;
import com.rayootech.bean.recruitment.View;
import com.rayootech.resultInfo.ResponseVo;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 14:05
 */
public interface IViewService {
    /**
     * 查询需要预约面试的候选人
     * @param interviewVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseVo<Object> selectViewer(InterviewVo interviewVo, Integer currentPage, Integer pageSize);

    public ResponseVo<Object> insertView(InterviewVo interviewVo);

    /**
     * 查询面试信息
     * @param viewResultVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseVo<Object> selectViewResult(ViewResultVo viewResultVo, Integer currentPage, Integer pageSize);

    /**
     * 通过ID查询面试信息
     * @param canId
     * @return
     */
    public ResponseVo<Object> selectViewResultById(Integer canId);

    /**
     * 更新面试信息
     * @param view
     * @return
     */
    public ResponseVo<Object> updateView(View view);
}
