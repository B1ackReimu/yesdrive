package org.example.yesdrive.test.directory;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AsyncMethod {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(40);
        executor.initialize();

        AtomicInteger atomicInteger1 = new AtomicInteger();
        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                atomicInteger1.incrementAndGet();
            }
        };

        for (int i = 0; i < 20; i++) {
            executor.execute(runnable);
        }
        while (atomicInteger1.get() < 20) {
            TimeUnit.NANOSECONDS.sleep(1);
        }
        executor.shutdown();
    }

}
