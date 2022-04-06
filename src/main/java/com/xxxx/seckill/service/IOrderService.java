package com.xxxx.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.seckill.pojo.Order;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaowang
 * @since 2022-03-30
 */
public interface IOrderService extends IService<Order> {
    /**
     * 秒杀功能
     * @param user
     * @param goods
     * @return
     */
   Order seckill(User user, GoodsVo goods);
}
