package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/11 17:19
 */
public class CustomerVo {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer cusId;

    /** 客户名称 */
    private String cusName;

    private String canHremail;

    /** 客户介绍 */
    private String cusIntroduce;

    /** 接触人 */
    private String cusDock;

    /** 接触人联系方式 */
    private String cusPhone;

    /** 客户地址 */
    private String cusAddress;

    /** 销售编码 */
    private String cusSalecode;

    /** 接触时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date cusContacttime;

    /** 接触状态 */
    private Long cusState;

    /** 备注 */
    private String cusRemarks;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date cusTime;

    /** 操作id */
    private String cusIp;

    private String  canHrname;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCanHremail() {
        return canHremail;
    }

    public void setCanHremail(String canHremail) {
        this.canHremail = canHremail;
    }

    public String getCusIntroduce() {
        return cusIntroduce;
    }

    public void setCusIntroduce(String cusIntroduce) {
        this.cusIntroduce = cusIntroduce;
    }

    public String getCusDock() {
        return cusDock;
    }

    public void setCusDock(String cusDock) {
        this.cusDock = cusDock;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusSalecode() {
        return cusSalecode;
    }

    public void setCusSalecode(String cusSalecode) {
        this.cusSalecode = cusSalecode;
    }

    public Date getCusContacttime() {
        return cusContacttime;
    }

    public void setCusContacttime(Date cusContacttime) {
        this.cusContacttime = cusContacttime;
    }

    public Long getCusState() {
        return cusState;
    }

    public void setCusState(Long cusState) {
        this.cusState = cusState;
    }

    public String getCusRemarks() {
        return cusRemarks;
    }

    public void setCusRemarks(String cusRemarks) {
        this.cusRemarks = cusRemarks;
    }

    public Date getCusTime() {
        return cusTime;
    }

    public void setCusTime(Date cusTime) {
        this.cusTime = cusTime;
    }

    public String getCusIp() {
        return cusIp;
    }

    public void setCusIp(String cusIp) {
        this.cusIp = cusIp;
    }

    public String getCanHrname() {
        return canHrname;
    }

    public void setCanHrname(String canHrname) {
        this.canHrname = canHrname;
    }

    @Override
    public String toString() {
        return "CustomerVo{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", cusIntroduce='" + cusIntroduce + '\'' +
                ", cusDock='" + cusDock + '\'' +
                ", cusPhone='" + cusPhone + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusSalecode='" + cusSalecode + '\'' +
                ", cusContacttime=" + cusContacttime +
                ", cusState=" + cusState +
                ", cusRemarks='" + cusRemarks + '\'' +
                ", cusTime=" + cusTime +
                ", cusIp='" + cusIp + '\'' +
                ", canHrname='" + canHrname + '\'' +
                '}';
    }
}
