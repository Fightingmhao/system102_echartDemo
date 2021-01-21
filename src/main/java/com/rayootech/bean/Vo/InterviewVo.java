package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 14:12
 */
@Data
public class InterviewVo {
    /** 候选人主键 */
    private Integer canId;

    /** 项目名称 */
    private String canProName;

    /**部门名称*/
    private String canDept;

    /** 候选人名字 */
    private String canName;

    /** 候选人性别 */
    private String canSex;

    /** 候选人电话 */
    private String canPhone;

    /** 推荐岗位 */
    private String canPost;

    /** 招聘姓名 */
    private String canHrname;

    /** 推荐人邮件 */
    private String canHremail;

    /**审核人*/
    private String checkName;

    /** 简历副本 */
    private String canResumecopy;

    private String canText;

    /** 简历审核状态 */
    private Integer checkState;

    /** 面试时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date viewTime;

    /**发布状态*/
    private Integer viewState;

}
