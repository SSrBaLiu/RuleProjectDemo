package org.liuep.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ExamineAndApprove")
@XmlType(propOrder = {
        "applyType",
        "approveInfXmls",
        "approveResult",
        "blncId"
})
public class ExamineAndApproveCompleteXml {
    private String applyType;
    private ArrayList<ApproveInfXml> approveInfXmls;
    private String approveResult;

    @NotNull(message = "请输入blncId")
    private Long blncId;
}
