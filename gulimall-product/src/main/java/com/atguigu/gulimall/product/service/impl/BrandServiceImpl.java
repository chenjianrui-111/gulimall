package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.common.utils.Query;
import com.atguigu.gulimall.product.service.CategoryBrandRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.gulimall.product.dao.BrandDao;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        //1 获取key 当我们使用模糊查询时，前端发送的请求会带一个key的字段
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {  // 当key不是空串，则代表需要进行模糊匹配
            // select * from pms_brand where brand_id = key or name = key
            wrapper.eq("brand_id", key).or().like("name", key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

    @Transactional  // 记得在Mybatis配置类上开启事务
    @Override
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);
        // 保证冗余字段的数据一致
        if (!StringUtils.isEmpty(brand.getName())) {
            // 同步更新其他关联表中的数据(冗余存储)
            categoryBrandRelationService.updateBrand(brand.getBrandId(), brand.getName());

            //TODO 更新其他关联
        }
    }

    @Override
    public List<BrandEntity> getBrandsByIds(List<Long> brandIds) {

        return baseMapper.selectList(new QueryWrapper<BrandEntity>().in("brand_id",brandIds));
    }

}
