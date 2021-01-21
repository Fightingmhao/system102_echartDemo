package com.rayootech.bean.deliver;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/24 14:40
 */
public class Project implements Serializable {
    /** 项目编号 */
    private Integer proId;

    /** 部门名称 */
    private String proDept;

    /** 客户编码 */
    private String proCuscode;

    /** 客户编码是否被使用 */
    private Integer proCusState;

    /** 项目编码 */
    private String proCode;

    /** 项目名称 */
    private String proName;

    /** 项目状态 */
    private Long proState;

    /** 项目类型 */
    private String proType;

    /** 项目周期 */
    private String proPeriod;

    /** 项目规模 */
    private String proScale;

    /** 项目经理归属 */
    private String proRelegation;

    /** 客户背景 */
    private String proCusground;

    /** 面试流程 */
    private String proViewgress;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date proCreatetime;

    /** 操作id */
    private String proIp;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProDept() {
        return proDept;
    }

    public void setProDept(String proDept) {
        this.proDept = proDept;
    }

    public String getProCuscode() {
        return proCuscode;
    }

    public void setProCuscode(String proCuscode) {
        this.proCuscode = proCuscode;
    }

    public Integer getProCusState() {
        return proCusState;
    }

    public void setProCusState(Integer proCusState) {
        this.proCusState = proCusState;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Long getProState() {
        return proState;
    }

    public void setProState(Long proState) {
        this.proState = proState;
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

    public String getProCusground() {
        return proCusground;
    }

    public void setProCusground(String proCusground) {
        this.proCusground = proCusground;
    }

    public String getProViewgress() {
        return proViewgress;
    }

    public void setProViewgress(String proViewgress) {
        this.proViewgress = proViewgress;
    }

    public Date getProCreatetime() {
        return proCreatetime;
    }

    public void setProCreatetime(Date proCreatetime) {
        this.proCreatetime = proCreatetime;
    }

    public String getProIp() {
        return proIp;
    }

    public void setProIp(String proIp) {
        this.proIp = proIp;
    }


    @Override
    public String toString() {
        return "Project{" +
                "proId=" + proId +
                ", proDept='" + proDept + '\'' +
                ", proCuscode='" + proCuscode + '\'' +
                ", proCusState=" + proCusState +
                ", proCode='" + proCode + '\'' +
                ", proName='" + proName + '\'' +
                ", proState=" + proState +
                ", proType='" + proType + '\'' +
                ", proPeriod='" + proPeriod + '\'' +
                ", proScale='" + proScale + '\'' +
                ", proRelegation='" + proRelegation + '\'' +
                ", proCusground='" + proCusground + '\'' +
                ", proViewgress='" + proViewgress + '\'' +
                ", proCreatetime=" + proCreatetime +
                ", proIp='" + proIp + '\'' +
                '}';
    }
}
