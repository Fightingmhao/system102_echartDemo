package com.rayootech.controller.user;

import com.github.pagehelper.PageInfo;
import com.rayootech.bean.UserDto;
import com.rayootech.constant.Constants;
import com.rayootech.form.DPRListForm;
import com.rayootech.form.SysUserForm;
import com.rayootech.form.UserListForm;
import com.rayootech.form.UserOnlineForm;
import com.rayootech.resultInfo.ResponseEnum;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.UserListService;
import com.rayootech.service.serviceImpl.TokenService;
import com.rayootech.utils.SecurityUtils;
import com.rayootech.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by FightingHao on 2020/11/17
 */
@RestController
public class UserListController {

    @Autowired
    UserListService userListService;

    @Autowired
    TokenService tokenService;

    @Autowired
    StringRedisTemplate redisTemplate;

    //查询用户列表
    @PostMapping("/user/getAllUser")
    public ResponseVo<PageInfo<UserListForm>> getAllUser(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                                         @RequestParam(value = "pageSize" , defaultValue = "20") Integer pageSize){

        return userListService.getAllUserListForm(currentPage,pageSize);
    }


    //修改用户状态
    @PutMapping("/user/changeStatus")
    public ResponseVo changeStatus(@RequestBody UserDto user){
        return userListService.changeStatus(user);
    }


    //添加用户
    @PostMapping("/user/addUser")
    public ResponseVo addUser(@Valid @RequestBody SysUserForm sysUserForm ){

        return userListService.addUser(sysUserForm);

    }


    //删除账户
    @DeleteMapping("/user/deleteUser/{userIds}")
    public ResponseVo deleteUser(@PathVariable Long[] userIds){
        return userListService.deleteUser(userIds);
    }



    /**
     * 根据用户编号获取详细信息
     */
    @GetMapping(value = { "/user/getUser/{userId}" })
    public ResponseVo<SysUserForm> getInfo(@PathVariable(value = "userId", required = false) Long userId)
    {


        return userListService.getUserInfo(userId);
    }

    /**
     * 获取用户的上级领导的名字
     */
    @GetMapping("/user/getFather/{fatherId}")
    public ResponseVo<UserDto> getFather(@PathVariable(value = "fatherId", required = false) Long fatherId){

        return userListService.getUserFather(fatherId);
    }


    //修改账户
    @PostMapping("/user/updateUser")
    public ResponseVo updateUser(@Valid @RequestBody SysUserForm sysUserForm){


        return userListService.updateUser(sysUserForm);

    }


    //获取部门、岗位、角色信息，返回给前端，供下拉框选择
    @PostMapping("/user/getDPRList")
    public ResponseVo<DPRListForm> getDPRList(){


        return ResponseVo.success(userListService.getDPRList());
    }


    //按条件搜索账户信息
    @PostMapping("/user/selectUserBy")
    public ResponseVo<PageInfo<UserListForm>> selectUserBy(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                                           @RequestParam(value = "pageSize" , defaultValue = "200") Integer pageSize,
                                                           @RequestParam String userName,
                                                           @RequestParam Long postId){

        return userListService.selectUserBy(currentPage,pageSize,userName,postId);
    }

    /**
     * 重置密码
     */
    @PutMapping("/user/resetPwd")
    public ResponseVo resetPwd(@RequestBody UserDto user)
    {
        if(user.getUserId() == 1){
            return ResponseVo.error(ResponseEnum.NOT_ALLOW_UPDATE);
        }
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        int resultCount = userListService.resetPwd(user);
        if (resultCount == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }



    @PostMapping("/user/logout")
    public ResponseVo logout(){


        UserOnlineForm loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String redisKey = getTokenKey(loginUser.getTokenId());
        redisTemplate.delete(redisKey);
        return ResponseVo.success();


    }

    private String getTokenKey(String uuid)
    {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }


    //查询用户列表
    @PostMapping("/user/getUserByUserName")
    public ResponseVo<PageInfo<UserListForm>> getUserByUserName(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                                         @RequestParam(value = "pageSize" , defaultValue = "20") Integer pageSize){

        return userListService.getAllUserListForm(currentPage,pageSize);
    }

    /**
     * 通过邮箱获取部门
     * @param userName
     * @return
     */
    @PostMapping("/user/getDeptName/{userName}")
    public ResponseVo<Object> getDeptByUserName(@PathVariable String userName){
        return userListService.selectDeptNameByUserName(userName);
    }

    /**
     * 通过邮箱查询用户名
     * @param userName
     * @return
     */
    @PostMapping("/user/getName/{userName}")
    public ResponseVo<Object> getNameByUserName(@PathVariable String userName){
        return userListService.selectNameByUserName(userName);
    }

    /**
     * 通过邮箱获取用户名
     * @param uName
     * @return
     */
    @GetMapping("/user/getNickByUsrName/{uName}")
    public ResponseVo<Object> getNickByUsrName(@PathVariable String uName){
        return userListService.getNickByUsrName(uName);
    }

    @PostMapping("/user/getPost/{userName}")
    public ResponseVo<Object> getPostByUserName(@PathVariable String userName){
        return userListService.selectPostByUserName(userName);
    }

    /**
     * 通过领导邮箱查询员工姓名
     * @param userName
     * @return
     */
    @PostMapping("/user/getStaffName/{userName}")
    public ResponseVo<Object> getStaffNameByUserName(@PathVariable String userName){
        return userListService.selectStaffName(userName);
    }







}
