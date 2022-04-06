package com.xxxx.seckill.service;

import com.xxxx.seckill.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaowang
 * @since 2022-03-30
 */
public interface IGoodsService extends IService<Goods> {
    /**
     * 获取商品列表
     * @return
     */
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
