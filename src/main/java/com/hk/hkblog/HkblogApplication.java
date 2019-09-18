package com.hk.hkblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 这个是名为hkblog的webapp应用的启动类
 * @author by 何坤
 * @Classname test
 * @Description TODO
 * @Date 2019/9/16 9:05
 */
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class HkblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(HkblogApplication.class, args);
    }

}
