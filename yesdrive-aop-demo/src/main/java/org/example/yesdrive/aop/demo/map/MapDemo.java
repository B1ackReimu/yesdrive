package org.example.yesdrive.aop.demo.map;

import java.io.Serializable;
import java.util.*;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

public class MapDemo {

    public static void main(String[] args) {
        //int n = Integer.MIN_VALUE;
        //System.out.println(Integer.toBinaryString(n));
        //System.out.println(tableSizeFor(n));
        Car car = new Car(250, "aa");
        car.next = new Car(310, "bb");
        Car car1 = car.next;
        car1.next = car.next;
        Car car2 = new Car(407, "cc");
        car1.next = car2;
        System.out.println(car);
        Box box = boxCar -> {
            car.topSpeed = 336;
            return boxCar.name + " box..";
        };
        box.box(car);
        System.out.println(car);
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
