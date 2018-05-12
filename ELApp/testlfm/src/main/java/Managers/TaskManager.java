package Managers;


import android.content.Context;

//任务名，重要性（颜色：四种颜色）
//开始时间，完成时间
//所需交互APP
//单次事项or每周每天
//提醒时间
//备注
public class TaskManager {
    private MusicManager music_manager;
    private FileManager file_manager;
    private Achievement achievement;

    private TaskManager(Context context) {
        music_manager = MusicManager.getMusicManager();
        file_manager = FileManager.getFileManager();
        achievement = Achievement.getAchievement(context);
    }

    public static TaskManager getTaskManager(Context context) {
        return new TaskManager(context);
    }

    public boolean addTask(Task task) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteTask(Task task) {

    }

    public void TaskBegin(Task task) {

    }

    public void TaskFinish(Task task) {

    }
}
