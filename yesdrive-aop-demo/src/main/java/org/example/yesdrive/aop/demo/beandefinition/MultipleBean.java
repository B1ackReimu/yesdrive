package org.example.yesdrive.aop.demo.beandefinition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

//@Component
public class MultipleBean {

    @PostConstruct
    public void method1() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("1111111111");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @PostConstruct
    public void method2() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("2222222222");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @PostConstruct
    public void method3() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("333333333");
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
