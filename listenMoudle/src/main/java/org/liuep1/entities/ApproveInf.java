package org.liuep1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApproveInf implements Serializable {
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
