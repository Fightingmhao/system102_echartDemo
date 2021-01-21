package com.rayootech.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by FightingHao on 2020/11/23
 */

@Data
public class SysUserForm {


    private Long userId;

    @NotBlank
    private String userName;

    private String password;

    @NotBlank
    private String nickName;

    private Long fatherId;

    private Long deptId;

    private Long postId;

    /** 角色组 */
//    @NotBlank
    private Long[] roleIds;

    private String status;




}
