package com.atguigu.gulimall.cart.to;

import lombok.Data;

/**
 * @author 15983
 * @Description:
 * @Created: with IntelliJ IDEA.
 **/
@Data
public class UserInfoTo {

    private Long userId;

    private String userKey;

    /**
     * 是否临时用户
     */
    private Boolean tempUser = false;

}
