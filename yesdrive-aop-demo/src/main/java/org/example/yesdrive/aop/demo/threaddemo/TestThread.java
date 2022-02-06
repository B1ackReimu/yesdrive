package org.example.yesdrive.aop.demo.threaddemo;

import org.example.yesdrive.aop.demo.map.Car;

import java.util.concurrent.TimeUnit;

public class TestThread {

    public static void main(String[] args) {
        Object o = new Object();
        Car car = new Car(15, "aa");
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "抢到了锁");
                try {
                    o.wait(1);
                    System.out.println(Thread.currentThread().getName() + "被唤醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " yield");
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "抢到了锁");
                try {
                    o.notify();
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " yield");
            }
        }, "t2");
        t2.start();
        Thread t3 = new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "抢到了锁");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " yield");
            }
        }, "t3");
        t3.start();
    }


}
