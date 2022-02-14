package org.example.yesdrive.test.directory;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AsyncMethod {

    public void main(String[] args) throws InterruptedException {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(6);
        executor.setMaxPoolSize(6);
        executor.initialize();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        AtomicInteger atomicInteger1 = new AtomicInteger();
        Runnable runnable = () -> {
            HttpEntity<String> entity = new HttpEntity<>(Test.randomInfo(), headers);
            atomicInteger1.incrementAndGet();
        };

        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executor.execute(runnable);
        }

        while (atomicInteger1.get() < 10000) {
            TimeUnit.MICROSECONDS.sleep(1);
        }
        System.out.println(System.currentTimeMillis() - l);
        executor.shutdown();
    }

}
