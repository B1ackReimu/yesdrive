package org.example.yesdrive.aop.demo.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Demo.class);
        context.refresh();
        lookD(context);
    }

    @Bean
    public User user(){
        return new User("zs",15);
    }

    public static void lookD(BeanFactory factory){
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) factory;
        Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
        System.out.println(beans);
    }

}


