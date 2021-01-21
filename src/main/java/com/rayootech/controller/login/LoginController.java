package com.rayootech.controller.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rayootech.bean.Vo.LoginVo;
import com.rayootech.constant.Constants;
import com.rayootech.form.UserOnlineForm;
import com.rayootech.resultInfo.ResponseEnum;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.IRoleService;
import com.rayootech.service.OnlineUserService;
import com.rayootech.service.serviceImpl.SpringDataUserDetailsService;
import com.rayootech.service.serviceImpl.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class LoginController {

    @Autowired
    SpringDataUserDetailsService userDetailsService;

    @Autowired
    TokenService tokenService;

    @Autowired
    OnlineUserService onlineUserService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Resource
    private AuthenticationManager authenticationManager;


    @PostMapping("/user/login")
    public Object login(@Valid @RequestBody LoginVo user, HttpServletResponse response){

//        System.out.println(user);
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        }catch (Exception e){
//            int a = 2/0;
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        JSONObject jsonObject = new JSONObject();

        User user1 = (User) authentication.getPrincipal();

        Collection<GrantedAuthority> authorities = user1.getAuthorities();//权限集合

        String token = tokenService.getToken(user1,user.getPassword());
        jsonObject.put("token", token);

        //将登陆的用户存入redis缓存中
        UserOnlineForm userOnlineForm = new UserOnlineForm();
        userOnlineForm.setUserName(user.getUsername());
        userOnlineForm.setTokenId(token);
        onlineUserService.saveOnlineUser(userOnlineForm);


//        Cookie cookie = new Cookie("token", token);
//        cookie.setPath("/");
//        response.addCookie(cookie);

//        return ResponseVo.success(ResponseEnum.SUCCESS);
        return jsonObject;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */

    @GetMapping("getInfo")
    public ResponseVo getInfo(String token, HttpServletRequest request)
    {
//        System.out.println(token);
//        System.out.println(request.getHeader("X-Token"));

        LoginVo user = new LoginVo();

        String object = redisTemplate.opsForValue().get(Constants.LOGIN_TOKEN_KEY + token);

        UserOnlineForm userOnlineForm = JSON.parseObject(object, UserOnlineForm.class);

        user.setUsername(userOnlineForm.getUserName());


       // 权限集合
        Set<String> permissions = roleService.getRolePermission(user);
        Map map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("permission", permissions);
        return ResponseVo.success(map);


//        LoginUser loginUser = tokenService.getLoginUser(request);
//        SysUser user = loginUser.getUser();
//        // 角色集合
//        Set<String> roles = permissionService.getRolePermission(user);
//        // 权限集合
//        Set<String> permissions = permissionService.getMenuPermission(user);
//        AjaxResult ajax = AjaxResult.success();
//        ajax.put("user", user);
//        ajax.put("roles", roles);
//        ajax.put("permissions", permissions);
//        return ajax;

    }





//
//    /**
//     * 测试资源1
//     * @return
//     */
//    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
//    @PreAuthorize("hasAuthority('p1')")//拥有p1权限才可以访问
//    public String r1(){
//        return getUsername()+" 访问资源1111111111";
//    }
//
//    /**
//     * 测试资源2
//     * @return
//     */
//    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
//    @PreAuthorize("hasAuthority('p2')")//拥有p2权限才可以访问
//    public String r2(){
//        return getUsername()+" 访问资源2222222222";
//    }
//
//    /**
//     * 测试资源3
//     * @return
//     */
//    @GetMapping(value = "/r/r3",produces = {"text/plain;charset=UTF-8"})
//    @PreAuthorize("hasAuthority('p3')")//拥有p2权限才可以访问
//    public String r3(){
//        return getUsername()+" 访问资源33333333";
//    }

//    /**
//     * 测试资源4
//     * @return
//     */
//    @GetMapping(value = "/r/r4",produces = {"text/plain;charset=UTF-8"})
//    @PreAuthorize("hasAuthority('p4')")//拥有p2权限才可以访问
//    public String r4(){
//        return getUsername()+" 访问资源444444444";
//    }
//
//
//    //获取当前用户信息
//    private String getUsername(){
//        String username = null;
//        //当前认证通过的用户身份
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        //用户身份
//        Object principal = authentication.getPrincipal();
//        if(principal == null){
//            username = "匿名";
//        }
//        if(principal instanceof org.springframework.security.core.userdetails.UserDetails){
//            UserDetails userDetails = (UserDetails) principal;
//            username = userDetails.getUsername();
//        }else{
//            username = principal.toString();
//        }
//        return username;
//    }
}
