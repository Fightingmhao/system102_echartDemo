package com.rayootech.controller.recruitment;

import com.rayootech.bean.Vo.InterviewVo;
import com.rayootech.bean.Vo.ViewResultVo;
import com.rayootech.bean.recruitment.View;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.recruitment.IViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 14:41
 */
@RestController
@RequestMapping("/view")
public class ViewController {
    @Autowired
    private IViewService viewService;

    /**
     * 查询需要预约面试的候选人
     * @param currentPage
     * @param pageSize
     * @param interviewVo
     * @return
     */
    @GetMapping("/list")
    public ResponseVo<Object> selectViewer(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                           @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, InterviewVo interviewVo){
        return viewService.selectViewer(interviewVo,currentPage,pageSize);
    }

    @PostMapping("/add")
    public ResponseVo<Object> add(@RequestBody InterviewVo interviewVo)
    {
       return viewService.insertView(interviewVo);
    }


    /**
     * 查询面试信息
     * @param currentPage
     * @param pageSize
     * @param viewResultVo
     * @return
     */
    @GetMapping("/listViewResult")
    public ResponseVo<Object> selectViewResult(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                               @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, ViewResultVo viewResultVo){
        return viewService.selectViewResult(viewResultVo,currentPage,pageSize);
    }

    /**
     * 通过ID查询面试信息
     * @param canId
     * @return
     */
    @GetMapping("/listViewResultById/{canId}")
    public ResponseVo<Object> selectViewResultById(@PathVariable Integer canId){
        return viewService.selectViewResultById(canId);
    }

    /**
     * 更新面试信息
     * @param view
     * @return
     */
    @PutMapping("/updateView")
    public ResponseVo<Object> updateView(@RequestBody View view){
        return viewService.updateView(view);
    }
}
