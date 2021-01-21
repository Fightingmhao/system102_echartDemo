package com.rayootech.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rayootech.bean.Vo.LoginVo;
import com.rayootech.constant.Constants;
import com.rayootech.form.UserOnlineForm;
import com.rayootech.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by FightingHao on 2020/11/10
 */
@Service
public class TokenService {


    @Autowired
    StringRedisTemplate redisTemplate;

    public String getToken(User user,String password) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
        String userName = user.getUsername();

        token = JWT.create().withAudience(userName).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(password));
        return token;
    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public UserOnlineForm getLoginUser(HttpServletRequest request)
    {

        String token = request.getHeader("X-Token");
        // 获取请求携带的令牌
        if (StringUtils.isNotEmpty(token))
        {

            // 以LOGIN_TOKEN_KEY+token作为key值将loginUser缓存在redis中
            String userKey = getTokenKey(token);

            String object = redisTemplate.opsForValue().get(userKey);
            UserOnlineForm userOnlineForm = JSON.parseObject(object, UserOnlineForm.class);


            return userOnlineForm;
        }
        return null;
    }


    private String getTokenKey(String uuid)
    {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }


}