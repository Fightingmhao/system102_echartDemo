package com.rayootech.controller.deliver;

import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.ProVo;
import com.rayootech.bean.Vo.ProjectInfoVo;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/24 15:31
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    /**
     * 插入项目信息
     * @param projectInfoVo
     * @return
     */
    @PostMapping("/add")
    public ResponseVo<Object> insertProject(@RequestBody ProjectInfoVo projectInfoVo){
        return projectService.insertProject(projectInfoVo);
    }

    /**
     * 查看项目信息
     * @param currentPage
     * @param pageSize
     * @param proVo
     * @return
     */
    @GetMapping("/list")
    public ResponseVo<PageInfo<ProjectInfoVo>> selectProjectInfoVoList(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, ProVo proVo){
        return projectService.selectProjectInfoVoList(proVo,currentPage,pageSize);
    }


    /**
     * 通过ID查询项目信息
     * @param proId
     * @return
     */
     @GetMapping("/queryByProId/{proId}")
    public ResponseVo<Object> selectProjectInfoVoByProId(@PathVariable Integer proId){
        return projectService.selectProjectInfoVoByProId(proId);
    }

    /**
     * 更新项目信息
     * @param projectInfoVo
     * @return
     */
    @PutMapping("/update")
    public ResponseVo<Object> update(@RequestBody ProjectInfoVo projectInfoVo){
        return projectService.updateProject(projectInfoVo);
    }

    /**
     * 通过部门名称查询项目名称
     * @param deptName
     * @return
     */
    @PostMapping("/listProName/{deptName}")
    public ResponseVo<Object> selectProNameByDeptName(@PathVariable String deptName){
        return projectService.selectProNameByDeptName(deptName);
    }

    /**
     * 通过项目名称查询岗位名称
     * @param proName
     * @return
     */
    @PostMapping("/listPostName/{proName}")
    public ResponseVo<Object> selectPostNameByProName(@PathVariable String proName){
        return projectService.selectPostNameByProName(proName);
    }

    /**
     * 查询所有的项目名称
     * @return
     */
    @GetMapping("/proName")
    public ResponseVo<Object> getProName(){
        return projectService.getProName();
    }

}
