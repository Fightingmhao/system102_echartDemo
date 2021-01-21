package com.rayootech.service.deliver.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.RequirementPubVo;
import com.rayootech.bean.Vo.RequirementSearchVo;
import com.rayootech.bean.deliver.Requirement;
import com.rayootech.mapper.deliver.ProjectMapper;
import com.rayootech.mapper.deliver.RequirementMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IRequirementService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import com.rayootech.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 10:09
 */
@Service
public class RequirementServiceImpl implements IRequirementService {
    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private RequirementMapper requirementMapper;

    @Autowired
    private HttpServletRequest request;

    /**
     * 添加需求发布信息
     * @param requirementPubVo
     * @return
     */
    @Override
    public ResponseVo<Object> insertRequiment(RequirementPubVo requirementPubVo) {
        Date date = new Date();
        String ipAddr = IpUtil.getIpAddr(request);
        String proName = requirementPubVo.getProName();
        Integer id = projectMapper.selectProIdByProName(proName);

        Requirement requirement = new Requirement();
        requirement.setReqDept(requirementPubVo.getReqDept());
        requirement.setReqPost(requirementPubVo.getReqPost());
        requirement.setReqCount(requirementPubVo.getReqCount());
        requirement.setReqTech(requirementPubVo.getReqTech());
        requirement.setReqDuty(requirementPubVo.getReqDuty());
        requirement.setReqJobadress(requirementPubVo.getReqJobadress());
        requirement.setReqViewadress(requirementPubVo.getReqViewadress());
        requirement.setReqWorkyear(requirementPubVo.getReqWorkyear());
        requirement.setReqOfferlow(requirementPubVo.getReqOfferlow());
        requirement.setReqOfferhigh(requirementPubVo.getReqOfferhigh());
        requirement.setReqSalarylow(requirementPubVo.getReqSalarylow());
        requirement.setReqSalaryhigh(requirementPubVo.getReqSalaryhigh());
        requirement.setReqState(requirementPubVo.getReqState());
        requirement.setReqPubState(0);
        requirement.setReqCreatetime(date);
        requirement.setReqIp(requirementPubVo.getReqIp());
        requirement.setProId(id);

        int i = requirementMapper.insertRequirement(requirement);
        if(i == 1){
            return ResponseVo.success();
        }
        return ResponseVo.error(1,"数据插入失败");
    }

    /**
     * 通过部门名称查看需求发布信息
     * @param uName
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<Object> selectRequirementPubVoList(String uName, Integer currentPage, Integer pageSize) {
        List<RequirementPubVo> list = null;
//1、查询当前登录人的部门类别
        String type = dataScopeServiceImp.getDeptype(uName);
        if(type.equals("X")){
            //2、如果是销售，先查权限
            String dataScope = dataScopeServiceImp.getDataScope(uName);
            //3、根据权限查出项目
            PageHelper.startPage(currentPage, pageSize);
            list = requirementMapper.selectSaleRequirementPubVoList(dataScope);
        }else if(type.equals("J")){
            String deptName = dataScopeServiceImp.getDeptName(uName);
            //如果是交付,查询部门名称
            PageHelper.startPage(currentPage, pageSize);
            list = requirementMapper.selectRequirementPubVoList(deptName);
        }else {
            PageHelper.startPage(currentPage, pageSize);
            list = requirementMapper.selectRequirementPubVoList("");
        }
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }

    /**
     * 通过ID查询需求发布信息
     * @param reqId
     * @return
     */
    @Override
    public ResponseVo<Object> selectRequirementPubVoById(Integer reqId) {
        RequirementPubVo requirementPubVo = requirementMapper.selectRequirementPubVoById(reqId);
        return ResponseVo.success(requirementPubVo);
    }

    /**
     * 更新需求发布信息
     * @param requirementPubVo
     * @return
     */
    @Override
    public ResponseVo<Object> updateRequirement(RequirementPubVo requirementPubVo) {
        int i = requirementMapper.updateRequirement(requirementPubVo);
        if(i == 1){
            return ResponseVo.success();
        }else {
            return ResponseVo.error(1,"数据更新失败");
        }
    }

    /**
     * 某部门通过项目名称查询需求发布信息
     * @param requirementPubVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<Object> selectRequirementPubVoListByProName(RequirementPubVo requirementPubVo, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<RequirementPubVo> list = requirementMapper.selectRequirementPubVoListByProName(requirementPubVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);

    }

    /**
     * 查询所有的部门名称
     * @return
     */
    @Override
    public ResponseVo<Object> selectReqDept() {
        List<String> list = requirementMapper.selectReqDept();
        return ResponseVo.success(list);
    };

    /**
     * 查看需求发布信息
     * @param requirementSearchVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<Object> selectRequirementSearchVo(RequirementSearchVo requirementSearchVo, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<RequirementSearchVo> list = requirementMapper.selectRequirementAll(requirementSearchVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }

    /**
     * 通过ID查询需求信息
     * @param reqId
     * @return
     */
    @Override
    public ResponseVo<Object> selectRequirementSearchVoById(Integer reqId) {
        RequirementSearchVo requirementSearchVo = requirementMapper.selectRequirementSearchVoById(reqId);
        return ResponseVo.success(requirementSearchVo);
    }

}
