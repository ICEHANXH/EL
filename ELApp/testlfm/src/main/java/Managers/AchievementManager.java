package Managers;

public class AchievementManager {
    private String AchievementFilePath;
    private FileManager file_manager;


    private AchievementManager() {
        file_manager = new FileManager();
    }

    public static AchievementManager getAchievementManager() {
        return new AchievementManager();
    }
}
