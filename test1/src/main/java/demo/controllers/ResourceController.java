package demo.controllers;

import demo.entities.ApproveInf;
import demo.entities.CommonResult;
import demo.entities.ExamineAndApprove;
import demo.entities.ExamineAndApproveComplete;
import demo.services.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ResourceController {

    @Resource
    private DemoService demoService;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getResource")
    public CommonResult<ExamineAndApproveComplete> getResource(){

        //通过restTemplate获取一组随机数据
        ExamineAndApproveComplete examineAndApproveComplete = restTemplate.getForObject("http://localhost:8706/sendMessage",ExamineAndApproveComplete.class);

        //创建一个用以存入数据库的审批信息
        ExamineAndApprove examineAndApprove = new ExamineAndApprove();

        //初步判断是否正确获得blncId，不成功就返回错误信息
        if (examineAndApproveComplete.getBlncId() == null){
            return new CommonResult(444,"未获得正确的blncId，请求失败");
        }

        //把获取的完整审批信息除数组内容(approveInf)的其他部分直接装填到存储用实例
        examineAndApprove.setBlncId(examineAndApproveComplete.getBlncId());
        examineAndApprove.setApplyType(examineAndApproveComplete.getApplyType());
        examineAndApprove.setApproveResult(examineAndApproveComplete.getApproveResult());

        //完整审批信息可能包含多个数组内容(approveInf)，创建一个strBuilder来循环添加信息
        StringBuilder stringBuilder = new StringBuilder();

        //第一个以字符串形式存储uid的approveInf不用在前头添加一个逗号
        if (examineAndApproveComplete.getApproveInfs().size() > 0){
            stringBuilder.append(examineAndApproveComplete.getApproveInfs().get(0).getUid());
            //往数据库中写入uid对应的approveInf
            log.info(""+examineAndApproveComplete.getApproveInfs().get(0));
            saveApproveInf(examineAndApproveComplete.getApproveInfs().get(0));
        }

        //出去第一个approve的索引信息uid，其余的通过英文逗号分隔开
        for (int i = 1; i < examineAndApproveComplete.getApproveInfs().size(); i++) {
            stringBuilder.append(",");
            stringBuilder.append(examineAndApproveComplete.getApproveInfs().get(i).getUid());
            //往数据库中写入uid对应的approveInf
            saveApproveInf(examineAndApproveComplete.getApproveInfs().get(i));
        }

        //把uid的索引串填入存储用实例
        examineAndApprove.setApproveList(stringBuilder.toString());

        //把存储用实例写入数据库
        demoService.saveExamineAndApprove(examineAndApprove);

        //往网页返回一个结果
        return new CommonResult(200,"数据获取成功，已存入数据库",examineAndApproveComplete);
    }


    /**
     * 向数据库中存储 审批建议
     * @param approveInf
     * @return
     */
    private int saveApproveInf(ApproveInf approveInf){
        if (approveInf == null || approveInf.getUid() == null){
            return -1;
        }
        log.info("save :"+approveInf);

        return demoService.saveApproveInf(approveInf);
    }
}
