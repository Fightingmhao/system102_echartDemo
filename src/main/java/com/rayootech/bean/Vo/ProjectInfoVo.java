package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/27 10:17
 */
public class ProjectInfoVo {

    /** 项目编号 */
    private Integer proId;

    /** 部门名称 */
    private String proDept;

    /** 销售姓名 */
    private String saleName;

    /** 客户名称 */
    private String saleCusname;

    /** 客户背景 */
    private String proCusground;

    /** 项目编码 */
    private String proCode;

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

    /** 项目状态 */
    private Long proState;

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

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
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

    public Long getProState() {
        return proState;
    }

    public void setProState(Long proState) {
        this.proState = proState;
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

    public ProjectInfoVo() {
    }

    public ProjectInfoVo(Integer proId, String proDept, String saleName, String saleCusname, String proCusground, String proCode, String proName, String proType, String proPeriod, String proScale, String proRelegation, String proViewgress, Long proState, Date proCreatetime, String proIp) {
        this.proId = proId;
        this.proDept = proDept;
        this.saleName = saleName;
        this.saleCusname = saleCusname;
        this.proCusground = proCusground;
        this.proCode = proCode;
        this.proName = proName;
        this.proType = proType;
        this.proPeriod = proPeriod;
        this.proScale = proScale;
        this.proRelegation = proRelegation;
        this.proViewgress = proViewgress;
        this.proState = proState;
        this.proCreatetime = proCreatetime;
        this.proIp = proIp;
    }

    @Override
    public String toString() {
        return "ProjectInfoVo{" +
                "proId=" + proId +
                ", proDept='" + proDept + '\'' +
                ", saleName='" + saleName + '\'' +
                ", saleCusname='" + saleCusname + '\'' +
                ", proCusground='" + proCusground + '\'' +
                ", proCode='" + proCode + '\'' +
                ", proName='" + proName + '\'' +
                ", proType='" + proType + '\'' +
                ", proPeriod='" + proPeriod + '\'' +
                ", proScale='" + proScale + '\'' +
                ", proRelegation='" + proRelegation + '\'' +
                ", proViewgress='" + proViewgress + '\'' +
                ", proState=" + proState +
                ", proCreatetime=" + proCreatetime +
                ", proIp='" + proIp + '\'' +
                '}';
    }
}
