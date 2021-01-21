package com.rayootech.resultInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * Created by FightingHao on 2020/3/5
 *
 * 用来配置响应的返回信息
 */

@Data
//序列化配置
//@JsonSerialize(include = )/旧版本
@JsonInclude(value = JsonInclude.Include.NON_NULL)//可将空字段不反回，新版
public class ResponseVo<T> {

    private Integer status;

    private String msg;

    private T data;

    private ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    private ResponseVo(Integer status, T data) {
        this.status = status;
        this.data = data;
    }
    private ResponseVo(String msg) {
        this.msg = msg;
    }

    //成功的静态方法，用来调用
    public static <T> ResponseVo<T> successByMsg(String msg){
        return new ResponseVo(ResponseEnum.SUCCESS.code,msg);
    }
    public static <T> ResponseVo<T> success(T data){
        return new ResponseVo<>(ResponseEnum.SUCCESS.code,data);
    }
    public static <T> ResponseVo<T> success(){
        return new ResponseVo<>(ResponseEnum.SUCCESS.code, ResponseEnum.SUCCESS.desc);
    }

    public static <T> ResponseVo<T> success(Integer status, T data){
        return new ResponseVo<>(status, data);
    }


    public static <T> ResponseVo<T> error(Integer status, String msg){
        return new ResponseVo(status,msg);
    }

    public static <T> ResponseVo<T> error(String msg){
        return new ResponseVo(ResponseEnum.ERROR.code,msg);
    }

    public static <T> ResponseVo<T> error(ResponseEnum responseEnum){
        return new ResponseVo<>(responseEnum.code,responseEnum.desc);
    }




    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, String msg){
        return new ResponseVo<>(responseEnum.code,msg);
    }
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, BindingResult bindingResult){
        return new ResponseVo<>(responseEnum.code,
                Objects.requireNonNull(bindingResult.getFieldError()).getField() + " " + bindingResult.getFieldError().getDefaultMessage());
    }



}
