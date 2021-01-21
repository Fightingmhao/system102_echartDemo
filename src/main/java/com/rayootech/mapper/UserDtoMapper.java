package com.rayootech.mapper;



import com.rayootech.bean.UserDto;
import com.rayootech.form.QueryParamsForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDtoMapper {
    int deleteByPrimaryKey(Long[] id);

    int insert(UserDto record);

    int insertSelective(UserDto record);

    UserDto selectByPrimaryKey(Long id);

    int selectByFatherId(Long fatherId);

    int updateByPrimaryKeySelective(UserDto record);

    int updateByPrimaryKey(UserDto record);




    UserDto getUserByUsername(String username);

    UserDto getUserByUserId(Long userId);


    List<UserDto> getAllUserList();

    List<UserDto> getUserListByParams(QueryParamsForm queryParamsForm);

    int updateUser(UserDto user);

    /**
     * 重置用户密码
     *
     * @param userName 用户名
     * @param password 密码
     * @return 结果
     */
    public int resetUserPwd(@Param("userName") String userName, @Param("password") String password);

     String selectDeptNameByUserName(String userName);

    /**
     * 通过邮箱获取用户名
     * @param userName
     * @return
     */
    public String selectNameByUserName(String userName);

    /**
     * 通过邮箱查询岗位
     * @param userName
     * @return
     */
    String selectPostByUserName(String userName);

    /**
     * 通过领导姓名查询其组员的姓名
     * @param userName
     * @return
     */
    List<String> selectStaffByName(String userName);


    List<String> getDataScope(String canHremail);

    List<String> getUserDataScope(String canHremail);

    /**
     * 通过邮箱获取部门类型
     * @param uname
     * @return
     */
    String getDeptype(String uname);

    String getDeptypeByID(Integer deptId);


    List<String> getHRByGroup(String uName);

    List<UserDto> getName(String uName);


    List<String> getGroup(String uName);

    List<UserDto> getUName(String groupName);

    List<String> getproGroup(String recProName);
}