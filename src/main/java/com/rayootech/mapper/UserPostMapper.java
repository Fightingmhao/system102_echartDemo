package com.rayootech.mapper;


import com.rayootech.bean.UserPost;

import java.util.List;

public interface UserPostMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserPost record);

    int insertSelective(UserPost record);

    /**
     * 批量新增用户岗位信息
     *
     * @param userPostList 用户角色列表
     * @return 结果
     */
    int batchUserPost(List<UserPost> userPostList);
}