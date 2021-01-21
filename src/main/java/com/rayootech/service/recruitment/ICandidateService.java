package com.rayootech.service.recruitment;

import com.rayootech.bean.Vo.CandidateVo;
import com.rayootech.bean.recruitment.Candidate;
import com.rayootech.resultInfo.ResponseVo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 21:00
 */
public interface ICandidateService {



    /**
     * 查询候选人推荐列表
     *
     * @param candidate 候选人推荐
     * @return 候选人推荐集合
     */

    ResponseVo<Object> selectCandidateList(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                           @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                           Candidate candidate);

    /**
     * 新增候选人
     *
     * @param candidateVo 候选人
     * @return 结果
     */
    public ResponseVo<Object> insertCandidate(CandidateVo candidateVo) throws Exception;

    /**
     * 查询候选人推荐
     *
     * @param canId 候选人推荐ID
     * @return 候选人推荐
     */
    public Candidate selectCandidateById(Integer canId);

    /**
     * 修改候选人推荐
     *
     * @param candidateVo 候选人推荐
     * @return 结果
     */
    ResponseVo<Object> updateCandidate(CandidateVo candidateVo) throws Exception;

    String selectResumeById(Integer canId);

}
