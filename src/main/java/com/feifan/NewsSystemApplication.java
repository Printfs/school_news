package com.feifan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.feifan.Dao")
public class NewsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsSystemApplication.class, args);
    }

}
