package com.xxxx.seckill.controller;

import com.xxxx.seckill.service.IUserService;
import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

// restcontroller会默认给类所有方法增加responsebody  这样就是返回一个对象(比如下面的toLogin 直接返回login这个字符串到网页)  而不是页面跳转  如果页面跳转要用controller
//@RestController
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private IUserService userService;
    /**
     * 跳转登录界面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        // 使用controller跳转到template下的login.html 如果是restcontroller  那么网页输出就是login关键之
        return "login";
    }

    /**
     * 登录功能
     * @param loginVo
     * @return
     */
    @RequestMapping("/doLogin")
    // 如果是返回对象  要加responsebody注解
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {

        log.info("{}",loginVo);

        return userService.doLogin(loginVo,request,response);

    }

}
