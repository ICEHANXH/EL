package Managers;


import android.app.Activity;

import cn.iwgang.countdownview.CountdownView;

//compile 'com.github.iwgang:countdownview:2.1.6'
public class CountingDown {

    private CountingDown() {

    }

    public static CountingDown getCountingDown() {
        return new CountingDown();
    }

    public CountdownView getCountingView(Activity activity, int R_id) {
        return activity.findViewById(R_id);
    }

    public CountdownView start(int seconds, CountdownView countdownView) {
        countdownView.start(seconds * 1000);
        return countdownView;
    }

    public CountdownView start(int minute, int seconds, CountdownView countdownView) {
        return start(minute * 60 + seconds, countdownView);
    }

    public CountdownView start(int hour, int minute, int second, CountdownView countdownView) {
        return start(hour * 3600 + minute * 60 + second, countdownView);
    }

    public CountdownView clearToZero(CountdownView countdownView) {
        countdownView.allShowZero();
        return countdownView;
    }

    public CountdownView pause(CountdownView countdownView) {
        countdownView.pause();
        return countdownView;
    }

    public CountdownView stop(CountdownView countdownView) {
        countdownView.stop();
        return countdownView;
    }

    public CountdownView restart(CountdownView countdownView) {
        countdownView.restart();
        return countdownView;
    }
}