package com.rayootech.mapper.recruitment;

import com.rayootech.bean.Vo.CanVo;
import com.rayootech.bean.Vo.ResumeCheckVo;
import com.rayootech.bean.recruitment.Candidate;

import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 16:04
 */
public interface CandidateMapper {
    /**
     * 查询未审核候选人信息
     * @param resumeCheckVo
     * @return
     */
    public List<Candidate> selectCanInfoByDeptName(ResumeCheckVo resumeCheckVo);


    public List<Candidate> selectCanByDeptName(String deptName);

    public int updateCandidateVo(Candidate candidate);

    public List<Candidate> selectViewer(String canHrEmail);

    public List<Candidate> selectViewerByDeptName(String deptName);

    public List<Candidate> selectCandidateAll();


    /**
     * 查询候选人推荐列表
     *
     * @param candidate
     * @return 候选人推荐集合
     */
    List<Candidate> selectCandidateList( Candidate candidate);

    /**
     * 新增候选人推荐
     *
     * @param candidate 候选人推荐
     * @return 结果
     */
    int insertCandidate(Candidate candidate);

    /**
     * 查询候选人推荐
     *
     * @param canId 候选人推荐ID
     * @return 候选人推荐
     */
    Candidate selectCandidateById(Integer canId);


    /**
     * 修改候选人推荐
     *
     * @param candidate 候选人推荐
     * @return 结果
     */
    int updateCandidate(Candidate candidate);

    /**
     * 批量修改候选人推荐
     *
     * @param candidate 候选人推荐
     * @return 结果
     */
    int updateCandidates(List<Candidate> candidate);

    /**
     * 更新项目表里面的项目名称
     * @param canVo
     */
    void updateCan(CanVo canVo);

    List<Candidate> selectCandidateListBySale(Candidate candidate);
}
