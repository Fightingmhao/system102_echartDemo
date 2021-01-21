package com.rayootech.controller.user;

import com.github.pagehelper.PageInfo;

import com.rayootech.bean.UserDto;
import com.rayootech.constant.Constants;
import com.rayootech.form.UserOnlineForm;
import com.rayootech.mapper.UserDtoMapper;
import com.rayootech.resultInfo.ResponseEnum;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.OnlineUserService;
import com.rayootech.service.serviceImpl.TokenService;
import com.rayootech.utils.SecurityUtils;
import com.rayootech.utils.ServletUtils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

/**
 * Created by FightingHao on 2020/11/26
 */

@RestController
public class OnlineUserController {


    @Autowired
    OnlineUserService onlineUserService;


    @Autowired
    TokenService tokenService;

    @Autowired
    UserDtoMapper userDtoMapper;

    @Autowired
    StringRedisTemplate redisTemplate;



    @PostMapping("/online/getOnlineUser")
    public ResponseVo<PageInfo<UserOnlineForm>> getOnlineUser(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                                              @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize){


        return  onlineUserService.getOnlineUser(currentPage,pageSize);


    }


    @PutMapping("/user/updatePwd")
    public ResponseVo updatePwd(String oldPassword, String newPassword)
    {
        UserOnlineForm loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String userName = loginUser.getUserName();

        UserDto userByUsername = userDtoMapper.getUserByUsername(userName);
        String password = userByUsername.getPassword();//得到数据库中的旧密码

        if (!SecurityUtils.matchesPassword(oldPassword, password))
        {
            return ResponseVo.error(ResponseEnum.OLD_PASSWORD_ERROR);
        }
        if (SecurityUtils.matchesPassword(newPassword, password))
        {
            return ResponseVo.error(ResponseEnum.OLD_NEW_NOSAME);
        }
        if (onlineUserService.resetUserPwd(userName, SecurityUtils.encryptPassword(newPassword)) > 0)
        {
//            // 更新缓存用户密码
//            loginUser.getUser().setPassword(SecurityUtils.encryptPassword(newPassword));
//            tokenService.setLoginUser(loginUser);
            return ResponseVo.success();
        }
        return ResponseVo.error(ResponseEnum.ERROR);
    }



    /**
     * 强退用户
     */
    @DeleteMapping("/online/forceLogout/{tokenId}")
    public ResponseVo forceLogout(@PathVariable String tokenId)
    {

        Boolean flag = redisTemplate.delete(Constants.LOGIN_TOKEN_KEY + tokenId);

        if(!flag){
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return ResponseVo.success();
    }


}
