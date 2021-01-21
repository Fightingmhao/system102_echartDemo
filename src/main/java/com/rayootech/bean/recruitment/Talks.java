package com.rayootech.bean.recruitment;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/1 13:55
 */
public class Talks {

    private Integer canId;

    /** 入职主键 */
    private Integer talksId;

    /** 面试反馈外键 */
    private Integer backId;

    /** 候选人姓名 */
    private String talksName;

    /** 谈判结果（入职0，拒绝1，考虑2，其他3） */
    private Integer talksResult;

    /** 谈判薪资 */
    private BigDecimal talksSalary;

    /** 到岗时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date talksTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date talksStaffTime;


    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date talksCreatetime;

    /** 操作id */
    private String talksIp;

    /** 发布状态（0有效1无效） */
    private Integer talksState;

    /** 部门外键 */
    private Integer deptId;


    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
    }

    public Integer getTalksId() {
        return talksId;
    }

    public void setTalksId(Integer talksId) {
        this.talksId = talksId;
    }

    public Integer getBackId() {
        return backId;
    }

    public void setBackId(Integer backId) {
        this.backId = backId;
    }

    public String getTalksName() {
        return talksName;
    }

    public void setTalksName(String talksName) {
        this.talksName = talksName;
    }

    public Integer getTalksResult() {
        return talksResult;
    }

    public void setTalksResult(Integer talksResult) {
        this.talksResult = talksResult;
    }

    public BigDecimal getTalksSalary() {
        return talksSalary;
    }

    public void setTalksSalary(BigDecimal talksSalary) {
        this.talksSalary = talksSalary;
    }

    public Date getTalksTime() {
        return talksTime;
    }

    public void setTalksTime(Date talksTime) {
        this.talksTime = talksTime;
    }

    public Date getTalksStaffTime() {
        return talksStaffTime;
    }

    public void setTalksStaffTime(Date talksStaffTime) {
        this.talksStaffTime = talksStaffTime;
    }

    public Date getTalksCreatetime() {
        return talksCreatetime;
    }

    public void setTalksCreatetime(Date talksCreatetime) {
        this.talksCreatetime = talksCreatetime;
    }

    public String getTalksIp() {
        return talksIp;
    }

    public void setTalksIp(String talksIp) {
        this.talksIp = talksIp;
    }

    public Integer getTalksState() {
        return talksState;
    }

    public void setTalksState(Integer talksState) {
        this.talksState = talksState;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Talks{" +
                "canId=" + canId +
                ", talksId=" + talksId +
                ", backId=" + backId +
                ", talksName='" + talksName + '\'' +
                ", talksResult=" + talksResult +
                ", talksSalary=" + talksSalary +
                ", talksTime=" + talksTime +
                ", talksStaffTime=" + talksStaffTime +
                ", talksCreatetime=" + talksCreatetime +
                ", talksIp='" + talksIp + '\'' +
                ", talksState=" + talksState +
                ", deptId=" + deptId +
                '}';
    }
}
