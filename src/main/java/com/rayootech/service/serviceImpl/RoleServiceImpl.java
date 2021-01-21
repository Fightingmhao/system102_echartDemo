package com.rayootech.service.serviceImpl;

import com.rayootech.bean.Role;
import com.rayootech.bean.UserDto;
import com.rayootech.bean.Vo.LoginVo;
import com.rayootech.bean.Vo.RoleAddVo;
import com.rayootech.bean.Vo.RoleMenu;
import com.rayootech.mapper.RoleMapper;
import com.rayootech.mapper.UserDtoMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 角色信息Service业务层处理
 * 
 * @author tww
 * @date 2020-11-16
 */
@Service
public class RoleServiceImpl implements IRoleService
{
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserDtoMapper userDtoMapper;
    /**
     * 查询角色信息
     * 
     * @param roleId 角色信息ID
     * @return 角色信息
     */
    @Override
    public Role selectRoleById(Long roleId)
    {
        return roleMapper.selectRoleById(roleId);
    }

    /**
     * 查询角色信息列表
     * 
     * @param role 角色信息
     * @return 角色信息
     */
    @Override
    public List<Role> selectRoleList(Role role,String bigenTime,String endTime)
    {
        return roleMapper.selectRoleList(role.getRoleName(),role.getStatus(),role.getRoleKey(),bigenTime,endTime);
    }

    /**
     * 新增角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public int insertRole(Role role)
    {
        role.setCreateTime(new Date());
        return roleMapper.insertRole(role);
    }

    /**
     * 修改角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public int updateRole(Role role)
    {
        role.setUpdateTime(new Date());
        return roleMapper.updateRole(role);
    }


    /**
     * 删除角色信息信息
     * 
     * @param roleId 角色信息ID
     * @return 结果
     */
    @Override
    public int deleteRoleById(Long roleId)
    {
        //1、查询角色是否分配
        if(roleMapper.checkRole(roleId) > 0 ){
            return 0;
        }
        //删除权限表
        roleMapper.deteleRoleAndMenu(roleId);
        //删除数据表

        //删除角色信息

        return roleMapper.deleteRoleById(roleId);
    }

    @Override
    public int selectRoleByName(String roleName) {
        if(roleMapper.selectRoleByName(roleName) > 0){
            return 1;
        }
        return 0;
    }

    @Override
    public void insertRoleAndMenu(Long roleId, String[] menuIds) {
        List<RoleMenu> list = new ArrayList<>();
        if(menuIds.length < 1){
            return;
        }
        for (String s :menuIds
             ) {
            list.add(new RoleMenu(roleId,s));
        }

        roleMapper.insertRoleAndMenu(list);
    }

    @Override
    public int check(RoleAddVo role) {
        //1、判断是否修改了名字和权限字符
        Role role1 = roleMapper.selectRoleById(role.getRoleId());
        //名字改变？
        if(!role1.getRoleName().equals(role.getRoleName())){
            //查询数据库，是否重名
           if(roleMapper.selectRoleByName(role.getRoleName()) > 0) {
               return 1;
           }
        }
        return 0;
    }

    @Override
    public void updateRoleMenu(RoleAddVo role) {
        //1、删除已有的
        roleMapper.deteleRoleAndMenu(role.getRoleId());
        if(role.getMenuIds().length < 1){return;}
        //2、插入新的
        insertRoleAndMenu(role.getRoleId(),role.getMenuIds());
    }

    @Override
    public Set<String> getPremssion(long userId) {

        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (userId == 1l)
        {
            perms.add("*:*:*");
        }
        else
        {
            //1、查询角色列表
            perms = roleMapper.queryPremssion(userId);
        }
        return perms;
    }

    @Override
    public int changeStatus(RoleAddVo role) {
        //1、查询角色是否分配
        if(role.getStatus().equals("1") &&roleMapper.checkRole(role.getRoleId()) > 0 ){
            return 0;
        }
        //修改状态
        roleMapper.updateRoleStatus(role.getRoleId(),role.getStatus());
        return 1;
    }

    @Override
    public Set<String> getRolePermission(LoginVo user) {

        UserDto userDto = userDtoMapper.getUserByUsername(user.getUsername());
        return getPremssion(userDto.getUserId());

    }

    @Override
    public ResponseVo updateDataScope(Role role) {

        return ResponseVo.success(roleMapper.updateDataScope(role));
    }


}
