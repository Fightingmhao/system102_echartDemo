package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 23:52
 */
public class FeedbackResultVo {
    /** 推荐表主键 */
    private Integer canId;

    /** 项目名称 */
    private String canProName;

    /**部门名称*/
    private String canDept;

    /** 招聘姓名 */
    private String canHrname;

    /** 候选人邮件 */
    private String canHremail;

    /** 候选人名字 */
    private String canName;

    /** 面试结果 */
    private Integer backResult;

    /** 面试评价 */
    private String backEvalua;

    /** 最低报价*/
    private BigDecimal backOfferLow;

    /** 最高报价*/
    private BigDecimal backOfferHigh;

    /** 发布状态 */
    private String backState;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date backCreatetime;

    /** 操作ID */
    private String backIp;

    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
    }

    public String getCanProName() {
        return canProName;
    }

    public void setCanProName(String canProName) {
        this.canProName = canProName;
    }

    public String getCanDept() {
        return canDept;
    }

    public void setCanDept(String canDept) {
        this.canDept = canDept;
    }

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

    public String getCanName() {
        return canName;
    }

    public void setCanName(String canName) {
        this.canName = canName;
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

    public String getBackState() {
        return backState;
    }

    public void setBackState(String backState) {
        this.backState = backState;
    }

    public Date getBackCreatetime() {
        return backCreatetime;
    }

    public void setBackCreatetime(Date backCreatetime) {
        this.backCreatetime = backCreatetime;
    }

    public String getBackIp() {
        return backIp;
    }

    public void setBackIp(String backIp) {
        this.backIp = backIp;
    }

    @Override
    public String toString() {
        return "FeedbackResultVo{" +
                "canId=" + canId +
                ", canProName='" + canProName + '\'' +
                ", canDept='" + canDept + '\'' +
                ", canHrname='" + canHrname + '\'' +
                ", canHremail='" + canHremail + '\'' +
                ", canName='" + canName + '\'' +
                ", backResult=" + backResult +
                ", backEvalua='" + backEvalua + '\'' +
                ", backOfferLow=" + backOfferLow +
                ", backOfferHigh=" + backOfferHigh +
                ", backState='" + backState + '\'' +
                ", backCreatetime=" + backCreatetime +
                ", backIp='" + backIp + '\'' +
                '}';
    }
}
