package org.example.yesdrive.aop.demo.beandefinition;

import org.example.yesdrive.aop.demo.di.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import java.util.concurrent.TimeUnit;

@SpringBootApplication(scanBasePackages = "org.example.yesdrive.aop.demo.beandefinition")
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationBeanDefinitionDemo.class);
        context.refresh();
        System.out.println("refresh done");
        context.close();*/
        SpringApplication.run(AnnotationBeanDefinitionDemo.class, args);
    }

    /*@Bean
    public User user() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("user done");
            //TimeUnit.SECONDS.sleep(1);
        }
        return new User("aa", 15);
    }

    @Bean
    public User user1() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("user1 done");
            //TimeUnit.SECONDS.sleep(1);
        }
        return new User("bb", 18);
    }*/

}
