package com.rayootech.service.serviceImpl;

import com.rayootech.bean.UserDto;
import com.rayootech.mapper.RoleMapper;
import com.rayootech.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Autowired
    private RoleMapper roleMapper;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //将来连接数据库根据账号查询用户信息
        UserDto userDto = userDtoMapper.getUserByUsername(username);
//        System.out.println("哈哈哈"+userDto.toString());
        if(userDto == null){
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }

        //根据用户的id查询用户的权限
        Set<String> set = roleMapper.queryPremssion(userDto.getUserId());
        List<String> permissions = new ArrayList<>();
        set.forEach(c -> permissions.add(c));//得到permissionDto中的code集合
        //将permissionDto中的code集合转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        //将userDto转成json
//        String principal = JSON.toJSONString(userDto);
        UserDetails userDetails = User.withUsername(userDto.getUserName()).password(userDto.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}