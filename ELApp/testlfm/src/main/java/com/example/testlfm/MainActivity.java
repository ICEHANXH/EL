package com.example.testlfm;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean IsPause = false;
    private CountdownView countdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playAndCount(View view) {

        if (countdownView == null) {
            countdownView = CountingDown.getCountingDown(MainActivity.this, R.id.countingDown);
        }
        countdownView = CountingDown.start(30, countdownView);
        countdownView.setOnCountdownEndListener(cv -> {
            mediaPlayer = Music_lib.pause(mediaPlayer);
            IsPause = true;
        });
        TextView textView = findViewById(R.id.text);
        if (!File_IO_Lib.IsPermitted(MainActivity.this)) {
            File_IO_Lib.requestPermissions(MainActivity.this);
        } else {
            if (mediaPlayer == null) {
                mediaPlayer = Music_lib.GetMediaPlayer();
                mediaPlayer = Music_lib.play(MainActivity.this, mediaPlayer, "bgm2.mp3");
                IsPause = false;
            } else if (IsPause) {
                mediaPlayer = Music_lib.ContinueToPlay(mediaPlayer);
                IsPause = false;
            } else {
                mediaPlayer = Music_lib.pause(mediaPlayer);
                IsPause = true;
            }
        }
    }
}
