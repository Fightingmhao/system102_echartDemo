package com.rayootech.service.deliver;

import com.rayootech.bean.Vo.RequirementPubVo;
import com.rayootech.bean.Vo.RequirementSearchVo;
import com.rayootech.resultInfo.ResponseVo;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 10:09
 */
public interface IRequirementService {
    /**
     * 添加需求发布信息
     * @param requirementPubVo
     * @return
     */
    public ResponseVo<Object> insertRequiment(RequirementPubVo requirementPubVo);

    /**
     * 通过邮箱查看需求发布信息
     * @param uName
     * @param currentPage
     * @param pageSize
     * @return
     */
    ResponseVo<Object> selectRequirementPubVoList(String uName,Integer currentPage, Integer pageSize);

    /**
     * 通过ID查询需求发布信息
     * @param reqId
     * @return
     */
    ResponseVo<Object> selectRequirementPubVoById(Integer reqId);


    /**
     * 更新需求发布信息
     * @param requirementPubVo
     * @return
     */
    public ResponseVo<Object> updateRequirement(RequirementPubVo requirementPubVo);

    /**
     * 某部门通过项目名称查询需求发布信息
     * @param requirementPubVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseVo<Object> selectRequirementPubVoListByProName(RequirementPubVo requirementPubVo,Integer currentPage, Integer pageSize);

    /**
     * 查询所有的部门名称
     * @return
     */
    public ResponseVo<Object> selectReqDept();

    /**
     * 查询需求信息
     * @param currentPage
     * @param pageSize
     * @return
     */
    public ResponseVo<Object> selectRequirementSearchVo(RequirementSearchVo requirementSearchVo, Integer currentPage, Integer pageSize);


    /**
     * 通过ID查询需求信息
     * @param reqId
     * @return
     */
    public ResponseVo<Object> selectRequirementSearchVoById(Integer reqId);
}
