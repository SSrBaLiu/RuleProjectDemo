package demo.DAO;


import demo.entities.ApproveInf;
import demo.entities.ExamineAndApprove;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoDAO {
    public int saveApproveInf(ApproveInf approveInf);
    public int saveExamineAndApprove(ExamineAndApprove examineAndApprove);
    public ApproveInf getApproveInf(@Param("uid") String uid);
    public ExamineAndApprove getExamineAndApprove(@Param("blncId") Long blncId);
}
