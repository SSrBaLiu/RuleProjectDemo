package org.liuep.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ApproveInf")
@XmlType(propOrder = {
        "activityLabel",
        "activityName",
        "executor",
        "executorName",
        "finished",
        "id",
        "opinion",
        "parentId",
        "pid",
        "status",
        "statusName",
        "uid"
})
public class ApproveInfXml {
    private String activityLabel;
    private String activityName;
    private String executor;
    private String executorName;
    private String finished;
    private int id;
    private String opinion;
    private int parentId;
    private int pid;
    private int status;
    private String statusName;

    @NotNull(message = "请输入uid")
    private String uid;
}
