package com.rayootech.service;

import com.github.pagehelper.PageInfo;
import com.rayootech.form.UserOnlineForm;
import com.rayootech.resultInfo.ResponseVo;

/**
 * Created by FightingHao on 2020/11/26
 */
public interface OnlineUserService {

    void saveOnlineUser(UserOnlineForm userOnlineForm);


    //查询用户列表
    ResponseVo<PageInfo<UserOnlineForm>> getOnlineUser(Integer currentPage, Integer pageSize);


    /**
     * 重置用户密码
     *
     * @param userName 用户名
     * @param password 密码
     * @return 结果
     */
    int resetUserPwd(String userName, String password);
}
