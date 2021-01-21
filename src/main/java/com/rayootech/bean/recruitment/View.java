package com.rayootech.bean.recruitment;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 14:20
 */
public class View implements Serializable {

    /** 约面试表主键 */
    private Integer viewId;

    /** 推荐表主键 */
    private Integer canId;

    /** 候选人姓名 */
    private String viewName;

    /** 面试时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date viewTime;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date viewCreatetime;

    /** 操作id */
    private String viewIp;

    /** 发布状态（0有效1无效） */
    private Integer viewState;

    /** 部门外键 */
    private Integer deptId;

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }

    public Date getViewCreatetime() {
        return viewCreatetime;
    }

    public void setViewCreatetime(Date viewCreatetime) {
        this.viewCreatetime = viewCreatetime;
    }

    public String getViewIp() {
        return viewIp;
    }

    public void setViewIp(String viewIp) {
        this.viewIp = viewIp;
    }

    public Integer getViewState() {
        return viewState;
    }

    public void setViewState(Integer viewState) {
        this.viewState = viewState;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public View() {
    }

    public View(Integer canId, String viewName, Date viewTime, Date viewCreatetime, String viewIp, Integer viewState) {
        this.viewId = viewId;
        this.canId = canId;
        this.viewName = viewName;
        this.viewTime = viewTime;
        this.viewCreatetime = viewCreatetime;
        this.viewIp = viewIp;
        this.viewState = viewState;
    }

    @Override
    public String toString() {
        return "View{" +
                "viewId=" + viewId +
                ", canId=" + canId +
                ", viewName='" + viewName + '\'' +
                ", viewTime=" + viewTime +
                ", viewCreatetime=" + viewCreatetime +
                ", viewIp='" + viewIp + '\'' +
                ", viewState=" + viewState +
                ", deptId=" + deptId +
                '}';
    }
}
