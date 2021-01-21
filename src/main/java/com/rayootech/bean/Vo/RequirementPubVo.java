package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/24 14:47
 */
public class RequirementPubVo implements Serializable {

    /** 需求编码 */
    private Integer reqId;

    /** 部门名称 */
    private String reqDept;

    /** 项目名称 */
    private String proName;

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

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date reqCreatetime;

    /** 操作ID */
    private String reqIp;

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

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
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

    public String getReqIp() {
        return reqIp;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    public RequirementPubVo() {
    }

    public RequirementPubVo(String reqDept, String proName, String reqPost, Integer reqCount, String reqTech, String reqDuty, String reqJobadress, String reqViewadress, Integer reqWorkyear, BigDecimal reqOfferlow, BigDecimal reqOfferhigh, BigDecimal reqSalarylow, BigDecimal reqSalaryhigh, Integer reqState, Date reqCreatetime, String reqIp) {
        this.reqDept = reqDept;
        this.proName = proName;
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
        this.reqIp = reqIp;
    }

    @Override
    public String toString() {
        return "RequirementPubVo{" +
                "reqId=" + reqId +
                ", reqDept='" + reqDept + '\'' +
                ", proName='" + proName + '\'' +
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
                ", reqIp='" + reqIp + '\'' +
                '}';
    }
}
