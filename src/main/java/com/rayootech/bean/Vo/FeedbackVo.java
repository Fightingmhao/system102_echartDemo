package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 19:46
 */

@Data
public class FeedbackVo {
    /** 推荐表主键 */
    private Integer canId;

    /** 项目名称 */
    private String canProName;

    /**部门名称*/
    private String canDept;

    /** 候选人名字 */
    private String viewName;

    /** 候选人性别 */
    private String canSex;

    /** 推荐岗位 */
    private String canPost;

    /** 招聘姓名 */
    private String canHrname;

    /** 推荐人邮件 */
    private String canHremail;

    /** 简历副本 */
    private String canResumecopy;

    private String canText;

    /** 面试时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date viewTime;

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

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getCanSex() {
        return canSex;
    }

    public void setCanSex(String canSex) {
        this.canSex = canSex;
    }

    public String getCanPost() {
        return canPost;
    }

    public void setCanPost(String canPost) {
        this.canPost = canPost;
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

    public String getCanResumecopy() {
        return canResumecopy;
    }

    public void setCanResumecopy(String canResumecopy) {
        this.canResumecopy = canResumecopy;
    }

    public String getCanText() {
        return canText;
    }

    public void setCanText(String canText) {
        this.canText = canText;
    }

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
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

    public String getBackIp() {
        return backIp;
    }

    public void setBackIp(String backIp) {
        this.backIp = backIp;
    }
}
