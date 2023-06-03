package com.atguigu.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.coupon.entity.SeckillPromotionEntity;
import com.atguigu.gulimall.common.utils.PageUtils;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author cjr
 * @email cjr@gmail.com
 * @date 2023-05-25 01:29:10
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

