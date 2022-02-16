package org.example.yesdrive.test.directory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Configuration
public class WebClientConfig {

    @Value("${test.url}")
    private String testUrl;

    @Value("${webclient.max-conn}")
    private int maxConn;

    @Value("${webclient.pen-count}")
    private int penCount;


    @Bean
    public WebClient webClient() {
        ConnectionProvider connectionProvider = ConnectionProvider.builder("myConnectionPool")
                .maxConnections(maxConn)
                .pendingAcquireMaxCount(penCount)
                .build();
        ReactorClientHttpConnector connector = new ReactorClientHttpConnector(HttpClient.create(connectionProvider));
        return WebClient.builder().baseUrl(testUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(connector).build();
    }

}
