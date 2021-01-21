package com.rayootech.mapper;


import com.rayootech.bean.Org;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrgMapper {
    int deleteByPrimaryKey(Long orgId);

    int insert(Org record);

    int insertSelective(Org record);

    Org selectByPrimaryKey(Long orgId);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);



    List<Org> selectOrgList(Org org);



    Org checkOrgNameUnique(@Param("orgName") String orgName, @Param("parentId") Long parentId);

    /**
     * 是否存在子节点
     *
     * @param orgId 部门ID
     * @return 结果
     */
    public int hasChildByOrgId(Long orgId);

    /**
     * 查询部门是否存在用户
     *
     * @param orgId 部门ID
     * @return 结果
     */
    public int checkOrgExistUser(Long orgId);


    /**
     * 根据ID查询所有子部门
     *
     * @param orgId 部门ID
     * @return 部门列表
     */
    public List<Org> selectChildrenOrgById(Long orgId);

    /**
     * 修改子元素关系
     *
     * @param orgs 子元素
     * @return 结果
     */
    public int updateDeptChildren(@Param("orgs") List<Org> orgs);

    List<String> getDeptNa();

    String getDeptByUser(String name);


}