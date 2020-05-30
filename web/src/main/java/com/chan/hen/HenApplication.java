package com.chan.hen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.chan.hen")
@MapperScan("com.chan.hen.mapper")
public class HenApplication {
    public static void main(String[] args) {
        SpringApplication.run(HenApplication.class,args);
    }
}
