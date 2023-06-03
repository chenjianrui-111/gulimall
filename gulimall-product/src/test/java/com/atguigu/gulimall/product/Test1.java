package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest(classes = GulimallProductApplication.class)
@Slf4j
@RunWith(SpringRunner.class)
public class Test1 {

    @Autowired
    CategoryService categoryService;

    @Test
    public void testFindPath(){
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        log.info("完整路径:{},", Arrays.asList(catelogPath));
    }
}
