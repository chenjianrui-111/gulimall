package com.atguigu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.member.entity.IntegrationChangeHistoryEntity;
import com.atguigu.gulimall.common.utils.PageUtils;
import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author cjr
 * @email cjr@gmail.com
 * @date 2023-05-25 02:13:26
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

