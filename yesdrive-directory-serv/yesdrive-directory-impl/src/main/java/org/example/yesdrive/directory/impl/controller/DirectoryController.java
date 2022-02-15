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
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @PostMapping("/create")
    public void create(@RequestBody DirectoryInfo directoryInfo) {
        System.out.println(directoryInfo.getUserId()+":"+Thread.currentThread().getName());
        System.out.println(directoryInfo.getUserId()+":"+Thread.currentThread().getName());
        directoryService.createDirectory(directoryInfo);
        System.out.println(directoryInfo.getUserId()+":"+Thread.currentThread().getName());
        System.out.println(directoryInfo.getUserId()+":"+Thread.currentThread().getName());
    }

    @PostMapping("/query")
    public void query(@RequestBody DirectoryInfo directoryInfo, BindingResult bindingResult) {
        System.out.println(directoryInfo.getQueryCondition());
    }

}
