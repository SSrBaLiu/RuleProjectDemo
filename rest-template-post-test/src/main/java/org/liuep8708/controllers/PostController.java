package org.liuep8708.controllers;

import org.liuep8708.DTO.PostDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class PostController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/xxxxu")
    public void postTestSimple()  {
        // 请求地址
        String url = "http://localhost:8707/xmlTest";

        // 要发送的数据对象
        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(110);
        postDTO.setTitle("zimug 发布文章");
        postDTO.setBody("zimug 发布文章 测试内容");

        // 发送post请求，并输出结果
        PostDTO result = restTemplate.postForObject(url, postDTO.toString(), PostDTO.class);
        System.out.println(result);
    }
}
