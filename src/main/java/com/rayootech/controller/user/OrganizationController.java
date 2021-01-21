package com.rayootech.controller.user;

import com.rayootech.bean.Org;
import com.rayootech.bean.Organization;
import com.rayootech.bean.Vo.TreeSelect;
import com.rayootech.constant.Constants;
import com.rayootech.resultInfo.ResponseEnum;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.IMenuService;
import com.rayootech.service.IOrganizationService;
import com.rayootech.utils.StringUtils;
import com.rayootech.utils.excelUtils.ReadExcel;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/10 13:20
 */
@RestController
@RequestMapping("org")
public class OrganizationController {
    @Autowired
    private IOrganizationService organizationService;

    @Autowired
    private IMenuService menuService;



    @PostMapping("/addBatch")
    public ResponseVo<Object> addBatch(@RequestParam("file")MultipartFile file) throws ParseException {
        ReadExcel readExcel = new ReadExcel(file);
        List<Organization> value = readExcel.getValue();
        return organizationService.insertOrganizations(value);
    }

    @GetMapping("/importTemplate")
    public ResponseVo<Object> importTemplate() throws IOException {
        return organizationService.importTemplate();
    }



    @GetMapping("/test")
    public ResponseVo<Object> test() throws IOException {
        return organizationService.test();
    }



    /**
     * 获取部门列表
     */
    @GetMapping("/list")
    public ResponseVo<Object> list(Org org)
    {
        List<Org> orgs = organizationService.selectOrgList(org);
        return ResponseVo.success(orgs);
    }


    /**
     * 根据部门id查询其下级部门和岗位
     *
     */
    @GetMapping("/seachPostByOrgId/{orgId}")
    public ResponseVo<Object> seachPostByOrgId(@PathVariable(value = "orgId", required = false) Long orgId)
    {
        List<Org> orgs = organizationService.seachPostByOrgId(orgId);
        return ResponseVo.success(orgs);
    }


    /**
     * 查询部门列表（排除节点）
     */
    @GetMapping("/list/exclude/{orgId}")
    public ResponseVo<Object> excludeChild(@PathVariable(value = "orgId", required = false) Long orgId)
    {
        List<Org> orgs = organizationService.selectOrgList(new Org());
        Iterator<Org> it = orgs.iterator();
        while (it.hasNext())
        {
            Org d = (Org) it.next();
            if (d.getOrgId().intValue() == orgId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), orgId + ""))
            {
                it.remove();
            }
        }
        return ResponseVo.success(orgs);
    }


    /**
     * 获取组织下拉树列表
     */
    @GetMapping("/treeselect")
    public ResponseVo<Object> treeselect(Org org)
    {
        List<Org> orgs = organizationService.selectOrgList(org);
        List<TreeSelect> list = organizationService.buildOrgTreeSelect(orgs);
        return ResponseVo.success(list);
    }



    /**
     * 新增部门
     */
    @PostMapping("/addOrg")
    public ResponseVo<Object> add(@Validated @RequestBody Org org)
    {
        if (Constants.NOT_UNIQUE.equals(organizationService.checkOrgNameUnique(org)))
        {
            return ResponseVo.error("新增部门'" + org.getOrgName() + "'失败，部门名称已存在");
        }

        if(organizationService.insertOrg(org) == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.successByMsg("插入成功");
    }


    /**
     * 删除部门
     */
    @DeleteMapping("/delete/{orgId}")
    public ResponseVo<Object> remove(@PathVariable Long orgId)
    {
        if (organizationService.hasChildByOrgId(orgId))
        {
            return ResponseVo.error("存在下级部门,不允许删除");
        }
        if (organizationService.checkOrgExistUser(orgId))
        {
            return ResponseVo.error("部门存在用户,不允许删除");
        }

        if(organizationService.deleteOrgById(orgId) == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.successByMsg("删除成功");
    }


    /**
     * 根据部门编号获取详细信息
     */
    @GetMapping(value = "/getInfo/{orgId}")
    public ResponseVo<Object> getInfo(@PathVariable Long orgId)
    {
        return ResponseVo.success(organizationService.selectOrgById(orgId));
    }


    /**
     * 修改部门
     */
    @PutMapping("/updateOrg")
    public ResponseVo<Object> edit(@Validated @RequestBody Org org)
    {
        if (Constants.NOT_UNIQUE.equals(organizationService.checkOrgNameUnique(org)))
        {
            return ResponseVo.error("修改部门'" + org.getOrgName() + "'失败，部门名称已存在");
        }

        if(organizationService.updateOrg(org) == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.successByMsg("更新成功");
    }

    @GetMapping("/getDeptName")
    public ResponseVo<Object> getDeptNa(){
        return organizationService.getDetNa();
    }

    @GetMapping("/getDeptByUser/{name}")
    public ResponseVo<Object> getDeptByUser(@PathVariable String name){
        return organizationService.getDeptByUser(name);
    }





}
