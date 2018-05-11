package Managers;

public class TimeManager {
    private CountingDown countingDown;

    private TimeManager() {
        countingDown = countingDown.getCountingDown();
    }

    public static TimeManager getTimeManager() {
        return new TimeManager();
    }
}
