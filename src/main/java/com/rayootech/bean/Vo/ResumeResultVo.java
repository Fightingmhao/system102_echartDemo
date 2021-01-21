package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/30 21:21
 */
@Data
public class ResumeResultVo {
    /** 推荐表主键 */
    private Integer canId;

    /**部门名称*/
    private String canDept;

    /** 项目名称 */
    private String canProName;

    /** 招聘姓名 */
    private String canHrname;

    /** 候选人名字 */
    private String canName;

    /** 候选人性别 */
    private String canSex;

    /** 候选人电话 */
    private String canPhone;

    /** 推荐岗位 */
    private String canPost;

    /** 简历副本 */
    private String canResumecopy;

    /** 发布状态 */
    private Integer checkPubstate;

    /** 简历审核状态 */
    private Integer checkState;

    /** 审核人员 */
    private String checkName;

    private String canText;


    /** 招聘Email*/
    private String canHremail;

    /** 操作时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date checkCreatetime;

    /** 操作ID */
    private String checkIp;




    public ResumeResultVo() {
    }

    public ResumeResultVo(Integer canId, String canDept, String canProName, String canHrname, String canName, String canSex, String canPhone, String canPost, String canResumecopy, Integer checkPubstate, Integer checkState, String checkName, Date checkCreatetime, String checkIp) {
        this.canId = canId;
        this.canDept = canDept;
        this.canProName = canProName;
        this.canHrname = canHrname;
        this.canName = canName;
        this.canSex = canSex;
        this.canPhone = canPhone;
        this.canPost = canPost;
        this.canResumecopy = canResumecopy;
        this.checkPubstate = checkPubstate;
        this.checkState = checkState;
        this.checkName = checkName;
        this.checkCreatetime = checkCreatetime;
        this.checkIp = checkIp;
    }


}
