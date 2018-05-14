package Managers;

//设置闹钟
public class ClockManager {
    private TimeManager timeManager;

    private ClockManager() {
        timeManager = TimeManager.getTimeManager();
    }
    public void run(){
    }

}
