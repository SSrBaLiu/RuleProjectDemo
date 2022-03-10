package org.liuep.controllers;

//import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.liuep.entities.ApproveInf;
import org.liuep.entities.ExamineAndApproveComplete;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@RestController
@Slf4j
public class ResourceController {

    @GetMapping("/sendMessage")
    public ExamineAndApproveComplete sendMessage(){

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
}
