package com.rayootech.bean.Vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CandidateVo
{
    private static final long serialVersionUID = 1L;

    /** 推荐表主键 */
    private Integer canId;

    /** 项目名称 */
    private String canProName;

    /**部门名称*/
    private String canDept;

    /** 候选人名字 */
    private String canName;

//    候选人身份证
    private String canCard;

    /** 候选人性别 */
    private String canSex;

    /** 候选人电话 */
    private String canPhone;

    /** 推荐岗位 */
    private String canPost;

    /** 招聘姓名 */
    private String canHrname;

    /** 候选人邮件 */
    private String canHremail;

    /** 发布状态 */
    private Integer canState;

    /** 简历审核状态 */
    private Integer canResstate;

    /** 简历副本 */
    private MultipartFile canResumecopy;

    private String canText;

    private String canIp;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getCanName() {
        return canName;
    }

    public void setCanName(String canName) {
        this.canName = canName;
    }

    public String getCanCard() {
        return canCard;
    }

    public void setCanCard(String canCard) {
        this.canCard = canCard;
    }

    public String getCanSex() {
        return canSex;
    }

    public void setCanSex(String canSex) {
        this.canSex = canSex;
    }

    public String getCanPhone() {
        return canPhone;
    }

    public void setCanPhone(String canPhone) {
        this.canPhone = canPhone;
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

    public Integer getCanState() {
        return canState;
    }

    public void setCanState(Integer canState) {
        this.canState = canState;
    }

    public Integer getCanResstate() {
        return canResstate;
    }

    public void setCanResstate(Integer canResstate) {
        this.canResstate = canResstate;
    }

    public MultipartFile getCanResumecopy() {
        return canResumecopy;
    }

    public void setCanResumecopy(MultipartFile canResumecopy) {
        this.canResumecopy = canResumecopy;
    }

    public String getCanText() {
        return canText;
    }

    public void setCanText(String canText) {
        this.canText = canText;
    }

    public String getCanIp() {
        return canIp;
    }

    public void setCanIp(String canIp) {
        this.canIp = canIp;
    }
}
