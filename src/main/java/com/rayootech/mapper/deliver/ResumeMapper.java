package com.rayootech.mapper.deliver;

import com.rayootech.bean.Vo.ResumeResultVo;
import com.rayootech.bean.deliver.ResumeCheck;

import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 22:20
 */
public interface ResumeMapper {

    public int insertResumecheck(ResumeCheck resumeCheck);

    public ResumeCheck selectResumeByCanId(Integer canId);

    /**
     * 更新简历审核结果
     * @param resumeResultVo
     * @return
     */
    public int updateResumecheck(ResumeResultVo resumeResultVo);



    /**
     * 批量插入简历审核结果
     * @param list
     * @return
     */
    public int insertResumecheckBatch(List<ResumeCheck> list);

    /**
     * 查询简历审核结果
     * @param resumeResultVo
     * @return
     */
    List<ResumeResultVo> selectResumeResultVo(ResumeResultVo resumeResultVo);

    /**
     * 通过ID查询简历审核结果
     * @param canId
     * @return
     */
    public ResumeResultVo selectResumeVoById(Integer canId);

    /**
     * 销售查看简历审核结果
     * @param resumeResultVo
     * @return
     */
    List<ResumeResultVo> selectSaleResumeResultVo(ResumeResultVo resumeResultVo);
}
