package com.rayootech.service.deliver;

import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.ProVo;
import com.rayootech.bean.Vo.ProjectInfoVo;
import com.rayootech.resultInfo.ResponseVo;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/24 15:23
 */
public interface IProjectService {
    /**
     * 新增项目信息
     * @param projectInfoVo
     * @return
     */
    ResponseVo<Object> insertProject(ProjectInfoVo projectInfoVo);

    /**
     * 查看项目信息
     * @param proVo
     * @param currentPage
     * @param pageSize
     * @return
     */
    ResponseVo<PageInfo<ProjectInfoVo>> selectProjectInfoVoList(ProVo proVo, Integer currentPage, Integer pageSize);

    /**
     * 通过ID查询项目信息
     * @param proId
     * @return
     */
    ResponseVo<Object> selectProjectInfoVoByProId(Integer proId);

    /**
     * 更新项目信息
     * @param projectInfoVo
     */
    ResponseVo<Object> updateProject(ProjectInfoVo projectInfoVo);

    /**
     * 通过部门名称查询项目名称
     * @param deptName
     * @return
     */
    ResponseVo<Object> selectProNameByDeptName(String deptName);

    /**
     * 查询所有的项目名称
     * @return
     */
    ResponseVo<Object> getProName();

    /**
     * 通过项目名称查询岗位名称
     * @param proName
     * @return
     */
    ResponseVo<Object> selectPostNameByProName(String proName);
}
