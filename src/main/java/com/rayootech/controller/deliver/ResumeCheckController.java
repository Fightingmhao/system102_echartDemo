package com.rayootech.controller.deliver;


import com.rayootech.bean.Vo.ResumeCheckVo;
import com.rayootech.bean.Vo.ResumeResultVo;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IResumeCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 16:39
 */
@RestController
@RequestMapping("/resume")
public class ResumeCheckController {
    @Autowired
    private IResumeCheckService resumeCheckService;


    /**
     * 查询未审核候选人信息
     * @param currentPage
     * @param pageSize
     * @param resumeCheckVo
     * @return
     */
    @GetMapping("/listCanInfo")
    public ResponseVo<Object> selectCanInfoByDeptName(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                  @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,ResumeCheckVo resumeCheckVo){
        return resumeCheckService.selectCanInfoByDeptName(resumeCheckVo,currentPage,pageSize);
    }

    /**
     * 批量插入简历审核结果
     * @param resumeCheckVos
     * @return
     */
    @PutMapping("addCanState")
    public ResponseVo<Object> updateCandidate(@RequestBody ResumeCheckVo[] resumeCheckVos){
        return resumeCheckService.insertResumeCheckBatch(resumeCheckVos);
    }

    /**
     * 查看简历审核结果
     * @param currentPage
     * @param pageSize
     * @param resumeResultVo
     * @return
     */
    @GetMapping("/getResumeResult")
    public ResponseVo<Object> selectResumeResultVo(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                   @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                   ResumeResultVo resumeResultVo){
        return resumeCheckService.selectResumeResultVo(currentPage,pageSize,resumeResultVo);
    }

    /**
     * 通过ID查询简历审核结果
     * @param canId
     * @return
     */
    @PostMapping("/getResumeById/{canId}")
    public ResponseVo<Object> selectResumeResultVo(@PathVariable Integer canId){
        return resumeCheckService.selectResumeResultVoById(canId);
    }

    /**
     * 更新简历审核结果
     * @param resumeResultVo
     * @return
     */
    @PutMapping("/updateResumecheck")
    public ResponseVo<Object> updateResumeCheck(@RequestBody ResumeResultVo resumeResultVo){
        return resumeCheckService.updateResumeCheck(resumeResultVo);
    }



}
