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

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@ComponentScan("org.example.yesdrive")
public class Test {

    private static RestTemplate restTemplate;

    @Resource(name = "restTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        Test.restTemplate = restTemplate;
    }

/*    @Value("${test.url}")
    private static String testUrl;*/

    private final static Gson GSON = new Gson();

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(Test.class, args);
        //这个时候要用依赖查找
        String testUrl = run.getEnvironment().getProperty("test.url");
        System.out.println(testUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        int intValue = Integer.parseInt(args[0]);

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(40);
        executor.initialize();

        AtomicInteger integer = new AtomicInteger();

        Runnable runnable = () -> {
            HttpEntity<String> entity = new HttpEntity<>(randomInfo(), headers);
            assert testUrl != null;
            restTemplate.postForObject(testUrl, entity, String.class);
        };
        long l = System.currentTimeMillis();


        System.out.println("并发: " + intValue + ", 耗时：" + (System.currentTimeMillis() - l));
    }


    public static String randomInfo() {
        return GSON.toJson(new HashMap<String, Object>() {{
            put("directoryName", RandomUtil.getRandomLetterNumber(20));
            put("userId", RandomUtil.getRandomInt(10000));
        }});
    }
}
