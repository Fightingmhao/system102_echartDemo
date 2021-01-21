package com.rayootech.bean;


import lombok.Data;

@Data
public class District {
    private Integer id;

    private Integer parentId;

    private String districtName;

    private Integer type;

    private Integer hierarchy;

    private String districtSqe;

//    private List<District> children;
}