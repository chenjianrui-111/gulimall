package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = GulimallProductApplication.class)
@Slf4j
@RunWith(SpringRunner.class)
public class GulimallProductApplicationTests {

	@Autowired
	BrandService brandService;
	@Test
	public void contextLoads() {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setName("huawei");
		brandService.save(brandEntity);
		System.out.println("Successfully saved");
	}

}
