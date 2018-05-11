package Managers;

public class LogManager {

    private LogManager() {

    }

    public static LogManager getLogManager() {
        return new LogManager();
    }
}
