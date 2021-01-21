package com.rayootech.bean.deliver;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 21:42
 */
public class ResumeCheck implements Serializable {
    /** 简历审核表主键 */
    private Integer checkId;

    /** 推荐表外键 */
    private Integer canId;

    /** 简历审核状态 */
    private Integer checkState;

    /** 审核人员 */
    private String checkName;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date checkCreatetime;

    /** 操作ID */
    private String checkIp;

    /** 交付部门 */
    private String checkDept;

    /** 发布状态 */
    private Integer checkPubstate;

    /** 部门外键 */
    private Integer deptId;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getCanId() {
        return canId;
    }

    public void setCanId(Integer canId) {
        this.canId = canId;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public Date getCheckCreatetime() {
        return checkCreatetime;
    }

    public void setCheckCreatetime(Date checkCreatetime) {
        this.checkCreatetime = checkCreatetime;
    }

    public String getCheckIp() {
        return checkIp;
    }

    public void setCheckIp(String checkIp) {
        this.checkIp = checkIp;
    }

    public String getCheckDept() {
        return checkDept;
    }

    public void setCheckDept(String checkDept) {
        this.checkDept = checkDept;
    }

    public Integer getCheckPubstate() {
        return checkPubstate;
    }

    public void setCheckPubstate(Integer checkPubstate) {
        this.checkPubstate = checkPubstate;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "ResumeCheck{" +
                "checkId=" + checkId +
                ", canId=" + canId +
                ", checkState=" + checkState +
                ", checkName='" + checkName + '\'' +
                ", checkCreatetime=" + checkCreatetime +
                ", checkIp='" + checkIp + '\'' +
                ", checkDept='" + checkDept + '\'' +
                ", checkPubstate=" + checkPubstate +
                ", deptId=" + deptId +
                '}';
    }
}
