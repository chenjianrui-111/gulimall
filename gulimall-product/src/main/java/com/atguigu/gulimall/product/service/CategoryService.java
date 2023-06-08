package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.product.vo.Catelog2Vo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author cjr
 * @email cjr@gmail.com
 * @date 2023-05-24 19:25:06
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);

    /**
     * 查找一级分类，首页显示
     *
     * @return
     */
    List<CategoryEntity> getLevel1Categories();

    /**
     * 查找二级、三级分类，首页显示
     *
     * @return
     */
    Map<String, List<Catelog2Vo>> getCatalogJson();
}

