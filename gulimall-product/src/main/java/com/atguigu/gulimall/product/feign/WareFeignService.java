package com.atguigu.gulimall.product.feign;

import com.atguigu.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



//@FeignClient("gulimall-ware")
//public interface WareFeignService {
//
//    @PostMapping(value = "/ware/waresku/hasStock")
//    R getSkuHasStock(@RequestBody List<Long> skuIds);
//
//}
