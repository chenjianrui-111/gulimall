package com.atguigu.gulimall.thirdpart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class GulimallThirdPartApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallThirdPartApplication.class,args);
    }
}
