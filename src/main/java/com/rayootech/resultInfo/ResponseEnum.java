package com.rayootech.resultInfo;

import lombok.Getter;

/**
 * Created by FightingHao on 2020/3/5
 */

@Getter
public enum ResponseEnum {

    ERROR(-1,"服务端异常"),

    SUCCESS(0,"成功"),

    PASSWORD_ERROR(1,"密码错误"),

    USERNAME_EXIST(2,"用户账号已存在"),

    PARAM_ERROR(3,"参数错误"),

    EMAIL_EXIST(4,"邮箱已存在"),

    NOT_ALLOW_DELETE(5,"超级管理员账户不能删除！"),

    OLD_PASSWORD_ERROR(6,"修改密码失败，旧密码错误"),

    OLD_NEW_NOSAME(7,"新密码不能与旧密码相同"),

    NEED_LOGIN(10086,"用户未登录，请先登录"),

    USERNAME_OR_PASSWORD_ERROR(11,"用户名或密码错误"),

    NOT_ALLOW_UPDATE(12,"超级管理员账户不能更改！"),





    PRODUCT_NOT_EXIST(13,"商品不存在"),

    PRODUCT_STOCK_ERROR(14,"库存不正确"),

    CART_PRODUCT_NOT_EXIST(15,"购物车里没有该商品"),

    DELETE_SHIPPING_FAIL(16,"删除收货地址失败"),

    SHIPPING_NOT_EXIST(17,"收货地址不存在"),

    CART_SELECTED_IS_EMPTY(18,"请选择商品后下单"),

    ORDER_NOT_EXIST(19,"订单不存在"),

    ORDER_STATUS_ERROR(20,"订单状态不正确"),


    ;

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
