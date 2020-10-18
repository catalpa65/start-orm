package com.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sys.dao")//扫描接口层
public class StartOrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartOrmApplication.class, args);
    }

}
