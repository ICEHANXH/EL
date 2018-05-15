package Managers;

import android.content.Context;

public class LogManager {
    private TaskManager taskManager;

    private LogManager(Context context) {
        taskManager = TaskManager.getTaskManager(context);
    }

    private LogManager() {

    }

    public static LogManager getLogManager(Context context) {
        return new LogManager(context);
    }

}
