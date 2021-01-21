package com.rayootech.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Post;
import com.rayootech.bean.Role;
import com.rayootech.bean.UserDto;
import com.rayootech.bean.UserRole;
import com.rayootech.form.DPRListForm;
import com.rayootech.form.QueryParamsForm;
import com.rayootech.form.SysUserForm;
import com.rayootech.form.UserListForm;
import com.rayootech.mapper.*;
import com.rayootech.resultInfo.ResponseEnum;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.UserListService;
import com.rayootech.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by FightingHao on 2020/11/17
 */
@Service
public class UserListServiceImpl implements UserListService {

    @Autowired
    UserDtoMapper userDtoMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    UserPostMapper userPostMapper;


    @Autowired
    PostMapper postMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    OrgMapper orgMapper;


    @Override
    public ResponseVo<PageInfo<UserListForm>> getAllUserListForm(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);

        List<UserListForm> forms = new ArrayList<>();
        List<UserDto> userList = userDtoMapper.getAllUserList();
        for (UserDto userDto : userList) {

            UserListForm userListForm = new UserListForm();
            userListForm.setUserId(userDto.getUserId());
            userListForm.setUserName(userDto.getUserName());
            userListForm.setNickName(userDto.getNickName());
            userListForm.setStatus(userDto.getStatus());
            userListForm.setCreateTime(userDto.getCreateTime());

            //获取上级信息
            userListForm.setFather(userDtoMapper.selectByPrimaryKey(userDto.getFatherId()));
            //获取该账户所在部门信息
            userListForm.setDept(orgMapper.selectByPrimaryKey(userDto.getDeptId()));
            //获取岗位信息
            userListForm.setPost(orgMapper.selectByPrimaryKey(userDto.getPostId()));
            //获取角色信息
            List<Role> roleList = getRoleList(userDto.getUserId());
            userListForm.setRoleList(roleList);

            //将一个个账户完整信息存入forms集合中
            forms.add(userListForm);
        }
        PageInfo pageInfo = new PageInfo(forms);
        pageInfo.setList(forms);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<PageInfo<UserListForm>> selectUserBy(Integer currentPage, Integer pageSize, String userName , Long postId ) {
        QueryParamsForm queryParamsForm = new QueryParamsForm(userName,postId);
        PageHelper.startPage(currentPage, pageSize);
        List<UserListForm> forms = new ArrayList<>();
        List<UserDto> userList = userDtoMapper.getUserListByParams(queryParamsForm);

        for (UserDto userDto : userList) {

            UserListForm userListForm = new UserListForm();
            userListForm.setUserId(userDto.getUserId());
            userListForm.setUserName(userDto.getUserName());
            userListForm.setNickName(userDto.getNickName());
            userListForm.setStatus(userDto.getStatus());
            userListForm.setCreateTime(userDto.getCreateTime());

            //获取上级信息
            userListForm.setFather(userDtoMapper.selectByPrimaryKey(userDto.getFatherId()));
            //获取该账户所在部门信息
            userListForm.setDept(orgMapper.selectByPrimaryKey(userDto.getDeptId()));
            //获取岗位信息
            userListForm.setPost(orgMapper.selectByPrimaryKey(userDto.getPostId()));
            //获取角色信息
            List<Role> roleList = getRoleList(userDto.getUserId());
            userListForm.setRoleList(roleList);

            //将一个个账户完整信息存入forms集合中
            forms.add(userListForm);
        }


        PageInfo pageInfo = new PageInfo<UserDto>(userList);

        PageInfo<UserListForm> pageInfoDTO = new PageInfo<UserListForm>(forms);
        pageInfoDTO.setTotal(pageInfo.getTotal());
        pageInfoDTO.setList(forms);
        pageInfoDTO.setPages(pageInfo.getPages());
        pageInfoDTO.setPageNum(currentPage);
        pageInfoDTO.setPageSize(pageSize);
        return ResponseVo.success(pageInfoDTO);
    }

    //获取岗位信息
    private List<Post> getPostList(Long userId) {

        List<Post> postList = postMapper.getPostList(userId);


        return postList;
    }

    //获取角色信息
    private List<Role> getRoleList(Long userId) {

        List<Role> roleList = roleMapper.getRoleList(userId);
        return roleList;
    }

