package Managers;

import java.util.Timer;

/*
*
* //任务名，重要性（颜色：四种颜色）
//开始时间，完成时间
//所需交互APP
//单次事项or每周每天
//提醒时间
//备注
* */
public class Tasks {
    private Timer timer;
    private String TaskName;
    private String Remarks;
    private String Importance;

    private Tasks() {
        timer = new Timer();
        TaskName = "";
        Remarks = "";
        Importance = "";
    }

    public static Tasks getTask() {
        return new Tasks();
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getImportance() {
        return Importance;
    }

    public void setImportance(String importance) {
        Importance = importance;
    }
}
