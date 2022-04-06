package com.xxxx.seckill.utils;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }
    private static final String salt = "1a2b3c4d";
    // 第一次md5加密 前端传给后端的时候
    public static String inputPssToFormPass(String inputPassword) {
        String str = ""+salt.charAt(0)+salt.charAt(2)+inputPassword+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    // 第二次后端加密 后端传入数据库的时候
    public  static String formPassToDBPass(String formPass, String salt) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + formPass +salt.charAt(5)
                + salt.charAt(4);
        return md5(str);
    }
    public static String inputPassToDbPass(String inputPass,String saltDB) {
        String formPass = inputPssToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass,saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
        // 123456 ---->  md5 ---->  d3b1294a61a07da9b49b6e22b2cbd7f9
        System.out.println(inputPssToFormPass("123456"));
        System.out.println(formPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9","1a2b3c4d"));
        System.out.println(inputPassToDbPass("123456","1a2b3c4d"));
    }
}
