package com.rayootech.bean.Vo;

import java.util.Arrays;

public class RoleAddVo {

    private String[] deptIds;

    private String[] menuIds;

    /** 角色ID */
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public Boolean getMenuCheckStrictly() {
        return menuCheckStrictly;
    }

    public void setMenuCheckStrictly(Boolean menuCheckStrictly) {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    public Boolean getDeptCheckStrictly() {
        return deptCheckStrictly;
    }

    public void setDeptCheckStrictly(Boolean deptCheckStrictly) {
        this.deptCheckStrictly = deptCheckStrictly;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /** 角色名称 */
    private String roleName;

    /** 角色权限字符串 */
    private String roleKey;

    /** 显示顺序 */
    private Integer roleSort;

    /** 菜单树选择项是否关联显示 */
    private Boolean menuCheckStrictly;

    /** 部门树选择项是否关联显示 */

    private Boolean deptCheckStrictly;

    /** 角色状态（0正常 1停用） */
    private String status;

    public String[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String[] deptIds) {
        this.deptIds = deptIds;
    }

    public String[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String[] menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "RoleAddVo{" +
                "deptIds=" + Arrays.toString(deptIds) +
                ", menuIds=" + Arrays.toString(menuIds) +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleKey='" + roleKey + '\'' +
                ", roleSort=" + roleSort +
                ", menuCheckStrictly=" + menuCheckStrictly +
                ", deptCheckStrictly=" + deptCheckStrictly +
                ", status='" + status + '\'' +
                '}';
    }
}
