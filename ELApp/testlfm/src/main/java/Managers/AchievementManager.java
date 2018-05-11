package Managers;

import android.content.Context;

public class AchievementManager {
    private String AchievementFilePath;
    private FileManager file_manager;
    private Achievement achievement;

    private AchievementManager(Context context) {
        achievement = Achievement.getAchievement(context);
        file_manager = FileManager.getFileManager();
    }

    public static AchievementManager getAchievementManager(Context context) {
        return new AchievementManager(context);
    }

}
