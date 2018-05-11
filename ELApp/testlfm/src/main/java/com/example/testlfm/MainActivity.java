package com.example.testlfm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.iwgang.countdownview.CountdownView;
import io.github.yuweiguocn.lib.squareloading.SquareLoading;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean IsPause = false;
    private CountdownView countdownView;
    private SquareLoading squareLoading;
    // 1. 定义控件变量
    private scut.carson_ho.kawaii_loadingview.Kawaii_LoadingView kawai;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        squareLoading = loading_lib.getSquareLoading(this, R.id.squareLoading);
//        squareLoading = loading_lib.square_loading_stop(squareLoading);
        kawai = loading_lib.getkawaii_loadingView(this, R.id.Kawaii_LoadingView);


    }

    public void playAndCount(View view) {
//        squareLoading=loading_lib.square_loading_start(squareLoading);
        if (countdownView == null) {
            countdownView = CountingDown.getCountingDown(MainActivity.this, R.id.countingDown);
        }
        countdownView = CountingDown.start(3, 5, countdownView);
        countdownView.setOnCountdownEndListener(cv -> {
            mediaPlayer = Music_lib.pause(mediaPlayer);
            IsPause = true;
        });
        if (!File_IO_Lib.IsPermitted(MainActivity.this)) {
            File_IO_Lib.requestPermissions(MainActivity.this);
        } else {
            if (mediaPlayer == null) {
                mediaPlayer = Music_lib.GetMediaPlayer();
                mediaPlayer = Music_lib.play(MainActivity.this, mediaPlayer, "bgm2.mp3");
                IsPause = false;
                loading_lib.kawaii_loading_start(kawai);
            } else if (IsPause) {
                mediaPlayer = Music_lib.ContinueToPlay(mediaPlayer);
                IsPause = false;
                loading_lib.kawaii_loading_start(kawai);
            } else {
                mediaPlayer = Music_lib.pause(mediaPlayer);
                IsPause = true;
                loading_lib.kawaii_loading_stop(kawai);
                countdownView = CountingDown.pause(countdownView);
            }
        }
    }

    public void btn2Event(View view) {

    }

    public void btn3Event(View view) {
        Intent intent = new Intent(this, Another.class);
        startActivity(intent);
    }
}
