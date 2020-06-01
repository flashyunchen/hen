package com.chan.hen;

import com.chan.hen.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.chan.hen")
@MapperScan("com.chan.hen.mapper")
@Import(SpringUtil.class)
public class HenApplication {
    public static void main(String[] args) {
        SpringApplication.run(HenApplication.class,args);
    }
}
