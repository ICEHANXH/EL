package com.example.testlfm;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.iwgang.countdownview.CountdownView;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private CountdownView countingdowView;
    private MediaPlayer mediaPlayer;
    private boolean IsPause = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countingdowView = findViewById(R.id.count);
        countingdowView.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
            @Override
            public void onEnd(CountdownView cv) {
                mediaPlayer = Music_lib.pause(mediaPlayer);
                IsPause = true;
            }
        });
    }

    public void To(View view) {
        countingdowView.start(10000);
        if (mediaPlayer == null) {
            mediaPlayer = Music_lib.GetMediaPlayer();
            mediaPlayer = Music_lib.play(MainActivity.this, mediaPlayer, R.raw.bgm1);
            IsPause = false;
        }
        if (IsPause) {
            mediaPlayer = Music_lib.ContinueToPlay(mediaPlayer);
            IsPause = false;
        } else {
            mediaPlayer = Music_lib.pause(mediaPlayer);
            IsPause = true;
        }
    }
}
