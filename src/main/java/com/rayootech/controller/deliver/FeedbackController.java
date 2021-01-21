package com.rayootech.controller.deliver;


import com.rayootech.bean.Vo.FeedbackResultVo;
import com.rayootech.bean.Vo.FeedbackVo;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 20:03
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * 查询需要面试的人
     * @param currentPage
     * @param pageSize
     * @param feedbackVo
     * @return
     */
    @GetMapping("/list")
    public ResponseVo<Object> selectFeedbackVo(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                      @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, FeedbackVo feedbackVo){
        return feedbackService.selectFeedbackVo(feedbackVo ,currentPage,pageSize);
    }

    @PostMapping("/add")
    public ResponseVo<Object> insertProject(@RequestBody FeedbackVo feedbackVo){
        return feedbackService.insertFeedback(feedbackVo);
    }

    /**
     * 查询面试结果
     * @param currentPage
     * @param pageSize
     * @param feedbackResultVo
     * @return
     */
    @PostMapping("/selectFeedbackResult")
    public ResponseVo<Object> selectFeedbackResult(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                   @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                   FeedbackResultVo feedbackResultVo){
        return feedbackService.selectFeedbackResult(feedbackResultVo,currentPage,pageSize);
    }

    @GetMapping("/listAll")
    public ResponseVo<Object> selectFeedbackAll(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                               @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, FeedbackVo feedbackVo){
        return feedbackService.selectFeedbackAll(feedbackVo ,currentPage,pageSize);
    }
}
