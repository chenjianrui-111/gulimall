package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 **/

@Data
public class PurchaseDoneVo {

    @NotNull(message = "id不允许为空")
    private Long id;

    private List<PurchaseItemDoneVo> items;

}
