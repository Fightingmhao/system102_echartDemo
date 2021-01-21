package com.rayootech.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class UserDto {
    private Long userId;

    private String userName;

    private String password;

    private String nickName;

    private String status;

    private Long fatherId;

    private Long deptId;

    private Long postId;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


}