package org.liuep1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamineAndApproveComplete {
    private String applyType;
    private ArrayList<ApproveInf> approveList;
    private String approveResult;

    @NotNull(message = "请输入blncId")
    private Long blncId;
}
