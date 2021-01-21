package com.rayootech.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Organization {
    private Long userId;

    private String nickName;

    private String userName;

    private String password;

    private String deptName;

    private String deptFather;

    private String postName;

    private String postFather;

    private String roleName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;


    public Organization(String nickName, String userName, String password, String deptName, String deptFather, String postName, String postFather, String roleName) {
        this.nickName = nickName;
        this.userName = userName;
        this.password = password;
        this.deptName = deptName;
        this.deptFather = deptFather;
        this.postName = postName;
        this.postFather = postFather;
        this.roleName = roleName;
    }
}