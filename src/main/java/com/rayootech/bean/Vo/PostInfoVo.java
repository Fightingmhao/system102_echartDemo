package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rayootech.bean.Dept;
import com.rayootech.bean.Post;
import lombok.Data;

import java.util.Date;

/**
 * Created by FightingHao on 2020/12/1
 */
@Data
public class PostInfoVo {


    private String postName;

    private Post postFather;

    private Dept dept;



}