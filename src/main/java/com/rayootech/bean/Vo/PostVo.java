package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by FightingHao on 2020/11/30
 */
@Data
public class PostVo {
    private Long postId;

    private String postName;

    private String postFather;

    private String deptName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;



}