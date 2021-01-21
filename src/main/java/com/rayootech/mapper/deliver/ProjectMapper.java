package com.rayootech.mapper.deliver;

import com.rayootech.bean.Vo.ProVo;
import com.rayootech.bean.Vo.ProjectInfoVo;
import com.rayootech.bean.deliver.Project;

import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/24 14:57
 */
public interface ProjectMapper {

    /**
     * 通过项目名称查询项目ID
     * @param proName
     * @return
     */
    Integer selectProIdByProName(String proName);

    /**
     * 插入项目信息
     * @param project
     * @return
     */
    int insertProject(Project project);

    /**
     * 查看所有的项目信息
     * @param proVo
     * @return
     */
    List<ProjectInfoVo> selectProjectInfoVoList(ProVo proVo);

    /**
     * 通过ID查看项目信息
     * @param proId
     * @return
     */
    ProjectInfoVo selectProjectInfoVoByByProId(Integer proId);

    /**
     * 更新项目信息
     * @param projectInfoVo
     * @return
     */
    int updateProject(ProjectInfoVo projectInfoVo);

    /**
     * 通过部门名称查询项目名称
     * @param deptName
     * @return
     */
    List<String> selectProNameByDeptName(String deptName);

    /**
     * 查询所有的项目名称
     * @return
     */
    List<String> getProName();

    /**
     * 查询所有的项目编码
     * @return
     */
    List<String> getProCode();


    List<ProjectInfoVo> selectSaleProjectInfoVoList(String dataScope,String saleName);

    /**
     * 通过项目名称查询岗位名称
     * @param proName
     * @return
     */
    List<String> selectPostNameByProName(String proName);

    List<String> getSaleproName(String dataScope);

    List<String> getsalepro(String hrEmail);

}
