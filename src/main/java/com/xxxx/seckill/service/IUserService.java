package com.xxxx.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaowang
 * @since 2022-03-27
 */
public interface IUserService extends IService<User> {

   // RespBean doLogin(LoginVo loginVo);

    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
    /**
     * 根据cookie获取用户
     */
    User getUserByCookie(String userTicket,HttpServletResponse response,HttpServletRequest request);
}
