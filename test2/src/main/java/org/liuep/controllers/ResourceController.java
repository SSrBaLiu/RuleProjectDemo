package org.liuep.controllers;

import lombok.extern.slf4j.Slf4j;
import org.liuep.entities.ExamineAndApproveComplete;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ResourceController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/sendMessage")
    public ExamineAndApproveComplete sendMessage(){

        return null;
    }
}
