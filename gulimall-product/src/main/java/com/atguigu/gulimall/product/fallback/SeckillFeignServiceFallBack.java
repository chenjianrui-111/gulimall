package com.atguigu.gulimall.product.fallback;


import com.atguigu.gulimall.common.exception.BizCodeEnum;
import com.atguigu.gulimall.common.utils.R;
import com.atguigu.gulimall.product.feign.SeckillFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: CJR
 **/

@Component
@Slf4j
public class SeckillFeignServiceFallBack implements SeckillFeignService {

    @Override
    public R getSkuSeckilInfo(Long skuId) {
        log.info("查询商品是否参与秒杀活动熔断方法被调用: getSkuSeckilInfo()~~~~~~~");
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMsg());
    }
}
