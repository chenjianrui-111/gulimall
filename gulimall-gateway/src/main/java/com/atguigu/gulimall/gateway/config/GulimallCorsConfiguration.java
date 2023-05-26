package com.atguigu.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 */
@Configuration
public class GulimallCorsConfiguration {
    @Bean
    public CorsWebFilter corsWebFilter() {
        // 这个是CorsConfigurationSource的一个实现类
        // reactive包下的，因为我们使用的响应式编程
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 新建一个Cors的配置对象，在这个配置对象中指定跨域配置
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1、配置跨域
        corsConfiguration.addAllowedHeader("*"); //允许哪些头进行跨域
        corsConfiguration.addAllowedMethod("*");  // 允许所有请求方式进行跨域
        corsConfiguration.addAllowedOrigin("*"); // 允许任意请求来源 进行跨域
        corsConfiguration.setAllowCredentials(true);  // 允许携带cookie进行跨域

        // /**表示所有路径，我们对所有路径都用corsConfiguration这个跨域配置
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }
}
