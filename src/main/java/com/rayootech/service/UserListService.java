package com.rayootech.service;


import com.github.pagehelper.PageInfo;
import com.rayootech.bean.UserDto;
import com.rayootech.form.DPRListForm;
import com.rayootech.form.SysUserForm;
import com.rayootech.form.UserListForm;
import com.rayootech.resultInfo.ResponseVo;

/**
 * Created by FightingHao on 2020/11/17
 */

public interface UserListService {

    //查询用户列表
    ResponseVo<PageInfo<UserListForm>> getAllUserListForm(Integer currentPage, Integer pageSize);

    //根据参数查询账户信息
    ResponseVo<PageInfo<UserListForm>> selectUserBy(Integer currentPage, Integer pageSize, String userName , Long postId );

    //修改账户状态
    ResponseVo changeStatus(UserDto user);

    //添加用户
    ResponseVo addUser(SysUserForm sysUserForm);

    //删除用户
    ResponseVo deleteUser(Long[] userIds);

    //获取用户详细信息显示在修改对话框上
    ResponseVo<SysUserForm> getUserInfo(Long userId);

    //修改账户
    ResponseVo updateUser(SysUserForm sysUserForm);

    //获取部门、岗位、角色信息，返回给前端，供下拉框选择
    DPRListForm getDPRList();

    //修改密码
    int resetPwd(UserDto user);

    //获取用户的上级领导
    ResponseVo<UserDto> getUserFather(Long fatherId);

    //通过用户姓名查询部门名称
    ResponseVo<Object> selectDeptNameByUserName(String userName);

    //通过邮箱获取用户名
    ResponseVo<Object> selectNameByUserName(String userName);

    //通过邮箱获取用户信息
    ResponseVo<Object> getNickByUsrName(String uName);

    //通过邮箱获取岗位
    ResponseVo<Object> selectPostByUserName(String userName);

    //通过领导邮箱获取员工邮箱
    ResponseVo<Object> selectStaffName(String userName);
}
