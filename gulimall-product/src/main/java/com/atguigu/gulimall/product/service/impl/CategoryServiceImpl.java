package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.common.utils.Query;
import com.atguigu.gulimall.product.service.CategoryBrandRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    // 因为CategoryServiceImpl继承了ServiceImpl
    // 所以这里可以直接使用ServiceImpl里面的baseMapper
    // baseMapper就是一个CategoryDao的实现，通过泛型实现
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1、查出所有分类
        //List<CategoryEntity> entities = baseMapper.selectList(null);
        List<CategoryEntity> entities = categoryDao.selectList(null);

        // 2、组装成树形父子结构
        // 2.1 找到所有的一级分类
        // 这里用到了java8的新特性Stream API 以及lambda表达式
        // 首先通过对象的.stream()方法获取Stream的实例
        // 然后通过filter过滤器选取流中的元素
        // map接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity -> {
            // 过滤分类级别，保留1级分类
            return categoryEntity.getParentCid() == 0;
        }).map(menu -> {
            // 找到当前分类的子分类
            menu.setChildren(getChildrens(menu, entities));
            return menu;
            // 按sort属性排序
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
            // 最后将处理完的流转为一个list的形式
        }).collect(Collectors.toList());

        return level1Menus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO  1、检查当前删除的菜单是否被别的地方引用

        // 我们一般不使用直接删除的方式，而是使用逻辑删除，即不是删除数据库中的记录，而是不显示，showStatus
        baseMapper.deleteBatchIds(asList);

    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        findParentPath(paths, catelogId);
        return paths.toArray(new Long[0]);
    }

    /**
     * 级联更新所有关联的数据
     * @param category
     */
    @Transactional  // 记得在Mybatis配置类上开启事务
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        if (!StringUtils.isEmpty(category.getName())) {
            categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
        }
    }

    private void findParentPath(List<Long> paths, Long catelogId) {
        CategoryEntity category = this.getById(catelogId);
        if (category.getParentCid() != 0) {  // 这里会触发自动拆箱
            findParentPath(paths, category.getParentCid());
        }
        paths.add(catelogId);
    }

    /**
     * 递归查找所有菜单的子菜单
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            // 找到all里面父菜单是root的元素
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            // 找到all里面父菜单是root的元素的子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            // 按sort属性排序
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

}


