package com.rayootech.controller.menu;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.rayootech.bean.Menu;
import com.rayootech.bean.Vo.RouterVo;
import com.rayootech.bean.Vo.TreeSelect;
import com.rayootech.constant.Constants;
import com.rayootech.form.UserOnlineForm;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 菜单权限Controller
 *
 * @author aw
 * @date 2020-11-10
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 查询菜单权限列表
     */
    @GetMapping("/list")
    public ResponseVo<List<Menu>> list(Menu menu) {
        //根据登录的用户查询菜单列表
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        Long userId = loginUser.getUser().getUserId();
        long userId = 0;
        List<Menu> menus = menuService.selectMenuList(menu, userId);
        return ResponseVo.success(menus);
    }

    /**
     * 新增菜单权限
     */
    @PostMapping("/add")
    public ResponseVo<Object> add(@RequestBody Menu menu) {
        return menuService.insertMenu(menu);
    }

    /**
     * 修改菜单权限
     */
    @PutMapping("/update")
    public ResponseVo<Object> edit(@RequestBody Menu menu) {
        return menuService.updateMenu(menu);

    }

    @GetMapping("/queryByID/{id}")
    public ResponseVo<Object> queryByID(@PathVariable Long id) {
        return ResponseVo.success(menuService.selectMenuById(id));
    }


    /**
     * 删除菜单权限
     */
    @DeleteMapping("/delete/{menuIds}")
    public ResponseVo<Object> remove(@PathVariable Long menuIds) {
        if (menuService.deleteMenuByIds(menuIds) == 0) {
            return ResponseVo.error(1, "存在子菜单");
        }
        return ResponseVo.success();
    }

    /**
     * 获取菜单下拉树列表
     */
    @GetMapping("/treeselect")
    public ResponseVo<Object> treeselect(Menu menu) {
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        Long userId = loginUser.getUser().getUserId();
        Long userId = 0l;
        List<Menu> menus = menuService.selectMenuList(menu, userId);
        List<TreeSelect> list = menuService.buildMenuTreeSelect(menus);
        return ResponseVo.success(list);
    }

    /**
     * 加载对应角色菜单列表树
     */
    @GetMapping(value = "/roleMenuTreeselect/{roleId}")
    public String roleMenuTreeselect(@PathVariable("roleId") Long roleId) {
        //查询当前角色的菜单列表
        List<Integer> list = menuService.selectMenuListByRoleId(roleId);
        Menu menu = new Menu();
        Long userId = 0l;
        List<Menu> menus = menuService.selectMenuList(menu, userId);
        List<TreeSelect> selects = menuService.buildMenuTreeSelect(menus);
        Map map = new HashMap<>();
        map.put("checkedKeys", list);
        map.put("menus", selects);
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("/getRouters")
    public ResponseVo<Object> getRouters(HttpServletRequest request) {


        String object = redisTemplate.opsForValue().get(Constants.LOGIN_TOKEN_KEY + request.getHeader("X-Token"));

        UserOnlineForm userOnlineForm = JSON.parseObject(object, UserOnlineForm.class);


        // 用户信息
        Long userId = menuService.getUserId(userOnlineForm.getUserName());
        //根据用户id 查询菜单树
        List<Menu> menus = menuService.selectMenuTreeByUserId(userId);
        //转换成前台的路由对象
        List<RouterVo> routers = menuService.buildMenus(menus);
//
        return ResponseVo.success(routers);

    }

}
