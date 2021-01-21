package com.rayootech.mapper;



import com.rayootech.bean.UserRole;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserRole record);

    int insertSelective(UserRole record);


    /**
     * 批量新增用户角色信息
     *
     * @param userRoleList 用户角色列表
     * @return 结果
     */
    int batchUserRole(List<UserRole> userRoleList);
}