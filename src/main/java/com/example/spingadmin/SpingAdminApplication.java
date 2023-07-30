package com.example.spingadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan
@SpringBootApplication
public class SpingAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpingAdminApplication.class, args);
    }
}
