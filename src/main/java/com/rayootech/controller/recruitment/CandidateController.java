package com.rayootech.controller.recruitment;

import com.rayootech.bean.Vo.CandidateVo;
import com.rayootech.bean.recruitment.Candidate;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.recruitment.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 20:46
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private ICandidateService candidateService;

    /**
     * 查询候选人推荐列表
     */
    @GetMapping("/listCan")
    public ResponseVo<Object> list(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                   @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                   Candidate candidate) {
        return candidateService.selectCandidateList(currentPage,pageSize,candidate);
    }


    /**
     * 新增候选人推荐
     */
    @PostMapping("/addCan")
    public ResponseVo<Object> add(CandidateVo candidateVo) throws Exception {
        return candidateService.insertCandidate(candidateVo);
    }

    /**
     * 获取候选人推荐详细信息
     */
    @GetMapping("/selectCanById")
    public ResponseVo<Object> getInfo(@RequestParam Integer canId)
    {
        return ResponseVo.success(candidateService.selectCandidateById(canId));
    }

    /**
     * 修改候选人推荐
     */
    @PutMapping("/updateCan")
    public ResponseVo<Object> edit(CandidateVo candidateVo) throws Exception {

        return candidateService.updateCandidate(candidateVo);
    }

    /**
     * 获取候选人推荐详细信息
     */
    @PostMapping("/selectResumeById/{canId}")
    public ResponseVo<Object> getResume(@PathVariable Integer canId)
    {
        return ResponseVo.success(candidateService.selectResumeById(canId));
    }

}
