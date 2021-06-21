package com.example.springboot6_17;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xqr
 */
@SpringBootApplication
@MapperScan("com.example.springboot6_17.mapper")
public class Springboot617Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot617Application.class, args);
    }

}
