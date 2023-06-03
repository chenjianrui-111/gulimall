package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.dao.CategoryDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.common.utils.Query;
import com.atguigu.gulimall.product.dao.AttrGroupDao;
import com.atguigu.gulimall.product.entity.AttrGroupEntity;
import com.atguigu.gulimall.product.service.AttrGroupService;
import javax.annotation.Resource;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {


    @Resource
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {

        // 前端规定如果传过来的catelogId为0，那么表示没有选中三级分类，则查询所有属性分组
        if (catelogId == 0) {
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    new QueryWrapper<AttrGroupEntity>());
            return new PageUtils(page);
        } else {
            // 前端提交的时候还会提交一个参数名，这个参数名是一个模糊查询，可以匹配任意分组字段，所以需要判断
            String key = (String) params.get("key");

            // select * from pms_attr_group where catelog_id = ? and (attr_group_id = key or attr_group_name = key)
            QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId);
            if (!StringUtils.isEmpty(key)) {
                wrapper.and((obj) -> {
                    obj.eq("attr_group_id", key).or().like("attr_group_name", key);
                });
            }
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
            return new PageUtils(page);
        }
    }

}
