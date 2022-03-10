package org.liuep1.controllers;


import lombok.extern.slf4j.Slf4j;
import org.liuep1.entities.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
@Slf4j
public class ListenController {

    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = "/listenTest1",produces = "text/xml;charset=UTF-8")
    public CommonResult listenTest1(HttpServletRequest request){
        StringBuffer reqXmlData = new StringBuffer();

        try {
            InputStream inputStream = request.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            while((str = bufferedReader.readLine()) != null){
                reqXmlData.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (Exception e){
            log.info(e.toString());
        }

        if (reqXmlData.length() <= 0){
            return new CommonResult(444,"请求数据为空");
        }

        Object object = null;

        if ("<".equals(reqXmlData.charAt(0)) ){
            //TODO xml转对象
        } else {
            //TODO json转对象
        }

        return new CommonResult(200,"获得对象",object);
    }
}
