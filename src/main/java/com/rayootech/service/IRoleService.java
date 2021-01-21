package com.rayootech.service;

import com.rayootech.bean.Role;
import com.rayootech.bean.Vo.LoginVo;
import com.rayootech.bean.Vo.RoleAddVo;
import com.rayootech.resultInfo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * 角色信息Service接口
 * 
 * @author tww
 * @date 2020-11-16
 */
public interface IRoleService 
{
    /**
     * 查询角色信息
     * 
     * @param roleId 角色信息ID
     * @return 角色信息
     */
    public Role selectRoleById(Long roleId);

    /**
     * 查询角色信息列表
     * 
     * @param role 角色信息
     * @return 角色信息集合
     */
    public List<Role> selectRoleList(Role role,String bigenTime,String endTime);

    /**
     * 新增角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    public int insertRole(Role role);

    /**
     * 修改角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    public int updateRole(Role role);



    /**
     * 删除角色信息信息
     * 
     * @param roleId 角色信息ID
     * @return 结果
     */
    public int deleteRoleById(Long roleId);

    /**
     * 根据角色名和权限字符查询角色数量
     * @param roleName

     * @return
     */
    int selectRoleByName(String roleName);

    /**
     *
     * @param roleId
     * @param menuIds
     */
    void insertRoleAndMenu(Long roleId, String[] menuIds);

    int check(RoleAddVo role);

    void updateRoleMenu(RoleAddVo role);

    Set<String> getPremssion(long userId);

    int changeStatus(RoleAddVo role);

    Set<String> getRolePermission(LoginVo user);


    ResponseVo updateDataScope(Role role);
}
