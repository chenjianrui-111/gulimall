package com.atguigu.gulimall.auth.vo;

import lombok.Data;

/**
 * @author 15983
 * @Description: 社交用户信息
 * @Created: with IntelliJ IDEA.

 **/

@Data
public class SocialUser {

    private String access_token;

    private String remind_in;

    private long expires_in;

    private String uid;

    private String isRealName;

}
