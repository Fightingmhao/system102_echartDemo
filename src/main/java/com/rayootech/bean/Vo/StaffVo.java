package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/2 14:57
 */
public class StaffVo {

//    推荐表主键
    private Integer canId;
//    部门名称
    private String canDept;
//    项目名称
    private String canProName;

    private String UserName;
//    候选人岗位
    private String canPost;
//    候选人电话
    private String canPhone;
//    候选人身份证
    private String canCard;
    //    谈判表主键
    private Integer talksId;
//    候选人名称
    private String talksName;
//    到岗薪资
    private BigDecimal talksSalary;

    private BigDecimal staffCost;
//    到岗时间
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date talksTime;
//    入职状态
    private Integer talksResult;

    private Integer talksState;

    private Integer staffState;

    private String staffName;

    private BigDecimal staffSalary;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date staffTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date staffOutTime;

    private String staffOutReason;

    private String staffInReview;

    private Integer staffId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date staffCreatetime;

    private String staffIp;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date talksStaffTime;

    private String staffPost;

    private String staffCard;

    private String staffPhone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date staffRuTime;

    private String staffComputer;

    private Integer staffIsOut;

    private String staffOutNum;

    private String staffCompany;

    private BigDecimal staffComCost;

    private String staffProbation;

    private String staffCode;


    public Date getStaffRuTime() {
        return staffRuTime;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffPost() {
        return staffPost;
    }

    public void setStaffPost(String staffPost) {
        this.staffPost = staffPost;
    }

    public String getStaffCard() {
        return staffCard;
    }

    public void setStaffCard(String staffCard) {
        this.staffCard = staffCard;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }


    public void setStaffRuTime(Date staffRuTime) {
        this.staffRuTime = staffRuTime;
    }

    public String getStaffComputer() {
        return staffComputer;
    }

    public void setStaffComputer(String staffComputer) {
        this.staffComputer = staffComputer;
    }

    public Integer getStaffIsOut() {
        return staffIsOut;
    }

    public void setStaffIsOut(Integer staffIsOut) {
        this.staffIsOut = staffIsOut;
    }

    public String getStaffOutNum() {
        return staffOutNum;
    }

    public void setStaffOutNum(String staffOutNum) {
        this.staffOutNum = staffOutNum;
    }

    public String getStaffCompany() {
        return staffCompany;
    }

    public void setStaffCompany(String staffCompany) {
        this.staffCompany = staffCompany;
    }

    public BigDecimal getStaffComCost() {
        return staffComCost;
    }

    public void setStaffComCost(BigDecimal staffComCost) {
        this.staffComCost = staffComCost;
    }

    public String getStaffProbation() {
        return staffProbation;
    }

    public void setStaffProbation(String staffProbation) {
        this.staffProbation = staffProbation;
    }

    public Date getTalksStaffTime() {
        return talksStaffTime;
    }

    public void setTalksStaffTime(Date talksStaffTime) {
        this.talksStaffTime = talksStaffTime;
    }

    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
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

    public String getCanPost() {
        return canPost;
    }

    public void setCanPost(String canPost) {
        this.canPost = canPost;
    }

    public String getCanPhone() {
        return canPhone;
    }

    public void setCanPhone(String canPhone) {
        this.canPhone = canPhone;
    }

    public String getCanCard() {
        return canCard;
    }

    public void setCanCard(String canCard) {
        this.canCard = canCard;
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

    public BigDecimal getTalksSalary() {
        return talksSalary;
    }

    public void setTalksSalary(BigDecimal talksSalary) {
        this.talksSalary = talksSalary;
    }

    public BigDecimal getStaffCost() {
        return staffCost;
    }

    public void setStaffCost(BigDecimal staffCost) {
        this.staffCost = staffCost;
    }

    public Date getTalksTime() {
        return talksTime;
    }

    public void setTalksTime(Date talksTime) {
        this.talksTime = talksTime;
    }

    public Integer getTalksResult() {
        return talksResult;
    }

    public void setTalksResult(Integer talksResult) {
        this.talksResult = talksResult;
    }

    public Integer getTalksState() {
        return talksState;
    }

    public void setTalksState(Integer talksState) {
        this.talksState = talksState;
    }

    public Integer getStaffState() {
        return staffState;
    }

    public void setStaffState(Integer staffState) {
        this.staffState = staffState;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public BigDecimal getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(BigDecimal staffSalary) {
        this.staffSalary = staffSalary;
    }

    public Date getStaffTime() {
        return staffTime;
    }

    public void setStaffTime(Date staffTime) {
        this.staffTime = staffTime;
    }

    public Date getStaffOutTime() {
        return staffOutTime;
    }

    public void setStaffOutTime(Date staffOutTime) {
        this.staffOutTime = staffOutTime;
    }

    public String getStaffOutReason() {
        return staffOutReason;
    }

    public void setStaffOutReason(String staffOutReason) {
        this.staffOutReason = staffOutReason;
    }

    public String getStaffInReview() {
        return staffInReview;
    }

    public void setStaffInReview(String staffInReview) {
        this.staffInReview = staffInReview;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Date getStaffCreatetime() {
        return staffCreatetime;
    }

    public void setStaffCreatetime(Date staffCreatetime) {
        this.staffCreatetime = staffCreatetime;
    }

    public String getStaffIp() {
        return staffIp;
    }

    public void setStaffIp(String staffIp) {
        this.staffIp = staffIp;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "StaffVo{" +
                "canId=" + canId +
                ", canDept='" + canDept + '\'' +
                ", canProName='" + canProName + '\'' +
                ", canPost='" + canPost + '\'' +
                ", canPhone='" + canPhone + '\'' +
                ", canCard='" + canCard + '\'' +
                ", talksId=" + talksId +
                ", talksName='" + talksName + '\'' +
                ", talksSalary=" + talksSalary +
                ", staffCost=" + staffCost +
                ", talksTime=" + talksTime +
                ", talksResult=" + talksResult +
                ", talksState=" + talksState +
                ", staffState=" + staffState +
                ", staffName='" + staffName + '\'' +
                ", staffSalary=" + staffSalary +
                ", staffTime=" + staffTime +
                ", staffOutTime=" + staffOutTime +
                ", staffOutReason='" + staffOutReason + '\'' +
                ", staffInReview='" + staffInReview + '\'' +
                ", staffId=" + staffId +
                ", staffCreatetime=" + staffCreatetime +
                ", staffIp='" + staffIp + '\'' +
                '}';
    }
}
