package org.example.yesdrive.test.directory;

import com.google.gson.Gson;
import org.example.yesdrive.test.util.RandomUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@ComponentScan("org.example.yesdrive")
public class Test {

    private static RestTemplate restTemplate;

    @Resource(name = "restTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        Test.restTemplate = restTemplate;
    }

    private static WebClient webClient;

    @Resource
    public void setWebClient(WebClient webClient) {
        Test.webClient = webClient;
    }

    private final static Gson GSON = new Gson();

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(Test.class, args);
        //这个时候要用依赖查找
        String testUrl = run.getEnvironment().getProperty("test.url");
        System.out.println(testUrl);
        int coreSize = Integer.parseInt(Objects.requireNonNull(run.getEnvironment().getProperty("test.core-size")));
        int maxSize = Integer.parseInt(Objects.requireNonNull(run.getEnvironment().getProperty("test.max-size")));
        System.out.println("coreSize:" + coreSize);
        System.out.println("maxSize:" + maxSize);
        int totalRequests = Integer.parseInt(args[0]);

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(coreSize);
        executor.setMaxPoolSize(maxSize);
        executor.initialize();

        AtomicInteger integer = new AtomicInteger();
        AtomicInteger everySecond = new AtomicInteger();

        CopyOnWriteArrayList<Long> arrayList = new CopyOnWriteArrayList<>();

        long ll = System.currentTimeMillis();

        Runnable runnable = () -> {
            long start = System.currentTimeMillis();
            try {
                //HttpEntity<String> entity = new HttpEntity<>(randomInfo(), headers);
                //assert testUrl != null;
                //restTemplate.postForObject(testUrl, entity, String.class);
                webClient.post().body(Mono.just(randomInfo()), String.class).retrieve()
                        .bodyToMono(String.class).block();
            } finally {
                integer.incrementAndGet();
                arrayList.add(System.currentTimeMillis() - start);
                if (System.currentTimeMillis() - ll <= 1000) {
                    everySecond.incrementAndGet();
                }
            }
        };

        long l = System.currentTimeMillis();
        for (int i = 0; i < totalRequests; i++) {
            executor.execute(runnable);
        }
        System.out.println("executor.execute耗时：" + (System.currentTimeMillis() - l));
        while (integer.get() != totalRequests) {
            TimeUnit.MICROSECONDS.sleep(1);
        }
        System.out.println("并发: " + totalRequests + ", 耗时：" + (System.currentTimeMillis() - l));
        System.out.println("List长度：" + arrayList.size());
        System.out.println("最差值：" + arrayList.stream().max(Long::compareTo).orElse(0L));
        System.out.println("最好值：" + arrayList.stream().min(Long::compareTo).orElse(0L));
        System.out.println("1S内发起的数量：" + everySecond.get());
        executor.shutdown();
        run.close();
    }


    public static String randomInfo() {
        return GSON.toJson(new HashMap<String, Object>() {{
            put("directoryName", RandomUtil.getRandomLetterNumber(20));
            put("userId", RandomUtil.getRandomInt(10000));
        }});
    }
}
