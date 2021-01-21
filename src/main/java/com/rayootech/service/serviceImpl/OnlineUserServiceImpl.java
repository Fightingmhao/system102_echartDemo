package com.rayootech.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import com.rayootech.bean.Org;
import com.rayootech.bean.UserDto;
import com.rayootech.constant.Constants;
import com.rayootech.form.UserOnlineForm;
import com.rayootech.mapper.OrgMapper;
import com.rayootech.mapper.UserDtoMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.OnlineUserService;
import com.rayootech.utils.RedisCache;
import com.rayootech.utils.ServletUtils;
import com.rayootech.utils.ip.IpUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by FightingHao on 2020/11/26
 */

@Service
public class OnlineUserServiceImpl implements OnlineUserService {

    @Autowired
    UserDtoMapper userDtoMapper;

    @Autowired
    OrgMapper orgMapper;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    StringRedisTemplate redisTemplate;


    @Override
    public void saveOnlineUser(UserOnlineForm userOnlineForm) {


        UserDto user = userDtoMapper.getUserByUsername(userOnlineForm.getUserName());

        userOnlineForm.setNickName(user.getNickName());
        //获取该账户所在部门信息
        Org org = orgMapper.selectByPrimaryKey(user.getDeptId());
        userOnlineForm.setDeptName(org.getOrgName());

        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        userOnlineForm.setIpaddr(ip);
        userOnlineForm.setBrowser(userAgent.getBrowser().getName());
        userOnlineForm.setOs(userAgent.getOperatingSystem().getName());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String currentTime = df.format(new Date());
        userOnlineForm.setLoginTime(currentTime);

        // 以LOGIN_TOKEN_KEY+token作为key值将loginUser缓存在redis中
        String userKey = getTokenKey(userOnlineForm.getTokenId());

        redisTemplate.opsForValue().set(userKey, JSONObject.toJSONString(userOnlineForm),Constants.OUT_TIME, TimeUnit.SECONDS);
//        redisCache.setCacheObject(userKey, userOnlineForm);


    }


    private String getTokenKey(String uuid)
    {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }



    //获取redis中缓存的在线用户信息
    @Override
    public ResponseVo<PageInfo<UserOnlineForm>> getOnlineUser(Integer currentPage, Integer pageSize) {

        Collection<String> keys = redisTemplate.keys(Constants.LOGIN_TOKEN_KEY + "*");

        List<UserOnlineForm> userOnlineList = new ArrayList<>();
        for (String key : keys)
        {

            String object = redisTemplate.opsForValue().get(key);

//            ParserConfig.getGlobalInstance().setAutoTypeSupport(true);//打开autotype功能
            UserOnlineForm userOnlineForm = JSON.parseObject(object, UserOnlineForm.class);

            userOnlineList.add(userOnlineForm);

        }
//        Collections.reverse(userOnlineList);
//        userOnlineList.removeAll(Collections.singleton(null));

        PageInfo pageInfo = new PageInfo(userOnlineList);
        pageInfo.setList(userOnlineList);
        return  ResponseVo.success(pageInfo);


    }


    /**
     * 重置用户密码
     *
     * @param userName 用户名
     * @param password 密码
     * @return 结果
     */
    @Override
    public int resetUserPwd(String userName, String password)
    {
        return userDtoMapper.resetUserPwd(userName, password);
    }








}
