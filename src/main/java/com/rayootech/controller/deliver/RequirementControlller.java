package com.rayootech.controller.deliver;

import com.rayootech.bean.Vo.RequirementPubVo;
import com.rayootech.bean.Vo.RequirementSearchVo;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 10:30
 */
@RestController
@RequestMapping("/requirement")
public class RequirementControlller {

    @Autowired
    private IRequirementService requirementService;

    /**
     * 添加需求发布信息
     * @param requirementPubVo
     * @return
     */
    @PostMapping("/add")
    public ResponseVo<Object> insertRequirement(@RequestBody RequirementPubVo requirementPubVo){
        return requirementService.insertRequiment(requirementPubVo);
    }

    /**
     * 根据邮箱查询需求发布信息
     * @param currentPage
     * @param pageSize
     * @param uName
     * @return
     */
    @GetMapping("/list")
    public ResponseVo<Object> selectRequirementPubVoList(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                         @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, String uName){
        return requirementService.selectRequirementPubVoList(uName,currentPage,pageSize);
    }

    /**
     * 通过ID查询需求发布信息
     * @param reqId
     * @return
     */
    @GetMapping("/queryById/{reqId}")
    public ResponseVo<Object> selectRequirementPubVoById(@PathVariable Integer reqId){
        return requirementService.selectRequirementPubVoById(reqId);
    };

    /**
     * 更新需求发布信息
     * @param requirementPubVo
     * @return
     */
    @PutMapping("/update")
    public ResponseVo<Object> update(@RequestBody RequirementPubVo requirementPubVo){
        return requirementService.updateRequirement(requirementPubVo);
    }

    /**
     * 某部门通过项目名称查询需求发布信息
     * @param currentPage
     * @param pageSize
     * @param requirementPubVo
     * @return
     */
    @GetMapping("/listByProName")
    public ResponseVo<Object> selectRequirementPubVoListByProName(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                         @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, RequirementPubVo requirementPubVo){
        return requirementService.selectRequirementPubVoListByProName(requirementPubVo,currentPage,pageSize);
    }

    /**
     * 查询所有的部门名称
     * @return
     */
    @GetMapping("/listReqDept")
    public ResponseVo<Object> selectReqDept(){
        return requirementService.selectReqDept();
    }

    /**
     * 查询需求信息
     * @param currentPage
     * @param pageSize
     * @param requirementSearchVo
     * @return
     * @throws ParseException
     */
    @GetMapping("/listSearch")
    public ResponseVo<Object> selectRequirementSearchVo(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                        @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, RequirementSearchVo requirementSearchVo) throws ParseException {
        return requirementService.selectRequirementSearchVo(requirementSearchVo,currentPage,pageSize);
    }

    /**
     * 通过ID查询需求信息
     * @param reqId
     * @return
     */
    @GetMapping("/getReqSearchById/{reqId}")
    public ResponseVo<Object> selectRequirementSearchVoById(@PathVariable Integer reqId){
        return requirementService.selectRequirementSearchVoById(reqId);
    }



}
