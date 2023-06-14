package com.atguigu.gulimall.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @EnableRedisHttpSession 核心原理
 * 1) @EnableRedisHttpSession导入RedisHttpSessionConfiguration配置
 *     1.给容器中添加了一个组件
 *      SessionRepository ----->>> [RedisOperationsSessionRepository] --->>> Redis操作Session .Session的增删改查
 *     2.SessionRepositoryFilter ===>>> Filter :Session存储过滤器 ：每个请求过来都必须经过 Filter
 *         1.创建的时候就自动从容器中获取得到了 SessionRepository
 *         2.原始的request,response 都被包装。SessionRepositoryRequestWrapper . SessionRepositoryResponseWrapper
 *         3.以后获取 Session . request.getSession();
 *         4.wrappedRequest.getSession(); ====>>> SessionRepository 中获取到
 *
 *     装饰器模式
 *     自动延期：Redis中的数据也有过期时间
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableRedisHttpSession
public class GulimallAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallAuthServerApplication.class, args);
	}

}
