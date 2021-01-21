package com.rayootech.bean.Vo;

import lombok.Data;

import java.util.List;

/**
 * Created by FightingHao on 2020/12/15
 */

@Data
public class TreeSelect02 {

    /** 节点ID */
    private String value;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    private List<TreeSelect02> children;

    public TreeSelect02()
    {

    }

    /**
     * 菜单树
     * @param district
     */
//    public TreeSelect02(District district)
//    {
//        this.value = district.getDistrictName();
//        this.label = district.getDistrictName();
//        this.children = district.getChildren().stream().map(TreeSelect02::new).collect(Collectors.toList());
//    }


}
