package com.rayootech.mapper;

import com.rayootech.bean.Role;
import com.rayootech.bean.Vo.RoleMenu;

import java.util.List;
import java.util.Set;


/**
 * 角色信息Mapper接口
 * 
 * @author tww
 * @date 2020-11-16
 */
public interface RoleMapper 
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
     * @return 角色信息集合
     */
    public List<Role> selectRoleList(String roleName,String status,String roleKey,String bigenTime,String endTime);

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
     * 删除角色信息
     * 
     * @param roleId 角色信息ID
     * @return 结果
     */
    public int deleteRoleById(Long roleId);

    /**
     * 批量删除角色信息
     * 
     * @param roleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleByIds(Long[] roleIds);

    int selectRoleByName(String roleName);

    void insertRoleAndMenu(List<RoleMenu> list);

    void deteleRoleAndMenu(Long roleId);

    int checkRole(Long roleId);

    Set<String> queryPremssion(long userId);

    void updateRoleStatus(Long roleId, String status);


    List<Role> selectRoleList02();

    List<Role> getRoleList(Long userId);

    int updateDataScope(Role role);



}
