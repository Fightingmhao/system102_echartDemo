package com.rayootech.service.serviceImpl;

import com.rayootech.bean.Org;
import com.rayootech.bean.Organization;
import com.rayootech.bean.Vo.TreeSelect;
import com.rayootech.config.Global;
import com.rayootech.constant.Constants;
import com.rayootech.mapper.OrgMapper;
import com.rayootech.mapper.OrganizationMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.IOrganizationService;
import com.rayootech.utils.FileUtils;
import com.rayootech.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 人员基本信息Service业务层处理
 *
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/10 13:20
 */

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;


    @Autowired
    OrgMapper orgMapper;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



    @Override
    public ResponseVo<Object> insertOrganizations(List<Organization> list) throws ParseException {
        int i = organizationMapper.insertOrganizations(list);

        //如果插入成功，则继续
        if(i > 0 ){



            //拿到组织架构表
            List<Organization> allOrganizations = organizationMapper.getAllOrganizations();

            /*
            * 将组织架构表中的信息拆成三个部分，分别插入到dept部门表、post岗位表、user用户表
            * */
            //1、插入到dept部门表，将dept部门表先补充完毕

            for (Organization organization : allOrganizations) {

                String deptName = organization.getDeptName();
                String deptFather = organization.getDeptFather();

//                if(deptMapper.selectByDeptName(deptName) == null){
//                    Dept dept = new Dept();
//                    dept.setDeptName(deptName);
//                    deptMapper.insertSelective(dept);
//                }
//                if(deptMapper.selectByDeptName(deptFather) == null){
//                    Dept dept = new Dept();
//                    dept.setDeptName(deptFather);
//                    deptMapper.insertSelective(dept);
//                }
            }





            //2、插入post岗位表，将其补充完毕

            //3、插入到user用户表，上面两个表有了数据之后才能完善user用户表



            return ResponseVo.success();
        }
        return ResponseVo.error(1,"数据插入失败");
    }

    @Override
    public ResponseVo<Object> importTemplate() throws IOException {
        String path = Global.getProfile() + "/组织架构表模板.xlsx";
        File file = new File(path);
        return ResponseVo.success(FileUtils.msg(file));
    }

    @Override
    public ResponseVo<Object> test()  {

            //拿到组织架构表
            List<Organization> allOrganizations = organizationMapper.getAllOrganizations();

            /*
             * 将组织架构表中的信息拆成三个部分，分别插入到dept部门表、post岗位表、user用户表
             * */
            //1、插入到dept部门表，将dept部门表先补充完毕

            //先插入deptName
            for (Organization organization : allOrganizations) {

                String deptName = organization.getDeptName();
                String deptFather = organization.getDeptFather();

//                if(deptMapper.selectByDeptName(deptName) == null){
//                    Dept dept = new Dept();
//                    dept.setDeptName(deptName);
//                    deptMapper.insertSelective(dept);
//                }
//                if(deptMapper.selectByDeptName(deptFather) == null){
//                    Dept dept = new Dept();
//                    dept.setDeptName(deptFather);
//                    deptMapper.insertSelective(dept);
//                }
            }

            //再插入deptFather
        for (Organization organization : allOrganizations) {
//            if(organization.getDeptFather().equals(organization.getPostFather())){
//                Long deptFatherId = deptMapper.selectByDeptName(organization.getDeptFather()).getDeptId();//得到上级部门id
//                Dept dept = deptMapper.selectByDeptName(organization.getDeptFather());
//                dept.setDeptFather(deptFatherId);
//                int i = deptMapper.updateByPrimaryKeySelective(dept);
//                if(i == 0){
//                    ResponseVo.error(ResponseEnum.ERROR);
//                }
//            }
//
//            Long deptFatherId = deptMapper.selectByDeptName(organization.getDeptFather()).getDeptId();//得到上级部门id
//            Dept dept = deptMapper.selectByDeptName(organization.getDeptName());
//            dept.setDeptFather(deptFatherId);
//            int i = deptMapper.updateByPrimaryKeySelective(dept);
//            if(i == 0){
//                ResponseVo.error(ResponseEnum.ERROR);
//            }


        }





            //2、插入post岗位表，将其补充完毕

            //3、插入到user用户表，上面两个表有了数据之后才能完善user用户表


        return ResponseVo.success();
    }





    @Override
    public List<Org> selectOrgList(Org org)
    {
        return orgMapper.selectOrgList(org);
    }


    @Override
    public List<Org> seachPostByOrgId(Long orgId)
    {
        return orgMapper.selectChildrenOrgById(orgId);
    }

    @Override
    public List<TreeSelect> buildOrgTreeSelect(List<Org> orgs) {
        List<TreeSelect> selects = new ArrayList<>();
        //生成菜单树
        for (Org org:orgs) {
            if (org.getParentId() == 0){
                selects.add(new TreeSelect(buildOrgTree(orgs,org)));
            }
        }
        return selects;
    }




    /**
     * 生成菜单递归树
     * @param orgs
     * @param org
     * @return
     */
    Org buildOrgTree(List<Org> orgs,Org org){
        Boolean flag = false;
        for (Org org1:orgs) {

            if (org.getOrgId() == org1.getParentId()){
                //判断有无子层
                flag = true;
                buildOrgTree(orgs,org1);
            }

            if (org.getChildren() == null){
                org.setChildren(new ArrayList<Org>());
            }
            if(flag){
                org.getChildren().add(org1);
                flag = false;
            }

        }
        return org;
    }



    /**
     * 校验部门名称是否唯一
     *
     * @param org 部门信息
     * @return 结果
     */
    @Override
    public String checkOrgNameUnique(Org org) {
        Long orgId = StringUtils.isNull(org.getOrgId()) ? -1L : org.getOrgId();
        Org info = orgMapper.checkOrgNameUnique(org.getOrgName(), org.getParentId());
        if (StringUtils.isNotNull(info) && info.getOrgId().longValue() != orgId.longValue())
        {
            return Constants.NOT_UNIQUE;
        }
        return Constants.UNIQUE;
    }

    /**
     * 新增保存部门信息
     *
     * @param org 部门信息
     * @return 结果
     */
    @Override
    public int insertOrg(Org org)
    {
        Org info = orgMapper.selectByPrimaryKey(org.getParentId());

        org.setAncestors(info.getAncestors() + "," + org.getParentId());
        org.setCreateTime(new Date());
        return orgMapper.insert(org);
    }


    /**
     * 是否存在子节点
     *
     * @param orgId 部门ID
     * @return 结果
     */
    @Override
    public boolean hasChildByOrgId(Long orgId)
    {
        int result = orgMapper.hasChildByOrgId(orgId);
        return result > 0 ? true : false;
    }


    /**
     * 查询部门是否存在用户
     *
     * @param orgId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkOrgExistUser(Long orgId)
    {
        int result = orgMapper.checkOrgExistUser(orgId);
        return result > 0 ? true : false;
    }


    /**
     * 删除部门管理信息
     *
     * @param orgId 部门ID
     * @return 结果
     */
    @Override
    public int deleteOrgById(Long orgId)
    {
        return orgMapper.deleteByPrimaryKey(orgId);
    }


    @Override
    public Org selectOrgById(Long orgId)
    {
        return orgMapper.selectByPrimaryKey(orgId);
    }


    /**
     * 修改保存部门信息
     *
     * @param org 部门信息
     * @return 结果
     */
    @Override
    public int updateOrg(Org org)
    {
        Org newParentDept = orgMapper.selectByPrimaryKey(org.getParentId());
        Org oldDept = orgMapper.selectByPrimaryKey(org.getOrgId());
        if (StringUtils.isNotNull(newParentDept) && StringUtils.isNotNull(oldDept))
        {
            String newAncestors = newParentDept.getAncestors() + "," + newParentDept.getOrgId();
            String oldAncestors = oldDept.getAncestors();
            org.setAncestors(newAncestors);
            updateDeptChildren(org.getOrgId(), newAncestors, oldAncestors);
        }
        int result = orgMapper.updateByPrimaryKeySelective(org);
//        if (UserConstants.DEPT_NORMAL.equals(org.getStatus()))
//        {
//            // 如果该部门是启用状态，则启用该部门的所有上级部门
//            updateParentDeptStatus(org);
//        }
        return result;
    }

    /**
     * 修改子元素关系
     *
     * @param orgId 被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateDeptChildren(Long orgId, String newAncestors, String oldAncestors)
    {
        List<Org> children = orgMapper.selectChildrenOrgById(orgId);
        for (Org child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            orgMapper.updateDeptChildren(children);
        }
    }

    @Override
    public ResponseVo<Object> getDetNa() {
        return ResponseVo.success(orgMapper.getDeptNa());
    }

    @Override
    public ResponseVo<Object> getDeptByUser(String name) {
        return ResponseVo.success(orgMapper.getDeptByUser(name));
    }



}
