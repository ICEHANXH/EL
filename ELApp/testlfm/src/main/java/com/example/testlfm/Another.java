package com.example.testlfm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.coder.circlebar.CircleBar;

import Managers.CountingDown;

public class Another extends AppCompatActivity {
    TextView text;
    private boolean ifStop = true;
    private int count;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        CircleBar circleBar = findViewById(R.id.pro);
        circleBar.setMaxstepnumber(100);
        int[] mColors = new int[]{0xFF123456, 0xFF369852, 0xFF147852};

        circleBar.setShaderColor(mColors);
        circleBar.update(100, 10000);


        text = findViewById(R.id.ClockText);

        CountingDown countingDown = CountingDown.getCountingDown();
        Handler handler = new Handler() {
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

    }

}


