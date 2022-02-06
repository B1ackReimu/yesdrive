package org.example.yesdrive.aop.demo.beandefinition;

import org.example.yesdrive.aop.demo.di.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class Bean1 {

    @Bean
    public User user1() {
        for (int i = 0; i < 100; i++) {
            System.out.println("user1 done");
            //TimeUnit.SECONDS.sleep(1);
        }
        return new User("aa",15);
    }

}
