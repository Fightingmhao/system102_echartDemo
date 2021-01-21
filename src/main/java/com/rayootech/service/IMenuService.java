package com.rayootech.service;

import com.rayootech.bean.Menu;
import com.rayootech.bean.Vo.RouterVo;
import com.rayootech.bean.Vo.TreeSelect;
import com.rayootech.resultInfo.ResponseVo;

import java.util.List;

/**
 * 菜单权限Service接口
 * 
 * @author aw
 * @date 2020-11-10
 */
public interface IMenuService 
{
    /**
     * 查询菜单权限
     * 
     * @param menuId 菜单权限ID
     * @return 菜单权限
     */
    public Menu selectMenuById(Long menuId);

    /**
     * 查询菜单权限列表
     * 
     * @param menu 菜单权限
     * @return 菜单权限集合
     */
    public List<Menu> selectMenuList(Menu menu,Long id);

    /**
     * 新增菜单权限
     *
     * @param menu 菜单权限
     * @return 结果
     */
    public ResponseVo<Object> insertMenu(Menu menu);

    /**
     * 修改菜单权限
     *
     * @param menu 菜单权限
     * @return 结果
     */
    public ResponseVo<Object> updateMenu(Menu menu);

    /**
     * 批量删除菜单权限
     * 
     * @param menuIds 需要删除的菜单权限ID
     * @return 结果
     */
    public int deleteMenuByIds(Long menuIds);

    /**
     * 构建菜单树
     * @param menus
     * @return
     */
    List<TreeSelect> buildMenuTreeSelect(List<Menu> menus);

    /**
     * 查询当前角色的菜单权限
     * @param roleId
     * @return
     */
    List<Integer> selectMenuListByRoleId(Long roleId);

    /**
     *
     * @param userId
     * @return
     */
    List<Menu> selectMenuTreeByUserId(long userId);

    List<RouterVo> buildMenus(List<Menu> menus);

    Long getUserId(String username);
}
