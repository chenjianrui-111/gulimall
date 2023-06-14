package com.atguigu.gulimall.member.exception;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 **/
public class UsernameException extends RuntimeException {


    public UsernameException() {
        super("存在相同的用户名");
    }
}
