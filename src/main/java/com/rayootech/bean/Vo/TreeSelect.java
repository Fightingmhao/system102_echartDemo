package com.rayootech.bean.Vo;

import com.rayootech.bean.Menu;
import com.rayootech.bean.Org;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用于前台展示的树插件
 */
public class TreeSelect {

    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    private List<TreeSelect> children;

    public TreeSelect()
    {

    }

//    public TreeSelect(SysDept dept)
//    {
//        this.id = dept.getDeptId();
//        this.label = dept.getDeptName();
//        this.children = dept.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
//    }

    /**
     * 菜单树
     * @param menu
     */
    public TreeSelect(Menu menu)
    {
        this.id = menu.getMenuId();
        this.label = menu.getMenuName();
        this.children = menu.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    public TreeSelect(Org org)
    {
        this.id = org.getOrgId();
        this.label = org.getOrgName();
        this.children = org.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }



    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public List<TreeSelect> getChildren()
    {
        return children;
    }

    public void setChildren(List<TreeSelect> children)
    {
        this.children = children;
    }
}
