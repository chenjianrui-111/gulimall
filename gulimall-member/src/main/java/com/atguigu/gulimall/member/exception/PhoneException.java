package com.atguigu.gulimall.member.exception;

/**
 * @author 15983
 * @Description:
 * @Created: with IntelliJ IDEA.
 **/
public class PhoneException extends RuntimeException {

    public PhoneException() {
        super("存在相同的手机号");
    }
}
