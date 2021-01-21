package com.rayootech.controller.post;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Post;
import com.rayootech.bean.Vo.PostInfoVo;
import com.rayootech.bean.Vo.PostVo;
import com.rayootech.mapper.PostMapper;
import com.rayootech.resultInfo.ResponseEnum;
import com.rayootech.resultInfo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FightingHao on 2020/11/30
 */

@RestController
public class PostController {

    @Autowired
    PostMapper postMapper;




    //获取post列表
    @GetMapping("/post/list")
    public ResponseVo<PageInfo<PostVo>> list(
            @RequestParam(value = "currentPage",defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize
            )
    {
        PageHelper.startPage(pageNum,pageSize);
        List<Post> posts = postMapper.selectPostList();

        List<PostVo> postVoList = new ArrayList<>();

        for (Post post : posts) {
            PostVo postVo = new PostVo();
            postVo.setPostId(post.getPostId());
            postVo.setPostName(post.getPostName());

            String postName = (postMapper.selectByPrimaryKey(post.getPostFather())).getPostName();
            postVo.setPostFather(postName);

//            String deptName = deptMapper.selectByPrimaryKey(post.getDeptId()).getDeptName();
//            postVo.setDeptName(deptName);

            postVo.setCreateTime(post.getCreateTime());

            postVoList.add(postVo);

        }

        PageInfo pageInfo = new PageInfo(postVoList);
        pageInfo.setList(postVoList);
        return ResponseVo.success(pageInfo);
    }


    //添加岗位
    @PostMapping("/post/addPost")
    public ResponseVo addPost(@Valid @RequestBody Post post ){

        //添加信息
        int resultCount = postMapper.insertSelective(post);
        if(resultCount == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return ResponseVo.success();

    }


    //删除岗位
    @DeleteMapping("/post/deletePost/{postIds}")
    public ResponseVo deleteUser(@PathVariable Long[] postIds){


        //删除user表中的账户信息
        int resultCount = postMapper.deleteByPrimaryKey(postIds);
        if(resultCount == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }


    //修改账户
    @PutMapping("/post/updatePost")
    public ResponseVo updatePost(@Valid @RequestBody Post post){


        //修改账户基础信息
        int resultCount = postMapper.updateByPrimaryKey(post);
        if(resultCount == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return ResponseVo.success();

    }

    //获取单个岗位详细信息

    @GetMapping("/post/getPostInfo/{postId}")
    public ResponseVo<PostInfoVo> getPostInfo(@PathVariable Long postId){

        PostInfoVo postInfoVo = new PostInfoVo();

        Post post = postMapper.selectByPrimaryKey(postId);
        //获取上级岗位对象
        Post postFather = postMapper.selectByPrimaryKey(post.getPostFather());
        //获取所属部门对象
//        Dept dept = deptMapper.selectByPrimaryKey(post.getDeptId());

        postInfoVo.setPostName(post.getPostName());
        postInfoVo.setPostFather(postFather);
//        postInfoVo.setDept(dept);

        return ResponseVo.success(postInfoVo);


    }


}
