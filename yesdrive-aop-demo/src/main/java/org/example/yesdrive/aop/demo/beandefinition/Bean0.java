package org.example.yesdrive.aop.demo.beandefinition;

import org.example.yesdrive.aop.demo.di.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//@Component
public class Bean0 {

    @Bean
    public User user() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("user done");
            TimeUnit.SECONDS.sleep(1);
        }
        return new User("aa",15);
    }

}
