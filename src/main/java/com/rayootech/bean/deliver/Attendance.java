package com.rayootech.bean.deliver;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/16 10:28
 */
public class Attendance {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer attId;

    /** 在职表主键 */
    private Integer staffId;

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

    /**考勤时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM",timezone = "GMT+8")
    private Date attTime;

    public Date getAttTime() {
        return attTime;
    }

    public void setAttTime(Date attTime) {
        this.attTime = attTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAttId() {
        return attId;
    }

    public void setAttId(Integer attId) {
        this.attId = attId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    @Override
    public String toString() {
        return "Attendance{" +
                "attId=" + attId +
                ", staffId=" + staffId +
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
                ", attTime=" + attTime +
                '}';
    }
}
