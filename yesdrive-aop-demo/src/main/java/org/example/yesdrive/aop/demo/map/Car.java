package org.example.yesdrive.aop.demo.map;

import java.util.Comparator;

public class Car implements Comparable<Car> {

    public int topSpeed;
    public String name;
    public Car next;

    public Car(int topSpeed, String name) {
        this.topSpeed = topSpeed;
        this.name = name;
    }

    @Override
    public int compareTo(Car o) {
        return this.topSpeed - o.topSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "topSpeed=" + topSpeed +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
    public void wait1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "调用了wait");
        super.wait();
    }
}
