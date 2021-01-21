package com.rayootech.bean.sale;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 客户线索信息对象 customer
 * 
 * @author ruoyi
 * @date 2020-11-25
 */
public class Customer
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer cusId;

    /** 客户名称 */
    private String cusName;

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

    public void setCusId(Integer cusId)
    {
        this.cusId = cusId;
    }

    public Integer getCusId()
    {
        return cusId;
    }
    public void setCusName(String cusName) 
    {
        this.cusName = cusName;
    }

    public String getCusName() 
    {
        return cusName;
    }
    public void setCusIntroduce(String cusIntroduce) 
    {
        this.cusIntroduce = cusIntroduce;
    }

    public String getCusIntroduce() 
    {
        return cusIntroduce;
    }
    public void setCusDock(String cusDock) 
    {
        this.cusDock = cusDock;
    }

    public String getCusDock() 
    {
        return cusDock;
    }
    public void setCusPhone(String cusPhone) 
    {
        this.cusPhone = cusPhone;
    }

    public String getCusPhone() 
    {
        return cusPhone;
    }
    public void setCusAddress(String cusAddress) 
    {
        this.cusAddress = cusAddress;
    }

    public String getCusAddress() 
    {
        return cusAddress;
    }
    public void setCusSalecode(String cusSalecode) 
    {
        this.cusSalecode = cusSalecode;
    }

    public String getCusSalecode() 
    {
        return cusSalecode;
    }
    public void setCusContacttime(Date cusContacttime) 
    {
        this.cusContacttime = cusContacttime;
    }

    public Date getCusContacttime() 
    {
        return cusContacttime;
    }
    public void setCusState(Long cusState) 
    {
        this.cusState = cusState;
    }

    public Long getCusState() 
    {
        return cusState;
    }
    public void setCusRemarks(String cusRemarks) 
    {
        this.cusRemarks = cusRemarks;
    }

    public String getCusRemarks() 
    {
        return cusRemarks;
    }
    public void setCusTime(Date cusTime) 
    {
        this.cusTime = cusTime;
    }

    public Date getCusTime() 
    {
        return cusTime;
    }
    public void setCusIp(String cusIp)
    {
        this.cusIp = cusIp;
    }

    public String getCusIp()
    {
        return cusIp;
    }

    @Override
    public String toString() {
        return "Customer{" +
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
                ", cusIp=" + cusIp +
                '}';
    }
}
