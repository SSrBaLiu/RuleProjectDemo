package demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamineAndApprove {
    private String applyType;
    private String approveList;
    private String approveResult;

    @NotNull(message = "请输入blncId")
    private Long blncId;
}
