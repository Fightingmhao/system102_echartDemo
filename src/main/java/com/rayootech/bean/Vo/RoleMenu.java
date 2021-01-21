package com.rayootech.bean.Vo;

/**
 * 角色菜单权限
 */
public class RoleMenu {
    private Long RoleId;
    private String MenuId;


    public RoleMenu(Long roleId, String menuId) {
        RoleId = roleId;
        MenuId = menuId;
    }
    public RoleMenu() {
    }


    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
