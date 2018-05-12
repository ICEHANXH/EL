package Managers;


import android.content.Context;

import com.alibaba.fastjson.JSON;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//任务名，重要性（颜色：四种颜色）
//开始时间，完成时间
//所需交互APP
//单次事项or每周每天
//提醒时间
//备注


//Json解析
public class TaskManager {
    private String tasksPath;
    private List<Task> taskList;
    private MusicManager music_manager;
    private FileManager file_manager;
    private Achievement achievement;

    private TaskManager(Context context) {
        taskList = new LinkedList<>();
        music_manager = MusicManager.getMusicManager();
        file_manager = FileManager.getFileManager();
        achievement = Achievement.getAchievement(context);
        tasksPath = file_manager.getAppPath(context) + "tasks.txt";
    }

    public static TaskManager getTaskManager(Context context) {
        return new TaskManager(context);
    }

    public Task addTask(Task task) {
        try {
            taskList.add(task);
            writeObjFile(taskList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return task;
    }

    public List<Task> getTaskList() {
        try {
            this.taskList = getTasksFormFile();
            return taskList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.taskList;
    }

    private List<Task> flushTask() throws IOException {
        this.taskList = getTasksFormFile();
        return this.taskList;
    }

    private List<Task> getTasksFormFile() throws IOException {
        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream(getBuffFile(), true));
        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream(getBuffFile()));
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes = new byte[1024];
        while ((bufferedInputStream.read(bytes)) != -1) {
            stringBuilder.append(Arrays.toString(bytes));
        }
        String result = stringBuilder.toString();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        return JSON.parseArray(result, Task.class);
    }

    private File getBuffFile() {
        return new File(this.tasksPath);
    }

    private void writeObjFile(List<Task> jsonArray) throws IOException {

        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream(getBuffFile()));
        String output = JSON.toJSONString(jsonArray);
        bufferedOutputStream.write(output.getBytes());
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public void deleteTask(Task task) {

    }

    public void TaskBegin(Task task) {

    }

    public void TaskFinish(Task task) {

    }
}
