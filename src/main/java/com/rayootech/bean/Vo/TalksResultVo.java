package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/19 18:59
 */
@Data
public class TalksResultVo implements Serializable {
    private String canHrname;

    private String canHremail;

    /** 项目名称 */
    private String canProName;

    /**部门名称*/
    private String canDept;

    private Integer talksId;

    /** 候选人姓名 */
    private String talksName;

    /** 谈判结果（入职0，拒绝1，考虑2，其他3） */
    private Integer talksResult;

    /** 谈判薪资 */
    private BigDecimal talksSalary;

    /** 到岗时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date talksTime;

    /** 入职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date talksStaffTime;


    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date talksCreatetime;

    /** 操作id */
    private String talksIp;

    /** 发布状态（0有效1无效） */
    private Integer talksState;

    public String getCanHrname() {
        return canHrname;
    }

    public void setCanHrname(String canHrname) {
        this.canHrname = canHrname;
    }

    public String getCanHremail() {
        return canHremail;
    }

    public void setCanHremail(String canHremail) {
        this.canHremail = canHremail;
    }

    public String getCanProName() {
        return canProName;
    }

    public void setCanProName(String canProName) {
        this.canProName = canProName;
    }

    public String getCanDept() {
        return canDept;
    }

    public void setCanDept(String canDept) {
        this.canDept = canDept;
    }

    public Integer getTalksId() {
        return talksId;
    }

    public void setTalksId(Integer talksId) {
        this.talksId = talksId;
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
}
