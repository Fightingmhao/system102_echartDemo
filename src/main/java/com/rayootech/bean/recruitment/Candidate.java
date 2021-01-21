package com.rayootech.bean.recruitment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Candidate
{
    private static final long serialVersionUID = 1L;

    /** 推荐表主键 */
    private Integer canId;

    /** 项目名称 */
    private String canProName;

    /**部门名称*/
    private String canDept;

    /** 候选人名字 */
    private String canName;

//    候选人身份证
    private String canCard;

    /** 候选人性别 */
    private String canSex;

    /** 候选人电话 */
    private String canPhone;

    /** 推荐岗位 */
    private String canPost;

    /** 招聘姓名 */
    private String canHrname;

    /** 候选人邮件 */
    private String canHremail;

    /** 发布状态 */
    private Integer canState;

    /** 简历审核状态 */
    private Integer canResstate;

    /** 简历副本 */
    private String canResumecopy;

    private String canText;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date canCreatetime;

    /** 操作id */
    private String canIp;


}
