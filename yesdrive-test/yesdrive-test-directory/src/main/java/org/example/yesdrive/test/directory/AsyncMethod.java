package org.example.yesdrive.test.directory;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class AsyncMethod {

    public static void main(String[] args) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(40);
        executor.initialize();

        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            executor.execute(runnable);
        }
        executor.shutdown();
    }

}
