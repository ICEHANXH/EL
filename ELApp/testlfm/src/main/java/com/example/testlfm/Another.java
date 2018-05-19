package com.example.testlfm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import BackManagers.WinStrategy;
import Managers.ClockManager;
import Managers.Task;

public class Another extends AppCompatActivity implements View.OnClickListener {

    private Button btn_set;
    private Button btn_cancel;
    private AlarmManager alarmManager;
    private PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        bindViews();
    }

    private void bindViews() {
        btn_set = findViewById(R.id.btn_set);
        btn_cancel = findViewById(R.id.btn_cancel);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(this, myReceiver.class);
        pi = PendingIntent.getBroadcast(this, 0, intent, 0);

        btn_set.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        WinStrategy winStrategy = WinStrategy.getWinStrategy(this);
        winStrategy.setMaxDelay(3);
        winStrategy.setMusicPathList(this, ".m4a", "kgmusic");
        winStrategy.WinStrategyOn(this, Task.getTask());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_set:
//                Calendar currentTime = Calendar.getInstance();
//                new TimePickerDialog(this, 0,
//                        (view, hourOfDay, minute) -> {
//                            //设置当前时间
//                            Calendar c = Calendar.getInstance();
//                            c.setTimeInMillis(System.currentTimeMillis());
//                            // 根据用户选择的时间来设置Calendar对象
//                            c.set(Calendar.HOUR, hourOfDay);
//                            c.set(Calendar.MINUTE, minute);
//                            // ②设置AlarmManager在Calendar对应的时间启动Activity
//                            alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),
//                                    pi);
//                            Log.e("HEHE", c.getTimeInMillis() + "");   //这里的时间是一个unix时间戳
//                            // 提示闹钟设置完毕:
//                            Toast.makeText(this, "闹钟设置完毕~" + c.getTimeInMillis(),
//                                    Toast.LENGTH_SHORT).show();
//                        }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
//                        .get(Calendar.MINUTE), false).show();
//                btn_cancel.setVisibility(View.VISIBLE);
//                break;
//                TimeManager timeManager = TimeManager.getTimeManager();
//                int Hour = Integer.parseInt(timeManager.getHour());
//                int minute = Integer.parseInt(timeManager.getMinute());
//                int second = Integer.parseInt(timeManager.getSecond());
//                Calendar calendar = Calendar.getInstance();
//                calendar.set(Calendar.HOUR, Hour);
//                calendar.set(Calendar.MINUTE, minute);
//                calendar.set(Calendar.SECOND, second+10);
//                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
//                ClockManager clockManager = ClockManager.getClockManager(this);
//                clockManager.setClock(this, myReceiver.class, 0);
                ClockManager clockManager = ClockManager.getClockManager(this);
                clockManager.setRepeating(this, myReceiver.class, 47, 0, 0.5);
                break;
            case R.id.btn_cancel:
                alarmManager.cancel(pi);
                btn_cancel.setVisibility(View.GONE);
                Toast.makeText(this, "闹钟已取消", Toast.LENGTH_SHORT)
                        .show();
                break;
        }
    }
}


