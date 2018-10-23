package com.core;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author smallTao.liu
 * @description
 * @date 2018/6/13 16:00
 * @vrsion V1.0
 */
//@EnableEurekaClient
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//指定扫描mapper目录
@MapperScan(basePackages = "com.core.dao.mapper")
//开启定时任务
@EnableScheduling
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
