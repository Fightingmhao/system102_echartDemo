package com.rayootech.bean.recruitment;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/2 14:57
 */
public class Staff {

    private Integer staffId;

    private String staffCode;


    private Integer talksId;

    private String staffName;

    private BigDecimal staffSalary;

    private BigDecimal staffCost;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date staffTime;

    private Integer staffState;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date staffOutTime;

    private String staffOutReason;

    private String staffInReview;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date staffCreateTime;

    private String staffIp;

    private String staffPost;

    private String staffCard;

    private String staffPhone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date staffRuTime;

    private String staffComputer;

    private Integer staffIsOut;

    private String staffOutNum;

    private String staffCompany;

    private BigDecimal staffComCost;

    private String staffProbation;

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getTalksId() {
        return talksId;
    }

    public void setTalksId(Integer talksId) {
        this.talksId = talksId;
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

    public BigDecimal getStaffCost() {
        return staffCost;
    }

    public void setStaffCost(BigDecimal staffCost) {
        this.staffCost = staffCost;
    }

    public Date getStaffTime() {
        return staffTime;
    }

    public void setStaffTime(Date staffTime) {
        this.staffTime = staffTime;
    }

    public Integer getStaffState() {
        return staffState;
    }

    public void setStaffState(Integer staffState) {
        this.staffState = staffState;
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

    public Date getStaffCreateTime() {
        return staffCreateTime;
    }

    public void setStaffCreateTime(Date staffCreateTime) {
        this.staffCreateTime = staffCreateTime;
    }

    public String getStaffIp() {
        return staffIp;
    }

    public void setStaffIp(String staffIp) {
        this.staffIp = staffIp;
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

    public Date getStaffRuTime() {
        return staffRuTime;
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

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", talksId=" + talksId +
                ", staffName='" + staffName + '\'' +
                ", staffSalary=" + staffSalary +
                ", staffCost=" + staffCost +
                ", staffTime=" + staffTime +
                ", staffState=" + staffState +
                ", staffOutTime=" + staffOutTime +
                ", staffOutReason='" + staffOutReason + '\'' +
                ", staffInReview='" + staffInReview + '\'' +
                ", staffCreateTime=" + staffCreateTime +
                ", staffIp='" + staffIp + '\'' +
                ", staffPost='" + staffPost + '\'' +
                ", staffCard='" + staffCard + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffRuTime='" + staffRuTime + '\'' +
                ", staffComputer='" + staffComputer + '\'' +
                ", staffIsOut=" + staffIsOut +
                ", staffOutNum='" + staffOutNum + '\'' +
                ", staffCompany='" + staffCompany + '\'' +
                ", staffComCost=" + staffComCost +
                ", staffProbation='" + staffProbation + '\'' +
                '}';
    }
}
