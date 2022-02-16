package org.example.yesdrive.directory.impl.controller;

import org.example.yesdrive.common.advice.annotation.ControllerAdv;
import org.example.yesdrive.common.api.page.Page;
import org.example.yesdrive.common.aspect.annotation.ControllerCut;
import org.example.yesdrive.directory.api.beans.DirectoryInfo;
import org.example.yesdrive.directory.impl.service.DirectoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/directory")
//@ControllerCut
//@ControllerAdv
public class DirectoryController {

    private final DirectoryService directoryService;

    @Autowired
    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    private final ThreadPoolTaskExecutor executor;

    {
        executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(16);
        executor.setMaxPoolSize(16);
        executor.initialize();
    }

    @PostMapping("/create")
    public Mono<Void> create(@RequestBody DirectoryInfo directoryInfo) {
        //System.out.println("creat:"+Thread.currentThread().getName());
        return Mono.fromCallable(() -> directoryService.createDirectory(directoryInfo))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping("/query")
    public void query(@RequestBody DirectoryInfo directoryInfo, BindingResult bindingResult) {
        System.out.println(directoryInfo.getQueryCondition());
    }

}
