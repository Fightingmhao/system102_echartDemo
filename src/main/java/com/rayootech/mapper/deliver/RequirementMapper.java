package com.rayootech.mapper.deliver;

import com.rayootech.bean.Vo.RequirementPubVo;
import com.rayootech.bean.Vo.RequirementSearchVo;
import com.rayootech.bean.deliver.Requirement;

import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/24 14:56
 */
public interface RequirementMapper {
    /**
     * 添加需求发布信息
     * @param requirement
     * @return
     */
    public int insertRequirement(Requirement requirement);

    /**
     * 通过部门名称查询需求发布信息
     * @param reqDept
     * @return
     */
    public List<RequirementPubVo> selectRequirementPubVoList(String reqDept);

    /**
     * 某部门通过项目名称查询需求发布信息
     * @param requirementPubVo
     * @return
     */
    public List<RequirementPubVo> selectRequirementPubVoListByProName(RequirementPubVo requirementPubVo);

    /**
     * 通过ID查询需求发布信息
     * @param id
     * @return
     */
    public RequirementPubVo selectRequirementPubVoById(Integer id);

    /**
     * 更新需求发布信息
     * @param requirementPubVo
     * @return
     */
    public int updateRequirement(RequirementPubVo requirementPubVo);

    /**
     * 查询所有的部门
     * @return
     */
    public List<String> selectReqDept();

    /**
     * 查询所有的需求发布信息
     * @param requirementSearchVo
     * @return
     */
    public List<RequirementSearchVo> selectRequirementAll(RequirementSearchVo requirementSearchVo);

    /**
     * 根据ID查询需求信息
     * @param reqId
     * @return
     */
    public RequirementSearchVo selectRequirementSearchVoById(Integer reqId);

    List<RequirementPubVo> selectSaleRequirementPubVoList(String dataScope);
}
