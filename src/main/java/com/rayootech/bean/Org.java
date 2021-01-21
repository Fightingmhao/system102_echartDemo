package com.rayootech.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by FightingHao on 2020/12/5
 */

@Data
public class Org {

    private Long orgId;

    private String orgName;

    private Long parentId;

    /** 祖级列表 */
    private String ancestors;

    /** 显示顺序 */
    private Integer orderNum;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private String orgType;

    private String isDeliver;

    private List<Org> children;
}
