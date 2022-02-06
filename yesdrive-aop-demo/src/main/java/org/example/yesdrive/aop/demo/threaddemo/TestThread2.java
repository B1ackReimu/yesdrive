package org.example.yesdrive.aop.demo.threaddemo;

import java.util.concurrent.TimeUnit;

public class TestThread2 {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait...");
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("madan");
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " awake...");
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + " get lock...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                o.notify();
                System.out.println(Thread.currentThread().getName() + " notify...");
            }
        }, "t2");
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        t1.join();
    }

}
