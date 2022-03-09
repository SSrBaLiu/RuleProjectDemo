package demo.Impl;

import demo.DAO.DemoDAO;
import demo.entities.ApproveInf;
import demo.entities.ExamineAndApprove;
import demo.services.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoDAO demoDAO;

    @Override
    public int saveApproveInf(ApproveInf approveInf) {
        return demoDAO.saveApproveInf(approveInf);
    }

    @Override
    public int saveExamineAndApprove(ExamineAndApprove examineAndApprove) {
        return demoDAO.saveExamineAndApprove(examineAndApprove);
    }

    @Override
    public ApproveInf getApproveInf(String uid) {
        return demoDAO.getApproveInf(uid);
    }

    @Override
    public ExamineAndApprove getExamineAndApprove(Long blncId) {
        return demoDAO.getExamineAndApprove(blncId);
    }
}
