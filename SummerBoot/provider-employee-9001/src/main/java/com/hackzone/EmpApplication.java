package com.hackzone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author maxwell
 * EnableDiscoveryClient # 启用发现服务
 * EnableEurekaClient # 服务入驻
 */
@MapperScan(value = "com.lake.dao.mapper")
@SpringBootApplication(exclude = {RedisAutoConfiguration.class, RabbitAutoConfiguration.class})
@EnableEurekaClient
@EnableDiscoveryClient
@EntityScan(value = "com.com.hackzone.entity")
public class EmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpApplication.class, args);
    }
}
