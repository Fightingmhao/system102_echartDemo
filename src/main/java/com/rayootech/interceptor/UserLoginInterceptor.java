package com.rayootech.interceptor;


import com.alibaba.fastjson.JSON;
import com.rayootech.constant.Constants;
import com.rayootech.exception.UserLoginException;
import com.rayootech.form.UserOnlineForm;
import com.rayootech.resultInfo.ResponseEnum;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.serviceImpl.TokenService;
import com.rayootech.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

/**
 * 拦截器
 * Created by FightingHao on 2020/3/5
 */
//新建拦截器，如果比较多的话 就见一个包来专门存
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {


    @Autowired
    TokenService tokenService;

    @Autowired
    StringRedisTemplate redisTemplate;

    /*
    * true 表示继续流程   false表示中断
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //每次请求在这里被拦截，判断redis中是否含有该登录对象的信息，以此来判断用户是否处于在线

        if("OPTIONS".equals(request.getMethod().toUpperCase())){
            return true;
        }
        String token = request.getHeader("x-token");
        String userKey = Constants.LOGIN_TOKEN_KEY + token;
        String aBoolean = redisTemplate.opsForValue().get(userKey);

        if(aBoolean == null){
//            JSON.toJSONString( ResponseVo.error(ResponseEnum.NEED_LOGIN))
//           ;
            //资源跨域问题,同时在controller中的接口上加入注解：@CrossOrigin
            response.setHeader("Access-Control-Allow-Origin","*");

            response.setCharacterEncoding("utf-8");
            response.getWriter().write(JSON.toJSONString( ResponseVo.error(ResponseEnum.NEED_LOGIN)));
//            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
            //throw new UserLoginException();//方法二：通过抛出异常来让统一异常处理来捕获，从而得到返回值
        }
        return true;
    }
}
