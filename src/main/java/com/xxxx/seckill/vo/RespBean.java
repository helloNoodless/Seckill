package com.xxxx.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     * @return
     */
    public static RespBean sucess(){
        return new RespBean(RespBeanEnum.SUCESS.getCode(),RespBeanEnum.SUCESS.getMessage(),null);
    }
    public static RespBean sucess(Object obj){
        return new RespBean(RespBeanEnum.SUCESS.getCode(),RespBeanEnum.SUCESS.getMessage(),obj);
    }

    /**
     * 失败返回结果
     * @param respBeanEnum
     * @return
     */
    public static RespBean error(RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),null);
    }
    public static RespBean error(RespBeanEnum respBeanEnum,Object obj) {
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),obj);
    }

}
