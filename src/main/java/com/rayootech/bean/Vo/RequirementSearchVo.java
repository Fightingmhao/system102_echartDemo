package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 13:39
 */
public class RequirementSearchVo {
    /** 需求编码 */
    private Integer reqId;

    /** 部门名称 */
    private String reqDept;

    /** 客户名称 */
    private String saleCusname;

    /** 客户背景 */
    private String proCusground;

    /** 项目名称 */
    private String proName;

    /** 项目类型 */
    private String proType;

    /** 项目周期 */
    private String proPeriod;

    /** 项目规模 */
    private String proScale;

    /** 项目经理归属 */
    private String proRelegation;

    /** 面试流程 */
    private String proViewgress;

    /** 需求岗位 */
    private String reqPost;

    /** 需求人数 */
    private Integer reqCount;

    /** 技术要求 */
    private String reqTech;

    /** 岗位职责 */
    private String reqDuty;

    /** 工作地点 */
    private String reqJobadress;

    /** 面试地点 */
    private String reqViewadress;

    /** 工作年限 */
    private Integer reqWorkyear;

    /** 最低报价 */
    private BigDecimal reqOfferlow;

    /** 最高报价 */
    private BigDecimal reqOfferhigh;

    /** 最低薪资 */
    private BigDecimal reqSalarylow;

    /** 最高薪资 */
    private BigDecimal reqSalaryhigh;

    /** 发布状态 */
    private Integer reqState;

    /** 发布时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date reqCreatetime;

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public String getReqDept() {
        return reqDept;
    }

    public void setReqDept(String reqDept) {
        this.reqDept = reqDept;
    }

    public String getSaleCusname() {
        return saleCusname;
    }

    public void setSaleCusname(String saleCusname) {
        this.saleCusname = saleCusname;
    }

    public String getProCusground() {
        return proCusground;
    }

    public void setProCusground(String proCusground) {
        this.proCusground = proCusground;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getProPeriod() {
        return proPeriod;
    }

    public void setProPeriod(String proPeriod) {
        this.proPeriod = proPeriod;
    }

    public String getProScale() {
        return proScale;
    }

    public void setProScale(String proScale) {
        this.proScale = proScale;
    }

    public String getProRelegation() {
        return proRelegation;
    }

    public void setProRelegation(String proRelegation) {
        this.proRelegation = proRelegation;
    }

    public String getProViewgress() {
        return proViewgress;
    }

    public void setProViewgress(String proViewgress) {
        this.proViewgress = proViewgress;
    }

    public String getReqPost() {
        return reqPost;
    }

    public void setReqPost(String reqPost) {
        this.reqPost = reqPost;
    }

    public Integer getReqCount() {
        return reqCount;
    }

    public void setReqCount(Integer reqCount) {
        this.reqCount = reqCount;
    }

    public String getReqTech() {
        return reqTech;
    }

    public void setReqTech(String reqTech) {
        this.reqTech = reqTech;
    }

    public String getReqDuty() {
        return reqDuty;
    }

    public void setReqDuty(String reqDuty) {
        this.reqDuty = reqDuty;
    }

    public String getReqJobadress() {
        return reqJobadress;
    }

    public void setReqJobadress(String reqJobadress) {
        this.reqJobadress = reqJobadress;
    }

    public String getReqViewadress() {
        return reqViewadress;
    }

    public void setReqViewadress(String reqViewadress) {
        this.reqViewadress = reqViewadress;
    }

    public Integer getReqWorkyear() {
        return reqWorkyear;
    }

    public void setReqWorkyear(Integer reqWorkyear) {
        this.reqWorkyear = reqWorkyear;
    }

    public BigDecimal getReqOfferlow() {
        return reqOfferlow;
    }

    public void setReqOfferlow(BigDecimal reqOfferlow) {
        this.reqOfferlow = reqOfferlow;
    }

    public BigDecimal getReqOfferhigh() {
        return reqOfferhigh;
    }

    public void setReqOfferhigh(BigDecimal reqOfferhigh) {
        this.reqOfferhigh = reqOfferhigh;
    }

    public BigDecimal getReqSalarylow() {
        return reqSalarylow;
    }

    public void setReqSalarylow(BigDecimal reqSalarylow) {
        this.reqSalarylow = reqSalarylow;
    }

    public BigDecimal getReqSalaryhigh() {
        return reqSalaryhigh;
    }

    public void setReqSalaryhigh(BigDecimal reqSalaryhigh) {
        this.reqSalaryhigh = reqSalaryhigh;
    }

    public Integer getReqState() {
        return reqState;
    }

    public void setReqState(Integer reqState) {
        this.reqState = reqState;
    }

    public Date getReqCreatetime() {
        return reqCreatetime;
    }

    public void setReqCreatetime(Date reqCreatetime) {
        this.reqCreatetime = reqCreatetime;
    }

    public RequirementSearchVo() {
    }

    public RequirementSearchVo(Integer reqId, String reqDept, String saleCusname, String proCusground, String proName, String proType, String proPeriod, String proScale, String proRelegation, String proViewgress, String reqPost, Integer reqCount, String reqTech, String reqDuty, String reqJobadress, String reqViewadress, Integer reqWorkyear, BigDecimal reqOfferlow, BigDecimal reqOfferhigh, BigDecimal reqSalarylow, BigDecimal reqSalaryhigh, Integer reqState, Date reqCreatetime) {
        this.reqId = reqId;
        this.reqDept = reqDept;
        this.saleCusname = saleCusname;
        this.proCusground = proCusground;
        this.proName = proName;
        this.proType = proType;
        this.proPeriod = proPeriod;
        this.proScale = proScale;
        this.proRelegation = proRelegation;
        this.proViewgress = proViewgress;
        this.reqPost = reqPost;
        this.reqCount = reqCount;
        this.reqTech = reqTech;
        this.reqDuty = reqDuty;
        this.reqJobadress = reqJobadress;
        this.reqViewadress = reqViewadress;
        this.reqWorkyear = reqWorkyear;
        this.reqOfferlow = reqOfferlow;
        this.reqOfferhigh = reqOfferhigh;
        this.reqSalarylow = reqSalarylow;
        this.reqSalaryhigh = reqSalaryhigh;
        this.reqState = reqState;
        this.reqCreatetime = reqCreatetime;
    }

    @Override
    public String toString() {
        return "RequirementSearchVo{" +
                "reqId=" + reqId +
                ", reqDept='" + reqDept + '\'' +
                ", saleCusname='" + saleCusname + '\'' +
                ", proCusground='" + proCusground + '\'' +
                ", proName='" + proName + '\'' +
                ", proType='" + proType + '\'' +
                ", proPeriod='" + proPeriod + '\'' +
                ", proScale='" + proScale + '\'' +
                ", proRelegation='" + proRelegation + '\'' +
                ", proViewgress='" + proViewgress + '\'' +
                ", reqPost='" + reqPost + '\'' +
                ", reqCount=" + reqCount +
                ", reqTech='" + reqTech + '\'' +
                ", reqDuty='" + reqDuty + '\'' +
                ", reqJobadress='" + reqJobadress + '\'' +
                ", reqViewadress='" + reqViewadress + '\'' +
                ", reqWorkyear=" + reqWorkyear +
                ", reqOfferlow=" + reqOfferlow +
                ", reqOfferhigh=" + reqOfferhigh +
                ", reqSalarylow=" + reqSalarylow +
                ", reqSalaryhigh=" + reqSalaryhigh +
                ", reqState=" + reqState +
                ", reqCreatetime=" + reqCreatetime +
                '}';
    }
}
