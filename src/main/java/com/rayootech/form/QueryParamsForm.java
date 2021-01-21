package com.rayootech.form;

import lombok.Data;

/**
 * Created by FightingHao on 2020/11/26
 */

@Data
public class QueryParamsForm {



//    private Integer currentPage;
//    private Integer pageSize;
    private String userName;

    private Long postId;

    public QueryParamsForm(String userName, Long postId) {
        this.userName = userName;
        this.postId = postId;
    }
}
