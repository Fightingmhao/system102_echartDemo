package com.rayootech.bean.sale;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



public class Sale
{
    private static final long serialVersionUID = 1L;

    /** 项目主键 */
    private Long saleId;

    /** 客户编码 */
    private String saleCuscode;

    /** 客户名称 */
    private String saleCusname;

    /** 销售编码 */
    private String saleCode;

    /** 销售名称 */
    private String saleName;

    /** 交付部门 */
    private String saleDept;

    /** 签约状态 */
    private Long saleSignstate;

    /** 发布状态 */
    private Long salePutstate;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date saleCreatetime;

    /** 操作id */
    private String saleIp;

    public void setSaleId(Long saleId)
    {
        this.saleId = saleId;
    }

    public Long getSaleId()
    {
        return saleId;
    }
    public void setSaleCuscode(String saleCuscode)
    {
        this.saleCuscode = saleCuscode;
    }

    public String getSaleCuscode()
    {
        return saleCuscode;
    }
    public void setSaleCusname(String saleCusname)
    {
        this.saleCusname = saleCusname;
    }

    public String getSaleCusname()
    {
        return saleCusname;
    }
    public void setSaleCode(String saleCode)
    {
        this.saleCode = saleCode;
    }

    public String getSaleCode()
    {
        return saleCode;
    }
    public void setSaleName(String saleName)
    {
        this.saleName = saleName;
    }

    public String getSaleName()
    {
        return saleName;
    }
    public void setSaleDept(String saleDept)
    {
        this.saleDept = saleDept;
    }

    public String getSaleDept()
    {
        return saleDept;
    }
    public void setSaleSignstate(Long saleSignstate)
    {
        this.saleSignstate = saleSignstate;
    }

    public Long getSaleSignstate()
    {
        return saleSignstate;
    }
    public void setSalePutstate(Long salePutstate)
    {
        this.salePutstate = salePutstate;
    }

    public Long getSalePutstate()
    {
        return salePutstate;
    }
    public void setSaleCreatetime(Date saleCreatetime)
    {
        this.saleCreatetime = saleCreatetime;
    }

    public Date getSaleCreatetime()
    {
        return saleCreatetime;
    }
    public void setSaleIp(String saleIp)
    {
        this.saleIp = saleIp;
    }

    public String getSaleIp()
    {
        return saleIp;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", saleCuscode='" + saleCuscode + '\'' +
                ", saleCusname='" + saleCusname + '\'' +
                ", saleCode='" + saleCode + '\'' +
                ", saleName='" + saleName + '\'' +
                ", saleDept='" + saleDept + '\'' +
                ", saleSignstate=" + saleSignstate +
                ", salePutstate=" + salePutstate +
                ", saleCreatetime=" + saleCreatetime +
                ", saleIp='" + saleIp + '\'' +
                '}';
    }
}
