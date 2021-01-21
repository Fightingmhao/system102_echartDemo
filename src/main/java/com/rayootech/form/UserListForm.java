package com.rayootech.form;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.rayootech.bean.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by FightingHao on 2020/11/26
 */

@Data
public class UserListForm {

    private Long userId;

    private String userName;

    private String nickName;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private UserDto father;

    private Org dept;

    private Org post;

    private List<Role> roleList;








}
