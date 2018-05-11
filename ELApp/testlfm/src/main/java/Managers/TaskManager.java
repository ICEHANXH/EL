package Managers;


import android.content.Context;

//任务名，重要性（颜色：四种颜色）
//开始时间，完成时间
//所需交互APP
//单次事项or每周每天
//提醒时间
//备注
public class TaskManager {
    private AchievementManager achievementManager;
    private MusicManager music_manager;
    private FileManager file_manager;

    private TaskManager(Context context) {
        achievementManager = AchievementManager.getAchievementManager(context);
        music_manager = MusicManager.getMusicManager();
        file_manager = FileManager.getFileManager();
    }

    public static TaskManager getTaskManager(Context context) {
        return new TaskManager(context);
    }

    public boolean addTask(Tasks tasks) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteTask(Tasks tasks) {

    }

    public void TaskBegin(Tasks tasks) {

    }

    public void TaskEnd(Tasks tasks) {

    }
}
