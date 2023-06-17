package com.atguigu.gulimall.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 15983
 * @Description:
 * @Created: with IntelliJ IDEA.
 **/

@Data
public class FareVo {

    private MemberAddressVo address;

    private BigDecimal fare;

}
