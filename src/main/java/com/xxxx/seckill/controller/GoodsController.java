package com.xxxx.seckill.controller;

import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IGoodsService;
import com.xxxx.seckill.service.IUserService;
import com.xxxx.seckill.vo.GoodsVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 商品
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IGoodsService goodsService;
    @RequestMapping("/toList")
    /**
     * 登录改进版本  对于user传入之前通过WebConfig进行了改进（判断）
     */
    public String toList( Model model, User user){

        // 传到前端
        model.addAttribute("user",user);
        //System.out.println(user.getNickname());
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }
    /**
     * 未改进版本 缺点在于  每次都要进行登录校验  改进办法 在形参传入之前 进行校验
     */
//    public String toList(HttpServletRequest request, HttpServletResponse response, Model model, @CookieValue("userTicket") String ticket){
//        if (StringUtils.isEmpty(ticket)) {
//            // cookie不存在 返回登录界面
//            return "login";
//        }
//        //User user = (User)session.getAttribute(ticket);
//        User user = iUserService.getUserByCookie(ticket, response, request);
//        if (user == null) {
//            return "login";
//        }
//        // 传到前端
//        model.addAttribute("user",user);
//        //System.out.println(user.getNickname());
//        return "goodsList";
//    }

    /**
     * 跳转商品详情页
     * @param goodsId
     * @return
     */
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model,User user, @PathVariable Long goodsId) {
        model.addAttribute("user",user);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        // 秒杀状态 0未开始 1进行中 2已结束
        int secKillStatus = 0;
        // 秒杀倒计时
        int remainSeconds = 0;
        if (nowDate.before(startDate)) {
            // 秒杀倒计时
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime())/1000);
            secKillStatus = 0;
        }else if (nowDate.after(endDate)) {
            secKillStatus = 2;
            remainSeconds = -1;
        }else {
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("remainSeconds",remainSeconds);
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("goods",goodsVo);
        return "goodsDetail";
    }

}
