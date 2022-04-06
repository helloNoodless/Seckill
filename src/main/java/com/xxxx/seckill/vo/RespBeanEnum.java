package com.xxxx.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 公共返回对象枚举
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //通用
    SUCESS(200,"SUCESS"),
    ERROR(500,"服务端异常"),
    // 登录
    LOGIN_ERROR(500210,"用户名或密码错误"),
    //手机号码格式不正确
    MOBILE_ERROR(500211,"手机号码格式不正确"),
    // 参数校验异常
    BIND_ERROR(500212,"参数校验异常"),
    // 秒杀模块 500500
    EMPTY_STOCK(500500,"库存不足"),
    REPEAT_ERROR(500501,"该商品每人限购一件")
    ;

    private final Integer code;
    private final String message;


}
