package com.atguigu.gulimall.common.vo;

import lombok.Data;

import java.math.BigDecimal;



/**
 * @author 15983
 */
@Data
public class SpuBoundTo {

    private Long spuId;

    private BigDecimal buyBounds;

    private BigDecimal growBounds;

}
