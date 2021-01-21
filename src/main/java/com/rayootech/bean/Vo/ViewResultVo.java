package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 17:03
 */
@Data
public class ViewResultVo {
    /** 推荐表主键 */
    private Integer canId;

    /** 项目名称 */
    private String canProName;

    /**部门名称*/
    private String canDept;

    /** 候选人名字 */
    private String viewName;

    /** 候选人性别 */
    private String canSex;

    /** 推荐岗位 */
    private String canPost;

    /** 招聘姓名 */
    private String canHrname;

    /** 推荐人邮件 */
    private String canHremail;

    /** 简历副本 */
    private String canResumecopy;

    /** 简历审核状态 */
    private Integer canResstate;

    private String canText;

    /** 面试时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date viewTime;

    /** 发布状态（0有效1无效） */
    private Integer viewState;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date viewCreatetime;

    /** 操作id */
    private String viewIp;

}
