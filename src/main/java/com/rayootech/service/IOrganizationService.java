package com.rayootech.service;

import com.rayootech.bean.Org;
import com.rayootech.bean.Organization;
import com.rayootech.bean.Vo.TreeSelect;
import com.rayootech.resultInfo.ResponseVo;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * 人员基本信息Service接口
 *
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/10 13:19
 */
public interface IOrganizationService {


    public ResponseVo<Object> insertOrganizations(List<Organization> list) throws ParseException;

    public ResponseVo<Object> importTemplate() throws IOException;

    public ResponseVo<Object> test() throws IOException;

    List<Org> selectOrgList(Org org);

    List<Org> seachPostByOrgId(Long orgId);


    List<TreeSelect> buildOrgTreeSelect(List<Org> orgs);


    /**
     * 校验部门名称是否唯一
     *
     * @param org 部门信息
     * @return 结果
     */
    public String checkOrgNameUnique(Org org);

    /**
     * 新增保存部门信息
     *
     * @param org 部门信息
     * @return 结果
     */
    public int insertOrg(Org org);


    /**
     * 是否存在部门子节点
     *
     * @param orgId 部门ID
     * @return 结果
     */
    public boolean hasChildByOrgId(Long orgId);

    /**
     * 查询部门是否存在用户
     *
     * @param orgId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkOrgExistUser(Long orgId);


    /**
     * 删除部门管理信息
     *
     * @param orgId 部门ID
     * @return 结果
     */
    public int deleteOrgById(Long orgId);


    //查询详细信息
    public Org selectOrgById(Long orgId);



    /**
     * 修改保存部门信息
     *
     * @param org 部门信息
     * @return 结果
     */
    public int updateOrg(Org org);

    ResponseVo<Object> getDetNa();

    ResponseVo<Object> getDeptByUser(String name);

}
