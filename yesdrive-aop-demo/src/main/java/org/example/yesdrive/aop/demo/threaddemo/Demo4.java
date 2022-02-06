package org.example.yesdrive.aop.demo.threaddemo;

import org.example.yesdrive.aop.demo.map.Car;

import java.util.Arrays;
import java.util.Objects;

public class Demo4 {

    public static void main(String[] args) {
        Bus bus = new Bus(100,"aa");
        Bus bus1 = new Bus(120,"bb");
        System.out.println(bus.hashCode());
        System.out.println(System.identityHashCode(bus));
        System.out.println(bus==bus1);
        System.out.println(bus.equals(bus1));
        boolean a = false;
        System.out.println();
        bus.gSped();
        Bus car = bus;
        Bus bus2 = car;
        System.out.println(car);
        System.out.println(bus2);
    }

}

class Bus extends Car {

    private int topSpeed;
    private String name;

    public Bus(int topSpeed, String name) {
        super(topSpeed,name);
        this.topSpeed = topSpeed;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public void gSped(){
        int a = super.topSpeed;
        try {
            System.out.println(Bus.class.getDeclaredField("name"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
