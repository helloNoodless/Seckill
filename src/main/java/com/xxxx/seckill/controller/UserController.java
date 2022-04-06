package com.xxxx.seckill.controller;


import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.vo.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaowang
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 用户测试xxx
     * @param user
     * @return
     */

    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user) {
        return RespBean.sucess(user);
    }

}
