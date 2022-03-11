package org.liuep.controllers;

//import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.liuep.DTO.PostDTO;
import org.liuep.entities.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@RestController
@Slf4j
public class ResourceController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/sendMessage")
    public ExamineAndApproveComplete sendMessage(){
        ExamineAndApproveComplete examineAndApproveComplete = createExamineAndApproveComplete();
        return examineAndApproveComplete;
    }

    @RequestMapping("/sendMessageXml")
    public ExamineAndApproveCompleteXml sendMessageXml(){
        ExamineAndApproveCompleteXml examineAndApproveCompleteXml = createExamineAndApproveCompleteXml();
        log.info("******xml: "+examineAndApproveCompleteXml);
        PostDTO<ExamineAndApproveCompleteXml> postDTO = new PostDTO(1,examineAndApproveCompleteXml);
        TestEntity entity = new TestEntity(0);
        restTemplate.postForObject("http://localhost:8707/xmlTest",postDTO, CommonResult.class);
        return examineAndApproveCompleteXml;
    }

    private ExamineAndApproveCompleteXml createExamineAndApproveCompleteXml(){
        ExamineAndApproveCompleteXml examineAndApproveCompleteXml = new ExamineAndApproveCompleteXml();
        examineAndApproveCompleteXml.setApplyType("A");
        examineAndApproveCompleteXml.setApproveResult("0");

        Random random = new Random();
        Long numForBlncId = random.nextLong()%10000000;
        if (numForBlncId < 0){
            numForBlncId += 10000000;
        }
        examineAndApproveCompleteXml.setBlncId(numForBlncId);

        int numForUid = random.nextInt()%10000;
        if (numForUid < 0){
            numForUid += 10000;
        }
        String uid = "asia"+numForUid;

        ArrayList<ApproveInfXml> approveInfXmls = createApproveInfXmls(uid);

        examineAndApproveCompleteXml.setApproveInfXmls(approveInfXmls);
        return examineAndApproveCompleteXml;
    }

    private ExamineAndApproveComplete createExamineAndApproveComplete(){
        ExamineAndApproveComplete examineAndApproveComplete = new ExamineAndApproveComplete();
        examineAndApproveComplete.setApplyType("A");
        examineAndApproveComplete.setApproveResult("0");

        Random random = new Random();
        Long numForBlncId = random.nextLong()%10000000;
        if (numForBlncId < 0){
            numForBlncId += 10000000;
        }
        examineAndApproveComplete.setBlncId(numForBlncId);

        int numForUid = random.nextInt()%10000;
        if (numForUid < 0){
            numForUid += 10000;
        }
        String uid = "asia"+numForUid;

        ArrayList<ApproveInf> approveInfs = createApproveInfs(uid);

        examineAndApproveComplete.setApproveInfs(approveInfs);
        return examineAndApproveComplete;
    }

    private ArrayList<ApproveInf> createApproveInfs(String uid){
        ArrayList<ApproveInf> approveInfs = new ArrayList<ApproveInf>();

        ApproveInf approveInf = new ApproveInf();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);

        approveInf.setUid(uid);
        approveInf.setActivityLabel("123");
        approveInf.setActivityName("测试");
        approveInf.setExecutor("测试");
        approveInf.setExecutorName("测试");
        approveInf.setActivityName("测试");
        approveInf.setFinished(dateString);
        approveInf.setId(12);
        approveInf.setOpinion("测试");
        approveInf.setParentId(123);
        approveInf.setPid(123);
        approveInf.setStatus(1);
        approveInf.setStatusName("测试");
        approveInf.setUid(uid);

        approveInfs.add(approveInf);

        return approveInfs;
    }

    private ArrayList<ApproveInfXml> createApproveInfXmls(String uid){
        ArrayList<ApproveInfXml> approveInfXmls = new ArrayList<ApproveInfXml>();

        ApproveInfXml approveInfXml = new ApproveInfXml();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);

        approveInfXml.setUid(uid);
        approveInfXml.setActivityLabel("123");
        approveInfXml.setActivityName("测试");
        approveInfXml.setExecutor("测试");
        approveInfXml.setExecutorName("测试");
        approveInfXml.setActivityName("测试");
        approveInfXml.setFinished(dateString);
        approveInfXml.setId(12);
        approveInfXml.setOpinion("测试");
        approveInfXml.setParentId(123);
        approveInfXml.setPid(123);
        approveInfXml.setStatus(1);
        approveInfXml.setStatusName("测试");
        approveInfXml.setUid(uid);

        approveInfXmls.add(approveInfXml);

        return approveInfXmls;
    }
}
