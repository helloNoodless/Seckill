package com.xxxx.seckill.mapper;

import com.xxxx.seckill.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaowang
 * @since 2022-03-30
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 获取商品列表
     * @return
     */

    List<GoodsVo> findGoodsVo();

    /**
     * 获取商品详情
     * @param goodsId
     * @return
     */

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
