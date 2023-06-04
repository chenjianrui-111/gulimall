package com.atguigu.gulimall.ware.service;

import com.atguigu.gulimall.ware.vo.DoneReqVo;
import com.atguigu.gulimall.ware.vo.MergeReqVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.ware.entity.PurchaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author cjr
 * @email cjr@gmail.com
 * @date 2023-05-25 02:47:16
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void done(DoneReqVo doneReqVo);

    PageUtils getUnclaimedPurchase(Map<String, Object> params);

    void mergePurchase(MergeReqVo mergeReqVo);

    void receivePurchase(List<Long> ids);
}

