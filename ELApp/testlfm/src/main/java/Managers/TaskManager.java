package Managers;


import com.example.testlfm.Music_lib;

import java.util.Timer;

//任务名，重要性（颜色：四种颜色）
//开始时间，完成时间
//所需交互APP
//单次事项or每周每天
public class TaskManager {
    private Timer timer;
    private String TaskName;
    private AchievementManager achievementManager;
    private Music_lib music_lib;

    private TaskManager() {
        timer = new Timer();
        TaskName = "";
        achievementManager = new AchievementManager();
        music_lib = new Music_lib();
    }

    public static TaskManager getTaskManager() {
        return new TaskManager();
    }


}
