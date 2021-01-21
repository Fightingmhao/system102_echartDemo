package com.rayootech.service.deliver;

import com.rayootech.bean.Vo.FeedbackResultVo;
import com.rayootech.bean.Vo.FeedbackVo;
import com.rayootech.resultInfo.ResponseVo;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 19:39
 */
public interface IFeedbackService {
    /**
     * 查询需要面试的人
     * @param feedbackVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseVo<Object> selectFeedbackVo(FeedbackVo feedbackVo, Integer currentPage, Integer pageSize);

    public ResponseVo<Object> insertFeedback(FeedbackVo feedbackVo);

    /**
     * 查询面试结果
     * @param feedbackResultVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseVo<Object> selectFeedbackResult(FeedbackResultVo feedbackResultVo, Integer currentPage, Integer pageSize);

    /**
     * 查看需要面试的人及面试结果
     * @param feedbackVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseVo<Object> selectFeedbackAll(FeedbackVo feedbackVo, Integer currentPage, Integer pageSize);
}
