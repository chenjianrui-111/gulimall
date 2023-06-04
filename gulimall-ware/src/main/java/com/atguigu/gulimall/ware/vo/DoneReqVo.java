package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
public class DoneReqVo {

    /**
     * 采购单id
     */
    @NotNull
    private Long id;
    /**
     * //完成/失败的需求详情
     */
    private List<item> items;
}
