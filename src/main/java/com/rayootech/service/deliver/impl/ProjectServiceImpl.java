package com.rayootech.service.deliver.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.CanVo;
import com.rayootech.bean.Vo.ProVo;
import com.rayootech.bean.Vo.ProjectInfoVo;
import com.rayootech.bean.deliver.Project;
import com.rayootech.mapper.deliver.ProjectMapper;
import com.rayootech.mapper.recruitment.CandidateMapper;
import com.rayootech.mapper.sale.SaleMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IProjectService;
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
 * @created 2020/11/24 15:25
 */

@Service
public class ProjectServiceImpl implements IProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SaleMapper saleMapper;

    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;

    @Autowired
    private CandidateMapper candidateMapper;

    /**
     * 新增项目信息
     * @param projectInfoVo
     * @return
     */
    @Override
    public ResponseVo<Object> insertProject(ProjectInfoVo projectInfoVo) {
        Date date = new Date();
        String ipAddr = IpUtil.getIpAddr(request);
        String cusCode = saleMapper.selectCusCodeByCusName(projectInfoVo.getSaleCusname());

        Project project = new Project();
        project.setProDept(projectInfoVo.getProDept());
        project.setProCuscode(cusCode);
        project.setProCusState(0);
        project.setProCode(projectInfoVo.getProCode());
        project.setProName(projectInfoVo.getProName());
        project.setProState(projectInfoVo.getProState());
        project.setProType(projectInfoVo.getProType());
        project.setProPeriod(projectInfoVo.getProPeriod());
        project.setProScale(projectInfoVo.getProScale());
        project.setProRelegation(projectInfoVo.getProRelegation());
        project.setProCusground(projectInfoVo.getProCusground());
        project.setProViewgress(projectInfoVo.getProViewgress());
        project.setProIp(projectInfoVo.getProIp());
        project.setProCreatetime(date);

        Boolean proNameFlag = true;
        List<String> proNameList = projectMapper.getProName();
        for(String proName : proNameList){
            if(projectInfoVo.getProName().equals(proName)){
                proNameFlag = false;
                break;
            }
        }

        Boolean proCodeFlag = true;
        List<String> proCodeList = projectMapper.getProCode();
        for(String proCode : proCodeList){
            if(projectInfoVo.getProCode().equals(proCode)){
                proCodeFlag = false;
                break;
            }
        }

        if(proNameFlag && proCodeFlag){
            int i = projectMapper.insertProject(project);
            if(i == 1){
                return ResponseVo.success();
            }else {
                return ResponseVo.error(4,"数据插入失败");
            }
        }else if(proNameFlag){
            return ResponseVo.error(1,"数据插入失败,项目编码已存在");
        }else if(proCodeFlag){
            return ResponseVo.error(2,"数据插入失败,项目名称已存在");
        }else {
            return ResponseVo.error(3,"数据插入失败,项目名称和项目编码已存在");
        }


    }

    /**
     * 查看项目信息
     * @param proVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVo<PageInfo<ProjectInfoVo>> selectProjectInfoVoList(ProVo proVo, Integer currentPage, Integer pageSize) {
        List<ProjectInfoVo> list = null;
        String uName = proVo.getUName();
        //1、查询当前登录人的部门类别
        String type = dataScopeServiceImp.getDeptype(uName);
        if(type.equals("X")){
            //2、如果是销售，先查权限
            String dataScope = dataScopeServiceImp.getDataScope(uName);
            //3、根据权限查出项目
            PageHelper.startPage(currentPage, pageSize);
            list = projectMapper.selectSaleProjectInfoVoList(dataScope,proVo.getSaleName());
        }else if(type.equals("J")){
            //如果是交付,查询部门名称
            String deptName = dataScopeServiceImp.getDeptName(uName);
            proVo.setDeptName(deptName);
            PageHelper.startPage(currentPage, pageSize);
            list = projectMapper.selectProjectInfoVoList(proVo);
        }else {
            PageHelper.startPage(currentPage, pageSize);
            list = projectMapper.selectProjectInfoVoList(null);
        }
        PageInfo pageInfo = new PageInfo<>(list);//将数据库中查到的数据当做构造方法的参数传进去
        pageInfo.setList(list);//将最终形成的vo对象集合传进去
        return ResponseVo.success(pageInfo);//最后返回内定的属性格式


    }

    /**
     * 通过ID查看项目信息
     * @param proId
     * @return
     */
    @Override
    public ResponseVo<Object> selectProjectInfoVoByProId(Integer proId) {
        ProjectInfoVo projectInfoVo = projectMapper.selectProjectInfoVoByByProId(proId);
        return ResponseVo.success(projectInfoVo);
    }

    /**
     * 更新项目信息
     * @param projectInfoVo
     * @return
     */
    @Override
    public ResponseVo<Object> updateProject(ProjectInfoVo projectInfoVo) {
        /**
         * 更新项目表里面的项目名称
         */
        String pName = projectMapper.selectProjectInfoVoByByProId(projectInfoVo.getProId()).getProName();
        CanVo canVo = new CanVo();
        canVo.setOldCanProName(pName);
        canVo.setNewCanProName(projectInfoVo.getProName());
        candidateMapper.updateCan(canVo);

        ProjectInfoVo info = projectMapper.selectProjectInfoVoByByProId(projectInfoVo.getProId());
        Boolean proNameFlag = true;
        List<String> proNameList = projectMapper.getProName();
        for(String proName : proNameList){
            if(projectInfoVo.getProName().equals(info.getProName())){
                proNameFlag = true;
                break;
            }else if(projectInfoVo.getProName().equals(proName)){
                proNameFlag = false;
                break;
            }
        }

        Boolean proCodeFlag = true;
        List<String> proCodeList = projectMapper.getProCode();
        for(String proCode : proCodeList){
            if(projectInfoVo.getProCode().equals(info.getProCode())){
                proCodeFlag = true;
                break;
            }else if(projectInfoVo.getProCode().equals(proCode)){
                proCodeFlag = false;
                break;
            }
        }

        if(proNameFlag && proCodeFlag){
            int i = projectMapper.updateProject(projectInfoVo);
            if(i == 1){
                return ResponseVo.success();
            }else {
                return ResponseVo.error(4,"数据更新失败");
            }
        }else if(proNameFlag){
            return ResponseVo.error(1,"数据更新失败,项目编码已存在");
        }else if(proCodeFlag){
            return ResponseVo.error(2,"数据更新失败,项目名称已存在");
        }else {
            return ResponseVo.error(3,"数据更新失败,项目名称和项目编码已存在");
        }

    }

    /**
     * 通过部门名称查询项目名称
     * @param deptName
     * @return
     */
    @Override
    public ResponseVo<Object> selectProNameByDeptName(String deptName) {
        List<String> list = projectMapper.selectProNameByDeptName(deptName);
        return ResponseVo.success(list);
    }

    /**
     * 查询所有的项目名称
     * @return
     */
    @Override
    public ResponseVo<Object> getProName() {
        List<String> list  = projectMapper.getProName();
        return ResponseVo.success(list);
    }

    /**
     * 通过项目名称查询岗位名称
     * @param proName
     * @return
     */
    @Override
    public ResponseVo<Object> selectPostNameByProName(String proName) {
        List<String> list = projectMapper.selectPostNameByProName(proName);
        return ResponseVo.success(list);
    }

}
