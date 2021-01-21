package com.rayootech.controller.role;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Role;
import com.rayootech.bean.Vo.RoleAddVo;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * 角色信息Controller
 * 
 * @author tww
 * @date 2020-11-16
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    /**
     * 查询角色信息列表
     */
    @GetMapping("/list")
    public ResponseVo<Object> list(
            @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
            Role role,
            String beginTime,
            String endTime)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> listSec = roleService.selectRoleList(role,beginTime,endTime);
        PageInfo pageInfo = new PageInfo(listSec);
        pageInfo.setList(listSec);
        return ResponseVo.success(pageInfo);
    }


    /**
     * 获取角色信息详细信息
     */
    @GetMapping(value = "/queryById/{roleId}")
    public ResponseVo getInfo(@PathVariable("roleId") Long roleId)
    {
        return ResponseVo.success(roleService.selectRoleById(roleId));
    }

    /**
     * 新增角色信息
     */
    @PostMapping("/add")
    public ResponseVo add(@RequestBody RoleAddVo role)
    {
        //1、判断角色名，权限字符是否存在
        int i = roleService.selectRoleByName(role.getRoleName());
        if(i == 1){
            return ResponseVo.error(1,"角色名重复");
        }
        //插入角色信息
        Role role1 = new Role();
        role1.setRoleName(role.getRoleName());
        role1.setRoleKey(role.getRoleKey());
        role1.setDeptCheckStrictly(role.getDeptCheckStrictly() ? 0:1);
        role1.setMenuCheckStrictly(role.getMenuCheckStrictly() ? 0:1);
        role1.setStatus(role.getStatus());
        role1.setRoleSort(role.getRoleSort());
        roleService.insertRole(role1);
        //将角色与菜单权限绑定
        roleService.insertRoleAndMenu(role1.getRoleId(),role.getMenuIds());
        //角色与数据权限绑定
        return ResponseVo.success("成功");
    }

    /**
     * 修改角色信息
     */
    @PutMapping("/update")
    public ResponseVo edit(@RequestBody RoleAddVo role)
    {
        //判断修改是否合法
        int a = roleService.check(role);
        if(a == 1){
            return ResponseVo.error(a,"角色名重复");
        }

        //1、修改用户信息
        //插入角色信息
        Role role1 = new Role();
        role1.setRoleName(role.getRoleName());
        role1.setRoleId(role.getRoleId());
        role1.setRoleKey(role.getRoleKey());
        role1.setDeptCheckStrictly(role.getDeptCheckStrictly() ? 0:1);
        role1.setMenuCheckStrictly(role.getMenuCheckStrictly() ? 0:1);
        role1.setStatus(role.getStatus());
        role1.setRoleSort(role.getRoleSort());
        roleService.updateRole(role1);
        //插入菜单树权限
        roleService.updateRoleMenu(role);
        return ResponseVo.success();
    }

    /**
     * 删除角色信息
     */
	@DeleteMapping("/delete/{roleId}")
    public ResponseVo remove(@PathVariable Long roleId)
    {
        if(roleService.deleteRoleById(roleId) == 0){
            return ResponseVo.error(1,"角色已分配");
        }
        return ResponseVo.success();
    }

    /**
     * 获取用户的权限信息
     * @return
     */
    @PostMapping("/getPremssion")
    public ResponseVo getPremssion(){

        //获取当前用户的id
        long userId = 1l;
        //根据id取当前的用户权限列表
        Set<String> perms = roleService.getPremssion(userId);
        return ResponseVo.success(perms);
    }
    @PostMapping("/changeStatus")
    public ResponseVo changeStatus(@RequestBody RoleAddVo role){
//        int a = roleService.changeStatus(role);
        if(roleService.changeStatus(role) == 0){
            return ResponseVo.error(1,"角色已分配");
        }

        return ResponseVo.success();
    }

    /**
     * 修改数据权限
     * @param role
     * @return
     */
    @PutMapping("/dataScope")
    public ResponseVo updateDataScope(@RequestBody Role role){

        return roleService.updateDataScope(role);
    }

}
