package com.rayootech.bean.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by FightingHao on 2020/12/1
 */
@Data
public class DeptVo {

    private Long deptId;

    private String deptCode;

    private String deptName;

    private String deptFather;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deptTime;

}
