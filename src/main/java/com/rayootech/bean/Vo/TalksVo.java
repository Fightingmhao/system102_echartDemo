package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/2 10:33
 */
public class TalksVo {

    private String talksName;

    private String canHrname;

    private String canHremail;

    private Integer talksId;

    private Integer backId;

//    部门名称
    private String canDept;
//    项目名称
    private String canProName;
//    候选人姓名
    private String backName;
//    面试结果
    private Integer backResult;
//    面试评价
    private String backEvalua;
//    最低报价
    private BigDecimal backOfferLow;
//    最高报价
    private BigDecimal backOfferHigh;

//    谈判结果
    private Integer talksResult;

    /** 谈判薪资 */
    private BigDecimal talksSalary;

    /** 到岗时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date talksTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date talksStaffTime;

    /** 发布状态（0有效1无效） */
    private Integer talksState;

    private Integer canId;

    private String talksIp;

    public String getTalksIp() {
        return talksIp;
    }

    public void setTalksIp(String talksIp) {
        this.talksIp = talksIp;
    }

    //    报价
    private BigDecimal staffCost;

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

    public BigDecimal getStaffCost() {
        return staffCost;
    }

    public void setStaffCost(BigDecimal staffCost) {
        this.staffCost = staffCost;
    }

    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
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

    public Integer getTalksState() {
        return talksState;
    }

    public void setTalksState(Integer talksState) {
        this.talksState = talksState;
    }

    public Integer getBackId() {
        return backId;
    }

    public void setBackId(Integer backId) {
        this.backId = backId;
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

    public String getBackName() {
        return backName;
    }

    public void setBackName(String backName) {
        this.backName = backName;
    }

    public Integer getBackResult() {
        return backResult;
    }

    public void setBackResult(Integer backResult) {
        this.backResult = backResult;
    }

    public String getBackEvalua() {
        return backEvalua;
    }

    public void setBackEvalua(String backEvalua) {
        this.backEvalua = backEvalua;
    }

    public BigDecimal getBackOfferLow() {
        return backOfferLow;
    }

    public void setBackOfferLow(BigDecimal backOfferLow) {
        this.backOfferLow = backOfferLow;
    }

    public BigDecimal getBackOfferHigh() {
        return backOfferHigh;
    }

    public void setBackOfferHigh(BigDecimal backOfferHigh) {
        this.backOfferHigh = backOfferHigh;
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

    @Override
    public String toString() {
        return "TalksVo{" +
                "talksName='" + talksName + '\'' +
                ", canHrname='" + canHrname + '\'' +
                ", canHremail='" + canHremail + '\'' +
                ", talksId=" + talksId +
                ", backId=" + backId +
                ", canDept='" + canDept + '\'' +
                ", canProName='" + canProName + '\'' +
                ", backName='" + backName + '\'' +
                ", backResult=" + backResult +
                ", backEvalua='" + backEvalua + '\'' +
                ", backOfferLow=" + backOfferLow +
                ", backOfferHigh=" + backOfferHigh +
                ", talksResult=" + talksResult +
                ", talksSalary=" + talksSalary +
                ", talksTime=" + talksTime +
                ", talksStaffTime=" + talksStaffTime +
                ", talksState=" + talksState +
                ", canId=" + canId +
                ", staffCost=" + staffCost +
                '}';
    }
}
