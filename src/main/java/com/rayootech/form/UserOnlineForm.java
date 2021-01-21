package com.rayootech.form;

import lombok.Data;

import java.io.Serializable;

/**
 * 当前在线会话
 * 
 * @author ruoyi
 */

@Data
public class UserOnlineForm implements Serializable
{
    /** 会话编号 */
    private String tokenId;

    /** 部门名称 */
    private String deptName;

    /** 用户名称 */
    private String userName;

    /** 用户名 */
    private String nickName;

    /** 登录IP地址 */
    private String ipaddr;

    /** 登录地址 */
//    private String loginLocation;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** 登录时间 */
    private String loginTime;




}
