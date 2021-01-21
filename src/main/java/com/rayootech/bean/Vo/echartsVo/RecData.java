package com.rayootech.bean.Vo.echartsVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by FightingHao on 2021/1/3
 */
@Data
public class RecData {

    /** 主键 */
    private Integer recId;

    /** 项目名称 */
    private String recProName;

    /**部门名称*/
    private String recDept;

    /** 招聘姓名 */
    private String recHrname;

    /** 招聘邮件 */
    private String recHrEmail;

    /**推荐简历数量*/
    private Integer resumeCount;

    /**审核简历通过的数量*/
    private Integer resumePassCount;

    /**约面试数量*/
    private Integer interviewCount;

    /**参加面试数量*/
    private Integer takeCount;

    /**通过面试数量*/
    private Integer passCount;

    /**谈判结果为入职数量*/
    private Integer talksEntryCount;

    /**最终入职数量*/
    private Integer entryCount;

    /**离职数量*/
    private Integer leaveCount;

    /**月份*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM",timezone = "GMT+8")
    private Date monthTime;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getRecProName() {
        return recProName;
    }

    public void setRecProName(String recProName) {
        this.recProName = recProName;
    }

    public String getRecDept() {
        return recDept;
    }

    public void setRecDept(String recDept) {
        this.recDept = recDept;
    }

    public String getRecHrname() {
        return recHrname;
    }

    public void setRecHrname(String recHrname) {
        this.recHrname = recHrname;
    }

    public String getRecHrEmail() {
        return recHrEmail;
    }

    public void setRecHrEmail(String recHrEmail) {
        this.recHrEmail = recHrEmail;
    }

    public Integer getResumeCount() {
        return resumeCount;
    }

    public void setResumeCount(Integer resumeCount) {
        this.resumeCount = resumeCount;
    }

    public Integer getResumePassCount() {
        return resumePassCount;
    }

    public void setResumePassCount(Integer resumePassCount) {
        this.resumePassCount = resumePassCount;
    }

    public Integer getInterviewCount() {
        return interviewCount;
    }

    public void setInterviewCount(Integer interviewCount) {
        this.interviewCount = interviewCount;
    }

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public Integer getPassCount() {
        return passCount;
    }

    public void setPassCount(Integer passCount) {
        this.passCount = passCount;
    }

    public Integer getTalksEntryCount() {
        return talksEntryCount;
    }

    public void setTalksEntryCount(Integer talksEntryCount) {
        this.talksEntryCount = talksEntryCount;
    }

    public Integer getEntryCount() {
        return entryCount;
    }

    public void setEntryCount(Integer entryCount) {
        this.entryCount = entryCount;
    }

    public Integer getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(Integer leaveCount) {
        this.leaveCount = leaveCount;
    }

    public Date getMonthTime() {
        return monthTime;
    }

    public void setMonthTime(Date monthTime) {
        this.monthTime = monthTime;
    }
}
