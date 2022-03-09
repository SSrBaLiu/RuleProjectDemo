package demo.services;

import demo.entities.ApproveInf;
import demo.entities.ExamineAndApprove;
import org.apache.ibatis.annotations.Param;

public interface DemoService {
    public int saveApproveInf(ApproveInf approveInf);
    public int saveExamineAndApprove(ExamineAndApprove examineAndApprove);
    public ApproveInf getApproveInf(@Param("uid") String uid);
    public ExamineAndApprove getExamineAndApprove(@Param("blncId") Long blncId);
}
