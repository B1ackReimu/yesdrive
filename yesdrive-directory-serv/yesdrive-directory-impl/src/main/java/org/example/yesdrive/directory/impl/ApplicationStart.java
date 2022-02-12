package org.example.yesdrive.directory.impl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("org.example.yesdrive")
@MapperScan("org.example.yesdrive.directory.dao")
@EnableAspectJAutoProxy
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class,args);
    }
}
