package org.example.yesdrive.directory.impl.controller;

import org.example.yesdrive.common.annotation.ControllerCut;
import org.example.yesdrive.directory.api.beans.DirectoryInfo;
import org.example.yesdrive.directory.impl.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directory")
@ControllerCut
public class DirectoryController {

    private final DirectoryService directoryService;

    @Autowired
    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @PostMapping("/create")
    public void create(@RequestBody DirectoryInfo directoryInfo){
        directoryService.createDirectory(directoryInfo);
    }

}
