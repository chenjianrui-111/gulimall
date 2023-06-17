package com.atguigu.gulimall.common.to.mq;

import lombok.Data;



/**
 * @author 15983
 */
@Data
public class StockLockedTo {

    /** 库存工作单的id **/
    private Long id;

    /** 工作单详情的所有信息 **/
    private StockDetailTo detailTo;
}
