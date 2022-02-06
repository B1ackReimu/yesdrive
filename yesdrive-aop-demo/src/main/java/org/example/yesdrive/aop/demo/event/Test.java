package org.example.yesdrive.aop.demo.event;

import java.util.Objects;

public class Test {

    public static void main(String[] args) {
        User user = new User();
    }

}

class User {
    private String name = "adsa";

    public User() {
        if (Objects.nonNull(name)){
            System.out.println(name);
        }
    }
}