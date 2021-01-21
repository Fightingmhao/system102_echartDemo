package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/16 10:30
 */
public class AttendanceVo {
    private int attId;
    /**项目名称*/
    private String canProName;

    /**在职表主键*/
    private Integer staffId;

    /**候选人主键*/
    private  Integer canId;

    /**在职人员名字*/
    private String staffName;

    /**在职人员编码*/
    private String staffCode;

    /**是否是外协*/
    private Integer staffIsout;

    /** 实际出勤天数 */
    private Integer attRealday;

    /** 法定工作天数 */
    private Integer attLegalday;

    /** 试用期天数 */
    private Integer attTestday;

    /** 转正天数 */
    private Integer attFormalday;

    /** 使用期请假天数 */
    private Integer attTestask;

    /** 转正请假天数 */
    private Integer attFormalask;

    /** 请假类型 */
    private Integer attTypask;

    /** 状态 */
    private Integer attState;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date attCreattime;

    /** 操作id */
    private String attIp;

    /**员工在职状态*/
    private Integer staffState;

    /**考勤时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM",timezone = "GMT+8")
    private Date attTime;


    public Integer getStaffState() {
        return staffState;
    }

    public void setStaffState(Integer staffState) {
        this.staffState = staffState;
    }




    public String getCanProName() {
        return canProName;
    }

    public void setCanProName(String canProName) {
        this.canProName = canProName;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public Integer getStaffIsout() {
        return staffIsout;
    }

    public void setStaffIsout(Integer staffIsout) {
        this.staffIsout = staffIsout;
    }

    public Integer getAttRealday() {
        return attRealday;
    }

    public void setAttRealday(Integer attRealday) {
        this.attRealday = attRealday;
    }

    public Integer getAttLegalday() {
        return attLegalday;
    }

    public void setAttLegalday(Integer attLegalday) {
        this.attLegalday = attLegalday;
    }

    public Integer getAttTestday() {
        return attTestday;
    }

    public void setAttTestday(Integer attTestday) {
        this.attTestday = attTestday;
    }

    public Integer getAttFormalday() {
        return attFormalday;
    }

    public void setAttFormalday(Integer attFormalday) {
        this.attFormalday = attFormalday;
    }

    public Integer getAttTestask() {
        return attTestask;
    }

    public void setAttTestask(Integer attTestask) {
        this.attTestask = attTestask;
    }

    public Integer getAttFormalask() {
        return attFormalask;
    }

    public void setAttFormalask(Integer attFormalask) {
        this.attFormalask = attFormalask;
    }

    public Integer getAttTypask() {
        return attTypask;
    }

    public void setAttTypask(Integer attTypask) {
        this.attTypask = attTypask;
    }

    public Integer getAttState() {
        return attState;
    }

    public void setAttState(Integer attState) {
        this.attState = attState;
    }

    public Date getAttCreattime() {
        return attCreattime;
    }

    public void setAttCreattime(Date attCreattime) {
        this.attCreattime = attCreattime;
    }

    public String getAttIp() {
        return attIp;
    }

    public void setAttIp(String attIp) {
        this.attIp = attIp;
    }

    public int getAttId() {
        return attId;
    }

    public void setAttId(int attId) {
        this.attId = attId;
    }

    public Date getAttTime() {
        return attTime;
    }

    public void setAttTime(Date attTime) {
        this.attTime = attTime;
    }

    @Override
    public String toString() {
        return "AttendanceVo{" +
                "attId=" + attId +
                ", canProName='" + canProName + '\'' +
                ", staffId=" + staffId +
                ", canId=" + canId +
                ", staffName='" + staffName + '\'' +
                ", staffCode='" + staffCode + '\'' +
                ", staffIsout=" + staffIsout +
                ", attRealday=" + attRealday +
                ", attLegalday=" + attLegalday +
                ", attTestday=" + attTestday +
                ", attFormalday=" + attFormalday +
                ", attTestask=" + attTestask +
                ", attFormalask=" + attFormalask +
                ", attTypask=" + attTypask +
                ", attState=" + attState +
                ", attCreattime=" + attCreattime +
                ", attIp='" + attIp + '\'' +
                ", staffState=" + staffState +
                ", attTime=" + attTime +
                '}';
    }
}
