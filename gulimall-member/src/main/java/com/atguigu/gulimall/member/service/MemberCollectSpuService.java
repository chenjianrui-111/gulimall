package com.atguigu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.member.entity.MemberCollectSpuEntity;
import com.atguigu.gulimall.common.utils.PageUtils;
import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author cjr
 * @email cjr@gmail.com
 * @date 2023-05-25 02:13:26
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

