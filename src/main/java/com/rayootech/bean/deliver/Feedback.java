package com.rayootech.bean.deliver;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 19:30
 */
public class Feedback implements Serializable {

    /** 面试结果反馈序号 */
    private Integer backId;

    /** 候选人姓名 */
    private String backName;

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

    /** 面试表的主键 */
    private Integer viewId;

    /** 部门主键 */
    private Integer deptId;

    public Integer getBackId() {
        return backId;
    }

    public void setBackId(Integer backId) {
        this.backId = backId;
    }

    public String getBackName() {
        return backName;
    }

    public void setBackName(String backName) {
        this.backName = backName;
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

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "backId=" + backId +
                ", backName='" + backName + '\'' +
                ", backResult=" + backResult +
                ", backEvalua='" + backEvalua + '\'' +
                ", backOfferLow='" + backOfferLow + '\'' +
                ", backOfferHigh='" + backOfferHigh + '\'' +
                ", backState='" + backState + '\'' +
                ", backCreatetime=" + backCreatetime +
                ", backIp='" + backIp + '\'' +
                ", viewId=" + viewId +
                ", deptId=" + deptId +
                '}';
    }
}
