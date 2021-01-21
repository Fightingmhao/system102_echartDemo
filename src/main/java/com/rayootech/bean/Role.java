package com.rayootech.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 角色信息对象 role
 * 
 * @author tww
 * @date 2020-11-16
 */
public class Role {
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    private Long roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色权限字符串 */
    private String roleKey;

    /** 显示顺序 */
    private Integer roleSort;

    /** 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限） */
    private String dataScope;

    /** 菜单树选择项是否关联显示 */
    private Integer menuCheckStrictly;

    /** 部门树选择项是否关联显示 */

    private Integer deptCheckStrictly;

    /** 角色状态（0正常 1停用） */
    private String status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }
    public void setRoleName(String roleName) 
    {
        this.roleName = roleName;
    }

    public String getRoleName() 
    {
        return roleName;
    }
    public void setRoleKey(String roleKey) 
    {
        this.roleKey = roleKey;
    }

    public String getRoleKey() 
    {
        return roleKey;
    }
    public void setRoleSort(Integer roleSort) 
    {
        this.roleSort = roleSort;
    }

    public Integer getRoleSort() 
    {
        return roleSort;
    }
    public void setDataScope(String dataScope) 
    {
        this.dataScope = dataScope;
    }

    public String getDataScope() 
    {
        return dataScope;
    }
    public void setMenuCheckStrictly(Integer menuCheckStrictly) 
    {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    public Integer getMenuCheckStrictly() 
    {
        return menuCheckStrictly;
    }
    public void setDeptCheckStrictly(Integer deptCheckStrictly) 
    {
        this.deptCheckStrictly = deptCheckStrictly;
    }

    public Integer getDeptCheckStrictly() 
    {
        return deptCheckStrictly;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleKey='" + roleKey + '\'' +
                ", roleSort=" + roleSort +
                ", dataScope='" + dataScope + '\'' +
                ", menuCheckStrictly=" + menuCheckStrictly +
                ", deptCheckStrictly=" + deptCheckStrictly +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
