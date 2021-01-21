package com.rayootech.mapper;


import com.rayootech.bean.Post;
import com.rayootech.resultInfo.ResponseVo;

import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Long[] postId);

    int insert(Post record);

    int insertSelective(Post record);


    Post selectByPrimaryKey(Long postId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    List<Post> selectPostList();

    List<Post> getPostList(Long userId);

}