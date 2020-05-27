package com.chan.hen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.chan.hen")
@EnableSwagger2
public class HenApplication {
    public static void main(String[] args) {
        SpringApplication.run(HenApplication.class,args);
    }
}
