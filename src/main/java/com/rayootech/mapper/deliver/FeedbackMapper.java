package com.rayootech.mapper.deliver;

import com.rayootech.bean.Vo.FeedbackResultVo;
import com.rayootech.bean.Vo.FeedbackVo;
import com.rayootech.bean.deliver.Feedback;

import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 19:30
 */
public interface FeedbackMapper {
    public int insertFeedback(Feedback feedback);

    /**
     * 查询需要面试的人
     * @param feedbackVo
     * @return
     */
    public List<FeedbackVo> selectFeedbackVo(FeedbackVo feedbackVo);

    /**
     * 查询面试结果
     * @param feedbackResultVo
     * @return
     */
    public List<FeedbackResultVo> selectFeedBackResult(FeedbackResultVo feedbackResultVo);

    /**
     * 根据部门查询面试结果
     * @param feedbackResultVo
     * @return
     */
    List<FeedbackResultVo> selectViewerByDeptName(FeedbackResultVo feedbackResultVo);

    /**
     * 查看面试结果及需要面试的人
     * @param feedbackVo
     * @return
     */
    List<FeedbackVo> selectFeedbackAll(FeedbackVo feedbackVo);


    List<FeedbackResultVo> selectSaleFeedBackResult(FeedbackResultVo feedbackResultVo);
}
