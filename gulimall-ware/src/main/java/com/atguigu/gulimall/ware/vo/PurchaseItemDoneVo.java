package com.atguigu.gulimall.ware.vo;

import lombok.Data;

/**
 * @author 15983
 * @Description:
 * @Created: with IntelliJ IDEA.
 **/

@Data
public class PurchaseItemDoneVo {

    private Long itemId;

    private Integer status;

    private String reason;

}
