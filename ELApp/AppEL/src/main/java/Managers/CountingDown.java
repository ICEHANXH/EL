package Managers;


import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import cn.iwgang.countdownview.CountdownView;

//compile 'com.github.iwgang:countdownview:2.1.6'
public class CountingDown {
    private Handler handler;

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


//多线程进行正计时的模板
//handler处理交互信息，message的arg1属性为正计时的时间，必须要获取String.valueOf才可以用（本身是int型）
class CountingUp implements Runnable {
    private long count = 0;
    private boolean ifStop = true;
    private Handler handler;
    Message msg;

    public CountingUp(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        count = 0;
        while (ifStop) {
            count++;
            msg = new Message();
            msg.arg1 = Math.toIntExact(count);
            handler.sendMessage(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


//代码模板
/*
* Handler handler = new Handler() {
            //重写handleMessage方法获得子线程传来的数据
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                text.setText(String.valueOf(msg.arg1));
            }
        };
        new Thread(() -> {
            count = 0;
            while (ifStop) {
                count++;
                Message msg = new Message();
                msg.arg1 = Math.toIntExact(count);
                handler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
* */