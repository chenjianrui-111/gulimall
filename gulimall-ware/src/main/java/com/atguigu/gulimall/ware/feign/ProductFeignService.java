package com.atguigu.gulimall.ware.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "gulimall-product")
public interface ProductFeignService {

    @GetMapping("/product/skuinfo/getSkuName")
    public String getSkuName(@RequestParam Long skuId);
}