    //改变用户状态
    @Override
    public ResponseVo changeStatus(UserDto user) {

        if (user.getUserId() == 1) {
            return ResponseVo.error(ResponseEnum.NOT_ALLOW_UPDATE);
        }

        int resultCount = userDtoMapper.updateUser(user);
        if (resultCount == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return ResponseVo.success();
    }


    //添加账户
    @Override
    public ResponseVo addUser(SysUserForm sysUserForm) {

        //判断账户是否存在（用户账号即邮箱是否唯一）
        if (userDtoMapper.getUserByUsername(sysUserForm.getUserName()) != null) {
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }

        UserDto userDto = new UserDto();
        userDto.setUserName(sysUserForm.getUserName());
        //对密码进行加密
        String password = BCrypt.hashpw(sysUserForm.getPassword(), BCrypt.gensalt());
        userDto.setPassword(password);
        userDto.setNickName(sysUserForm.getNickName());
        userDto.setStatus(sysUserForm.getStatus());
        userDto.setCreateTime(new Date());


        //部门
        userDto.setDeptId(sysUserForm.getDeptId());
        //岗位
        userDto.setPostId(sysUserForm.getPostId());
        //上级
        userDto.setFatherId(sysUserForm.getFatherId());
        //添加账户基础信息
        int resultCount = userDtoMapper.insert(userDto);
        if (resultCount == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        sysUserForm.setUserId(userDto.getUserId());//将得到的自增id加到sysUserForm对象中

        //添加账户与角色关联
        insertUserRole(sysUserForm);



        //添加账户与岗位关联
//        insertUserPost(sysUserForm);


        return ResponseVo.success();
    }


    /**
     * 新增用户与角色信息
     *
     * @param sysUserForm
     */
    public void insertUserRole(SysUserForm sysUserForm) {
        Long[] roleIds = sysUserForm.getRoleIds();
        if (StringUtils.isNotNull(roleIds)) {
            // 新增用户与岗位管理
            List<UserRole> list = new ArrayList<UserRole>();
            for (Long roleId : roleIds) {
                UserRole up = new UserRole();
                up.setUserId(sysUserForm.getUserId());
                up.setRoleId(roleId);
                list.add(up);
            }
            if (list.size() > 0) {
                userRoleMapper.batchUserRole(list);
            }
        }
    }

   /* *//**
     * 新增用户岗位信息
     *
     * @param
     *//*
    public void insertUserPost(SysUserForm sysUserForm) {
        Long[] posts = sysUserForm.getPostIds();
        if (StringUtils.isNotNull(posts)) {
            // 新增用户与岗位管理
            List<UserPost> list = new ArrayList<UserPost>();
            for (Long postId : posts) {
                UserPost up = new UserPost();
                up.setUserId(sysUserForm.getUserId());
                up.setPostId(postId);
                list.add(up);
            }
            if (list.size() > 0) {
                userPostMapper.batchUserPost(list);
            }
        }
    }*/


    @Override
    public ResponseVo deleteUser(Long[] userIds) {

        for (Long userId : userIds) {
            if (userId == 1) {
                return ResponseVo.error(ResponseEnum.NOT_ALLOW_DELETE);
            }
            if (userDtoMapper.selectByFatherId(userId) > 0){
                return ResponseVo.error("用户存在下级，不可删除！");
            }
        }

        //删除user表中的账户信息
        int resultCount = userDtoMapper.deleteByPrimaryKey(userIds);
        if (resultCount == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        for (Long userId : userIds) {
            //删除用户角色关联表中数据
            deleteUserRole(userId);
        }
        return ResponseVo.success();
    }


    public void deleteUserRole(Long userId) {

        userRoleMapper.deleteByPrimaryKey(userId);


    }

    public void deleteUserPost(Long userId) {

        userPostMapper.deleteByPrimaryKey(userId);

    }

    //获取用户详细信息
    @Override
    public ResponseVo<SysUserForm> getUserInfo(Long userId) {


        UserDto user = userDtoMapper.getUserByUserId(userId);

        SysUserForm sysUserForm = new SysUserForm();
        sysUserForm.setUserId(user.getUserId());
        sysUserForm.setUserName(user.getUserName());
        sysUserForm.setNickName(user.getNickName());
        sysUserForm.setFatherId(user.getFatherId());
        sysUserForm.setDeptId(user.getDeptId());
        sysUserForm.setPostId(user.getPostId());

        //获得角色信息
        List<Role> roleList = getRoleList(user.getUserId());
        Long[] roleIds = new Long[roleList.size()];
        for (int j = 0; j< roleList.size(); j++){
            roleIds[j] = roleList.get(j).getRoleId();
        }

        sysUserForm.setRoleIds(roleIds);


        return ResponseVo.success(sysUserForm);
    }


    //更新账户
    @Override
    public ResponseVo updateUser(SysUserForm sysUserForm) {

        if (sysUserForm.getUserId() == 1) {
            return ResponseVo.error(ResponseEnum.NOT_ALLOW_UPDATE);
        }

        if (userDtoMapper.selectByFatherId(sysUserForm.getUserId()) > 0){
            UserDto userDto = userDtoMapper.selectByPrimaryKey(sysUserForm.getUserId());
            boolean flag = userDto.getFatherId().equals(sysUserForm.getFatherId()) && userDto.getDeptId().equals(sysUserForm.getDeptId()) && userDto.getPostId().equals(sysUserForm.getPostId());
            if(!flag ){
                return ResponseVo.error("用户存在下级，不可修改用户的部门、岗位及领导！");
            }
        }

        //判断用户账号是否改变，若改变则看是否重名了
        String userNameDB = userDtoMapper.getUserByUserId(sysUserForm.getUserId()).getUserName();//根据userId得到要修改的账户数据库中的账户名
        //两者进行比较，如果名字一致，则说明本次修改用户账号没有变动，如果不一致，则继续看改变后的用户账号数据库中是否已经存在
        if (!userNameDB.equals(sysUserForm.getUserName())) {
            if (userDtoMapper.getUserByUsername(sysUserForm.getUserName()) != null) {
                return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
            }
        }
        //先删除用户角色关联表中数据
        deleteUserRole(sysUserForm.getUserId());

        //更新user表里的信息
        UserDto userDto = new UserDto();
        userDto.setUserId(sysUserForm.getUserId());
        userDto.setUserName(sysUserForm.getUserName());
        userDto.setNickName(sysUserForm.getNickName());
        userDto.setFatherId(sysUserForm.getFatherId());
        userDto.setDeptId(sysUserForm.getDeptId());
        userDto.setPostId(sysUserForm.getPostId());

        //修改账户基础信息
        int resultCount = userDtoMapper.updateUser(userDto);
        if (resultCount == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        //添加账户与角色关联
        insertUserRole(sysUserForm);


        return ResponseVo.success();

    }

    @Override
    public DPRListForm getDPRList() {

        //获取部门表信息
//        List<Dept> depts = deptMapper.selectDeptList();

//        //获取岗位表信息
//        List<Post> posts = postMapper.selectPostList();

        //获取角色表信息
        List<Role> roles = roleMapper.selectRoleList02();

        DPRListForm dprListForm = new DPRListForm();
//        dprListForm.setDeptList(depts);
//        dprListForm.setPostList(posts);
        dprListForm.setRoleList(roles);

        return dprListForm;
    }


    //修改密码
    @Override
    public int resetPwd(UserDto user)
    {
        return userDtoMapper.updateUser(user);
    }


    //获取用户上级信息
    @Override
    public ResponseVo<UserDto> getUserFather(Long fatherId){
        return ResponseVo.success(userDtoMapper.selectByPrimaryKey(fatherId));
    }

    /**
     * 通过邮箱获取部门名称
     * @param userName
     * @return
     */
    @Override
    public ResponseVo<Object> selectDeptNameByUserName(String userName) {
        String deptName = userDtoMapper.selectDeptNameByUserName(userName);
        return ResponseVo.success(deptName);
    }

    @Override
    public ResponseVo<Object> selectNameByUserName(String userName) {
        String name = userDtoMapper.selectNameByUserName(userName);
        return ResponseVo.success(name);
    }

    /**
     * 通过邮箱获取用户名
     * @param uName
     * @return
     */
    @Override
    public ResponseVo<Object> getNickByUsrName(String uName) {
        return ResponseVo.success(userDtoMapper.getUserByUsername(uName));
    }

    /**
     * 通过邮箱查询岗位
     * @param userName
     * @return
     */
    @Override
    public ResponseVo<Object> selectPostByUserName(String userName) {
        String post = userDtoMapper.selectPostByUserName(userName);
        return ResponseVo.success(post);
    }

    /**
     * 通过邮箱获取员工信息
     * @param userName
     * @return
     */
    @Override
    public ResponseVo<Object> selectStaffName(String userName) {
        List<String> list = userDtoMapper.selectStaffByName(userName);
        return ResponseVo.success(list);
    }


}
