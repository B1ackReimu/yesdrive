package org.example.yesdrive.aop.demo.threaddemo;

import java.util.concurrent.TimeUnit;

public class TestThread3 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (; ; ) {
            System.out.println(myThread.isFlag());
            if (myThread.isFlag()) {
                System.out.println(myThread.isFlag());
                break;
            }
        }
    }

}

class MyThread extends Thread implements Runnable {

    private boolean flag;

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(Thread.currentThread().getName() + ":" + flag);
    }

    public boolean isFlag() {
        return flag;
    }
}