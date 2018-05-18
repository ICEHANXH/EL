package Managers;
//5.14 一期时间模块实现

import android.content.Context;

import java.time.LocalDateTime;
import java.util.Calendar;

public class TimeManager {
    private CountingDown countingDown;

    private TimeManager(Context context) {
        countingDown = CountingDown.getCountingDown(context);
    }

    public static TimeManager getTimeManager(Context context) {
        return new TimeManager(context);

    }


    public String getTimeStick(Calendar begin, Calendar end) {
        return String.valueOf(end.getTimeInMillis() - begin.getTimeInMillis());
    }

    public String getYear() {
        return String.valueOf(LocalDateTime.now().getYear());
    }

    public String getDayOfYear() {
        return String.valueOf(LocalDateTime.now().getDayOfYear());
    }

    public String getMonthValue() {
        return String.valueOf(LocalDateTime.now().getMonthValue());
    }

    public String getMonth() {
        return String.valueOf(LocalDateTime.now().getMonth());
    }

    public String getDayOfMonth() {
        return String.valueOf(LocalDateTime.now().getDayOfMonth());
    }

    public String getDayOfWeek() {
        return String.valueOf(LocalDateTime.now().getDayOfWeek());

    }

    public String getHour() {
        return String.valueOf(LocalDateTime.now().getHour());
    }

    public String getMinute() {
        return String.valueOf(LocalDateTime.now().getMinute());
    }

    public String getSecond() {
        return String.valueOf(LocalDateTime.now().getSecond());
    }
}
