package org.example.yesdrive.test.directory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@ComponentScan(basePackages = "org.example.yesdrive.test")
public class Test {

    private static RestTemplate restTemplate;

    @Resource(name = "restTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        Test.restTemplate = restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(Test.class,args);
        System.out.println(restTemplate);
    }
}
