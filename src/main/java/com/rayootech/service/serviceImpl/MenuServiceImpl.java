package com.rayootech.service.serviceImpl;

import com.rayootech.bean.Menu;
import com.rayootech.bean.UserDto;
import com.rayootech.bean.Vo.MetaVo;
import com.rayootech.bean.Vo.RouterVo;
import com.rayootech.bean.Vo.TreeSelect;
import com.rayootech.mapper.MenuMapper;
import com.rayootech.mapper.UserDtoMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 菜单权限Service业务层处理
 * 
 * @author aw
 * @date 2020-11-10
 */
@Service
public class MenuServiceImpl implements IMenuService
{
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserDtoMapper userDtoMapper;
    /**
     * 查询菜单权限
     * 
     * @param menuId 菜单权限ID
     * @return 菜单权限
     */
    @Override
    public Menu selectMenuById(Long menuId)
    {
        return menuMapper.selectMenuById(menuId);
    }

    /**
     * 查询菜单权限列表
     * @return 菜单权限
     */
    @Override
    public List<Menu> selectMenuList(Menu menu,Long id)
    {
        //如果是admin返回所有菜单权限
        return menuMapper.selectMenuList(menu);
    }

    /**
     * 新增菜单权限
     *
     * @param menu 菜单权限
     * @return 结果
     */
    @Override
    public ResponseVo<Object> insertMenu(Menu menu)
    {
        //判断上级菜单的类型  M 下可以是 M，C    C下只能是 F   F不能添加
        if(menu.getParentId() != 0){
            String type = menuMapper.getParentType(menu.getParentId());
            if(type.equals("M")&&(!(menu.getMenuType().equals("M")||menu.getMenuType().equals("C")))){
                return ResponseVo.error(1, "目录下只能添加菜单或目录");
            }

            if(type.equals("C")&& !menu.getMenuType().equals("F")){
                return ResponseVo.error(1, "菜单下只能添加按钮");
            }

            if(type.equals("F")){
                return ResponseVo.error(1, "按钮不可在添加子级");
            }
        }
        if(menu.getMenuType().equals("F")&&menu.getParentId() == 0){
            return ResponseVo.error(1, "按钮只能添加到菜单下");
        }
        //查询新增菜单名字是否重复
        int i = menuMapper.queryMenuByName(menu.getMenuName());
        if(i > 0){
            return ResponseVo.error(1, "菜单名称重复");
        }
        menu.setCreateTime(new Date());
        menuMapper.insertMenu(menu);
        return ResponseVo.success("添加成功");
    }

    /**
     * 修改菜单权限
     *
     * @param menu 菜单权限
     * @return 结果
     */
    @Override
    public ResponseVo<Object> updateMenu(Menu menu)
    {

        Menu menu1 = menuMapper.selectMenuById(menu.getMenuId());
        //判断是否修改了菜单的名字
        if(!menu.getMenuName().equals(menu1.getMenuName())){
            if(menuMapper.queryMenuByName(menu.getMenuName()) > 0 ){
                return ResponseVo.error(1, "菜单名称重复");
            }
        }

        if(menu.getParentId() != 0){
            String type = menuMapper.getParentType(menu.getParentId());
            if(type.equals("M")&& !(menu.getMenuType().equals("M")||menu.getMenuType().equals("C"))){
                return ResponseVo.error(1, "目录下只能添加菜单或目录");
            }

            if(type.equals("C")&& !menu.getMenuType().equals("F")){
                return ResponseVo.error(1, "菜单下只能添加按钮");
            }

            if(type.equals("F")){
                return ResponseVo.error(1, "按钮不可在添加子级");
            }
        }

        if(menu.getMenuType().equals("F")&&menu.getParentId() == 0){
            return ResponseVo.error(1, "按钮只能添加到菜单下");
        }

        menu.setUpdateTime(new Date());
        menuMapper.updateMenu(menu);
        return ResponseVo.success("修改成功");
    }


    /**
     * 删除菜单权限
     * 
     * @param menuIds 删除的菜单权限ID
     * @return 结果
     */
    @Override
    public int deleteMenuByIds(Long menuIds)
    {
        if (menuMapper.queryMenuByParent(menuIds) > 0){
            return 0;
        }
        return menuMapper.deleteMenuById(menuIds);
    }

    @Override
    public List<TreeSelect> buildMenuTreeSelect(List<Menu> menus) {
        List<TreeSelect> selects = new ArrayList<>();
        //生成菜单树
        for (Menu menu:menus) {
            if (menu.getParentId() == 0){
             selects.add(new TreeSelect(buildMenuTree(menus,menu)));
            }
        }
        return selects;
    }

    @Override
    public List<Integer> selectMenuListByRoleId(Long roleId) {
        return menuMapper.selectMenuListByRoleId(roleId);
    }

    @Override
    public List<Menu> selectMenuTreeByUserId(long userId) {

        List<Menu> menus = new ArrayList<>();
        //判断是否是管理员
        if(userId == 1){
            menus =  menuMapper.queryMenuAll();
        }else {
            menus = menuMapper.queryMenuByUserId(userId);
        }
        List<Menu> selects =new ArrayList<>();
        //生成菜单树
        for (Menu menu:menus) {
            if (menu.getParentId() == 0){
                selects.add(buildMenuTree(menus,menu));
            }
        }
        return selects;
    }

    @Override
    public List<RouterVo> buildMenus(List<Menu> menus) {
        return buildRouterTree(menus);
    }

    @Override
    public Long getUserId(String username) {
        UserDto userDto = userDtoMapper.getUserByUsername(username);
        return userDto.getUserId();
    }

    /**
     * 生成菜单递归树
     * @param menus
     * @param menu
     * @return
     */
    Menu buildMenuTree(List<Menu> menus,Menu menu){
        Boolean flag = false;
         for (Menu menu1:menus) {

             if (menu.getMenuId() == menu1.getParentId()){
                 //判断有无子层
                 flag = true;
                 buildMenuTree(menus,menu1);
             }

             if (menu.getChildren() == null){
                 menu.setChildren(new ArrayList<Menu>());
             }
             if(flag){
                 menu.getChildren().add(menu1);
                 flag = false;
             }

         }
         return menu;
    }

    /**
     *
     */
   List<RouterVo> buildRouterTree(List<Menu> menus){
       List<RouterVo> routerVos = new ArrayList<>();
       menus.forEach(menu -> {
           //转换成路由
           RouterVo routerVo = new RouterVo();
           routerVo.setName(menu.getPath());
           routerVo.setPath( menu.getPath());
           if(menu.getComponent() == null ||menu.getComponent().equals("")){
               menu.setComponent("Layout");
           }
           routerVo.setComponent(menu.getComponent());
           routerVo.setHidden((menu.getVisible().equals("0"))?false:true);
           MetaVo metaVo = new MetaVo();
           metaVo.setIcon(menu.getIcon());
           metaVo.setTitle(menu.getMenuName());
           metaVo.setNoCache(menu.getIsCache()== 0? false:true);
           routerVo.setAlwaysShow(true);
           routerVo.setMeta(metaVo);
           //1、判断有没有子级
           List<Menu> children = menu.getChildren();
           List<RouterVo> routerVos1 = new ArrayList<>();
           if(children.size() > 0){
               //继续遍历
               routerVos1 = buildRouterTree(children);
           }
           routerVo.setChildren(routerVos1);
           routerVos.add(routerVo);
       });
       return routerVos;
    }

}
