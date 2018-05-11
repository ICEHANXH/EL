package Managers;

import android.app.Activity;

import cn.iwgang.countdownview.CountdownView;

public class Achievement {

    private String coin;
    private String accomplishment;

    private Achievement() {
        coin = "";
        accomplishment = "";
    }

    public static Achievement getAchievement() {
        return new Achievement();
    }

    //compile 'com.github.iwgang:countdownview:2.1.6'
    public static class CountingDown {

        public static CountdownView getCountingDown(Activity activity, int R_id) {
            return activity.findViewById(R_id);
        }

        public static CountdownView start(int seconds, CountdownView countdownView) {
            countdownView.start(seconds * 1000);
            return countdownView;
        }

        public static CountdownView start(int minute, int seconds, CountdownView countdownView) {
            return start(minute * 60 + seconds, countdownView);
        }

        public static CountdownView start(int hour, int minute, int second, CountdownView countdownView) {
            return start(hour * 3600 + minute * 60 + second, countdownView);
        }

        public static CountdownView clearToZero(CountdownView countdownView) {
            countdownView.allShowZero();
            return countdownView;
        }

        public static CountdownView pause(CountdownView countdownView) {
            countdownView.pause();
            return countdownView;
        }

        public static CountdownView stop(CountdownView countdownView) {
            countdownView.stop();
            return countdownView;
        }

        public static CountdownView restart(CountdownView countdownView) {
            countdownView.restart();
            return countdownView;
        }
    }
}
