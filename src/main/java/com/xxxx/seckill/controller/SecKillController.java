package com.xxxx.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.seckill.pojo.SeckillOrder;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IGoodsService;
import com.xxxx.seckill.service.IOrderService;
import com.xxxx.seckill.service.ISeckillOrderService;
import com.xxxx.seckill.vo.GoodsVo;
import com.xxxx.seckill.pojo.Order;
import com.xxxx.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seckill")
public class SecKillController {
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/doSecKill")
    public String doSeckill(Model model, User user,Long goodsId) {
        if (user == null) {
            return "login";
        }
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        // 判断库存
        if (goods.getStockCount() < 1) {
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";

        }
        // 判断订单 用户不能重复抢购
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_Id", goodsId));
        if (seckillOrder != null) {
            // 如果订单不为空 就是重复抢购
            model.addAttribute("errmsg",RespBeanEnum.REPEAT_ERROR.getMessage());
            return "secKillFail";
        }
       Order order =  orderService.seckill(user,goods);
        model.addAttribute("order",order);
        model.addAttribute("goods",goods);

        return "orderDetail";

    }
}
