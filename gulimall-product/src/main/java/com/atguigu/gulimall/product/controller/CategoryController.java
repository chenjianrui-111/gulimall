package com.atguigu.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.common.utils.R;



/**
 * 商品三级分类
 *
 * @author cjr
 * @email cjr@gmail.com
 * @date 2023-05-24 19:25:06
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    //@RequiresPermissions("gulimallproduct:category:list")
    public R list(){
        // categoryService的list方法可以查到所有分类
        // 但是我们希望以树形结构获得所有分类
        // List<CategoryEntity> list = categoryService.list();

        // 我们需要一个listWithTree方法来生成分类的树形结构
        List<CategoryEntity> entities = categoryService.listWithTree();
        return R.ok().put("data", entities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 批量修改，前端拖拽菜单后更新菜单信息使用此方法
     * @param category
     * @return
     */
    @RequestMapping("/update/sort")
    //@RequiresPermissions("gulimallproduct:category:update")
    public R updateSort(@RequestBody CategoryEntity[] category){
        // 直接通过逆向工程生成的批量修改方法修改
        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
//		categoryService.updateById(category);
        // 目录品牌级联更新
        categoryService.updateCascade(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){
		//categoryService.removeByIds(Arrays.asList(catIds));
        categoryService.removeMenuByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
