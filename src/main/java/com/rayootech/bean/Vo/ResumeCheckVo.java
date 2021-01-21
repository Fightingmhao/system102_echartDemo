package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 16:19
 */

public class ResumeCheckVo {

    /** 推荐表主键 */
    private Integer canId;

    /** 审核人员 */
    private String checkName;

    /**部门名称*/
    private String canDept;

    /** 项目名称 */
    private String canProName;

    /** 招聘姓名 */
    private String canHrname;

    /** 候选人名字 */
    private String canName;

    /** 候选人性别 */
    private String canSex;

    /** 候选人电话 */
    private String canPhone;

    /** 推荐岗位 */
    private String canPost;

    /** 简历副本 */
    private String canResumecopy;

    /** 发布状态 */
    private Integer canState;

    /** 简历审核状态 */
    private Integer canResstate;

    /** 候选人推荐时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date canCreatetime;


    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getCanDept() {
        return canDept;
    }

    public void setCanDept(String canDept) {
        this.canDept = canDept;
    }

    public String getCanProName() {
        return canProName;
    }

    public void setCanProName(String canProName) {
        this.canProName = canProName;
    }

    public String getCanHrname() {
        return canHrname;
    }

    public void setCanHrname(String canHrname) {
        this.canHrname = canHrname;
    }

    public String getCanName() {
        return canName;
    }

    public void setCanName(String canName) {
        this.canName = canName;
    }

    public String getCanSex() {
        return canSex;
    }

    public void setCanSex(String canSex) {
        this.canSex = canSex;
    }

    public String getCanPhone() {
        return canPhone;
    }

    public void setCanPhone(String canPhone) {
        this.canPhone = canPhone;
    }

    public String getCanPost() {
        return canPost;
    }

    public void setCanPost(String canPost) {
        this.canPost = canPost;
    }

    public String getCanResumecopy() {
        return canResumecopy;
    }

    public void setCanResumecopy(String canResumecopy) {
        this.canResumecopy = canResumecopy;
    }

    public Integer getCanState() {
        return canState;
    }

    public void setCanState(Integer canState) {
        this.canState = canState;
    }

    public Integer getCanResstate() {
        return canResstate;
    }

    public void setCanResstate(Integer canResstate) {
        this.canResstate = canResstate;
    }

    public Date getCanCreatetime() {
        return canCreatetime;
    }

    public void setCanCreatetime(Date canCreatetime) {
        this.canCreatetime = canCreatetime;
    }

    public ResumeCheckVo() {
    }

    public ResumeCheckVo(Integer canId, String canDept, String canProName, String canHrname, String canName, String canSex, String canPhone, String canPost, String canResumecopy, Integer canState, Integer canResstate, Date canCreatetime) {
        this.canId = canId;
        this.canDept = canDept;
        this.canProName = canProName;
        this.canHrname = canHrname;
        this.canName = canName;
        this.canSex = canSex;
        this.canPhone = canPhone;
        this.canPost = canPost;
        this.canResumecopy = canResumecopy;
        this.canState = canState;
        this.canResstate = canResstate;
        this.canCreatetime = canCreatetime;
    }

    public ResumeCheckVo(Integer canId, String canDept, String canProName, String canHrname, String canName, String canSex, String canPhone, String canPost, String canResumecopy, Integer canState, Integer canResstate) {
        this.canId = canId;
        this.canDept = canDept;
        this.canProName = canProName;
        this.canHrname = canHrname;
        this.canName = canName;
        this.canSex = canSex;
        this.canPhone = canPhone;
        this.canPost = canPost;
        this.canResumecopy = canResumecopy;
        this.canState = canState;
        this.canResstate = canResstate;
    }

    @Override
    public String toString() {
        return "ResumeCheckVo{" +
                "canId=" + canId +
                ", checkName='" + checkName + '\'' +
                ", canDept='" + canDept + '\'' +
                ", canProName='" + canProName + '\'' +
                ", canHrname='" + canHrname + '\'' +
                ", canName='" + canName + '\'' +
                ", canSex='" + canSex + '\'' +
                ", canPhone='" + canPhone + '\'' +
                ", canPost='" + canPost + '\'' +
                ", canResumecopy='" + canResumecopy + '\'' +
                ", canState=" + canState +
                ", canResstate=" + canResstate +
                ", canCreatetime=" + canCreatetime +
                '}';
    }
}
