package com.rayootech.bean.Vo.echartsVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/12 13:19
 */
public class AnalysisVo {

//    销售姓名
    private String saleName;
//    销售邮箱
    private String infoSaleCode;
//    交付部门
    private String proDept;
//    项目名称
    private String proName;
//    员工工资结算（成本）
    private Double infoSalaryTotal;
//    外协结算
    private Double outShouldTotal;
//    时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM",timezone = "GMT+8")
    private Date monthTime;

    /**成员的Email*/
    private String hrEmail;

    private String yearTime;

    private String quarterTime;

    private String years;

    private String season;

    //   员工成本计算状态
    private Integer infoCalState;

//    外协员工结算状态
    private Integer outCalState;

    private  String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getInfoCalState() {
        return infoCalState;
    }

    public void setInfoCalState(Integer infoCalState) {
        this.infoCalState = infoCalState;
    }

    public Integer getOutCalState() {
        return outCalState;
    }

    public void setOutCalState(Integer outCalState) {
        this.outCalState = outCalState;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public String getInfoSaleCode() {
        return infoSaleCode;
    }

    public void setInfoSaleCode(String infoSaleCode) {
        this.infoSaleCode = infoSaleCode;
    }

    public String getProDept() {
        return proDept;
    }

    public void setProDept(String proDept) {
        this.proDept = proDept;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Double getInfoSalaryTotal() {
        return infoSalaryTotal;
    }

    public void setInfoSalaryTotal(Double infoSalaryTotal) {
        this.infoSalaryTotal = infoSalaryTotal;
    }

    public Double getOutShouldTotal() {
        return outShouldTotal;
    }

    public void setOutShouldTotal(Double outShouldTotal) {
        this.outShouldTotal = outShouldTotal;
    }

    public Date getMonthTime() {
        return monthTime;
    }

    public void setMonthTime(Date monthTime) {
        this.monthTime = monthTime;
    }

    public String getHrEmail() {
        return hrEmail;
    }

    public void setHrEmail(String hrEmail) {
        this.hrEmail = hrEmail;
    }

    public String getYearTime() {
        return yearTime;
    }

    public void setYearTime(String yearTime) {
        this.yearTime = yearTime;
    }

    public String getQuarterTime() {
        return quarterTime;
    }

    public void setQuarterTime(String quarterTime) {
        this.quarterTime = quarterTime;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }


    @Override
    public String toString() {
        return "AnalysisVo{" +
                "saleName='" + saleName + '\'' +
                ", infoSaleCode='" + infoSaleCode + '\'' +
                ", proDept='" + proDept + '\'' +
                ", proName='" + proName + '\'' +
                ", infoSalaryTotal=" + infoSalaryTotal +
                ", outShouldTotal=" + outShouldTotal +
                ", monthTime=" + monthTime +
                ", hrEmail='" + hrEmail + '\'' +
                ", yearTime='" + yearTime + '\'' +
                ", quarterTime='" + quarterTime + '\'' +
                ", years='" + years + '\'' +
                ", season='" + season + '\'' +
                ", infoCalState=" + infoCalState +
                ", outCalState=" + outCalState +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
