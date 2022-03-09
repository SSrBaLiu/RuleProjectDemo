package demo.controllers;

import demo.entities.ApproveInf;
import demo.entities.CommonResult;
import demo.entities.ExamineAndApprove;
import demo.entities.ExamineAndApproveComplete;
import demo.services.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@Slf4j
public class DemoController {
    @Resource
    private DemoService demoService;

    @RequestMapping("/test")
    public String test(){
        return "测试成功";
    }

    @GetMapping("/approveinf/get/{uid}")
    public CommonResult getApproveInf(@PathVariable("uid") String uid){

        ApproveInf approveInf = demoService.getApproveInf(uid);

        if(approveInf != null){
            return new CommonResult(200,"成功获得审批建议",approveInf);
        } else {
          return new CommonResult(444,"uid: " + uid + "对应的审批建议不存在!");
        }
    }

    @GetMapping("/examine/get/{blncId}")
    public CommonResult getExamineAndApprove(@PathVariable("blncId")  Long blncId){


        ExamineAndApprove examineAndApprove = demoService.getExamineAndApprove(blncId);
        ExamineAndApproveComplete examineAndApproveComplete = null;

        if(examineAndApprove != null){
            if (examineAndApprove.getApproveList() != null){
                examineAndApproveComplete = new ExamineAndApproveComplete();
                ArrayList<ApproveInf> approveInfs = new ArrayList<ApproveInf>();
                String[] approveList = examineAndApprove.getApproveList().split(",");
                log.info("after split: " + approveList.length);
                for (int i = 0;i < approveList.length;i++){
                    approveInfs.add(demoService.getApproveInf(approveList[i]));
                }
                examineAndApproveComplete.setApproveInfs(approveInfs);
                examineAndApproveComplete.setApplyType(examineAndApprove.getApplyType());
                examineAndApproveComplete.setApproveResult(examineAndApprove.getApproveResult());
                examineAndApproveComplete.setBlncId(examineAndApprove.getBlncId());
            }
            return new CommonResult(200,"成功获得审批信息",examineAndApproveComplete);
        } else {
            return new CommonResult(444,"blncId: " + blncId + "对应的审批信息不存在");
        }
    }

    @PostMapping("examine/save")
    public CommonResult saveExamineAndApprove(@Valid ExamineAndApprove examineAndApprove, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new CommonResult(448,bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        log.info("examineAndApprove = " + examineAndApprove);
        int result = demoService.saveExamineAndApprove(examineAndApprove);

        if (result>0){
            return new CommonResult(200,"审批信息存储成功",result);
        } else {
            return new CommonResult(444,"审批信息存储失败");
        }
    }

    @PostMapping("/approveinf/save")
    public CommonResult saveApproveInf(@Valid ApproveInf approveInf, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new CommonResult(448,bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        int result = demoService.saveApproveInf(approveInf);

        if (result>0){
            return new CommonResult(200,"审批建议存储成功",result);
        } else {
            return new CommonResult(444,"审批建议存储失败");
        }
    }
}
