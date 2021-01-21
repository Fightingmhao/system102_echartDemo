package com.rayootech.bean.Vo.echartsVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/6 14:26
 */
public class RecDataVo {

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
    /**小组的名字*/
    private String groupName;

    /**月份*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM",timezone = "GMT+8")
    private Date monthTime;

    /**成员的Email*/
    private String hrEmail;

    private String yearTime;

    private String quarterTime;

    private String years;

    private String season;

    public String getYearTime() {
        return yearTime;
    }

    public void setYearTime(String yearTime) {
        this.yearTime = yearTime;
    }

    public String getQuarterTime() {
        return quarterTime;
    }

    public void setQuarterTime(String quarterTime) {
        this.quarterTime = quarterTime;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getMonthTime() {
        return monthTime;
    }

    public void setMonthTime(Date monthTime) {
        this.monthTime = monthTime;
    }

    public String getHrEmail() {
        return hrEmail;
    }

    public void setHrEmail(String hrEmail) {
        this.hrEmail = hrEmail;
    }

    @Override
    public String toString() {
        return "RecDataVo{" +
                "recId=" + recId +
                ", recProName='" + recProName + '\'' +
                ", recDept='" + recDept + '\'' +
                ", recHrname='" + recHrname + '\'' +
                ", recHrEmail='" + recHrEmail + '\'' +
                ", resumeCount=" + resumeCount +
                ", resumePassCount=" + resumePassCount +
                ", interviewCount=" + interviewCount +
                ", takeCount=" + takeCount +
                ", passCount=" + passCount +
                ", talksEntryCount=" + talksEntryCount +
                ", entryCount=" + entryCount +
                ", leaveCount=" + leaveCount +
                ", groupName='" + groupName + '\'' +
                ", monthTime=" + monthTime +
                ", hrEmail='" + hrEmail + '\'' +
                ", yearTime='" + yearTime + '\'' +
                ", quarterTime='" + quarterTime + '\'' +
                ", years='" + years + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
