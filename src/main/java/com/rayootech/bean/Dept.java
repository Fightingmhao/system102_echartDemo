package com.rayootech.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Dept {
    private Long deptId;

    private String deptCode;

    private String deptName;

    private Long deptFather;

    private Long deptAncestors;

    private String deptState;

    private Date deptTime;

    private String deptCreateip;


}