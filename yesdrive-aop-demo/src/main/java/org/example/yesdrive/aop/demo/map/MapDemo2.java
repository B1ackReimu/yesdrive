package org.example.yesdrive.aop.demo.map;

import java.util.HashMap;

public class MapDemo2 {

    public static void main(String[] args) {
        int a = 6;
        float ft = ((float) a / 0.75F) + 1.0F;
        System.out.println(ft);
        System.out.println((int) ft);
        HashMap<String,String> map = new HashMap<>(4, 0.2F);
    }

}
