package com.rayootech.service.deliver;

import com.rayootech.bean.Vo.ResumeCheckVo;
import com.rayootech.bean.Vo.ResumeResultVo;
import com.rayootech.resultInfo.ResponseVo;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 16:29
 */
public interface IResumeCheckService {
    /**
     * 查询未审核候选人信息
     * @param resumeCheckVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseVo<Object> selectCanInfoByDeptName(ResumeCheckVo resumeCheckVo, Integer currentPage, Integer pageSize);

    /**
     * 批量插入审核结果
     * @param resumeCheckVos
     * @return
     */
    ResponseVo<Object> insertResumeCheckBatch(ResumeCheckVo[] resumeCheckVos);

    /**
     * 查询简历审核结果
     * @param currentPage
     * @param pageSize
     * @param resumeResultVo
     * @return
     */
    ResponseVo<Object> selectResumeResultVo(Integer currentPage, Integer pageSize, ResumeResultVo resumeResultVo);


    ResponseVo<Object> insertResumeCheck();



    /**
     * 更新简历审核结果
     * @param resumeResultVo
     * @return
     */
    ResponseVo<Object> updateResumeCheck(ResumeResultVo resumeResultVo);

    /**
     * 通过ID查询简历审核结果
     * @param canId
     * @return
     */
    ResponseVo<Object> selectResumeResultVoById(Integer canId);
}
