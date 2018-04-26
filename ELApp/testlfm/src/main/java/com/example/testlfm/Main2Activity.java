package com.example.testlfm;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class Main2Activity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private boolean IsPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.text);
        File file = File_IO_Lib.getSDcardDic();
        textView.setText(file.getAbsolutePath());
    }

    public void play(View view) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer == null) {
                        mediaPlayer = Music_lib.GetMediaPlayer();
                        mediaPlayer = Music_lib.play(Main2Activity.this, mediaPlayer, R.raw.bgm4);
                        IsPause = true;
                    }

                    if (IsPause) {
                        mediaPlayer = Music_lib.ContinueToPlay(mediaPlayer);
                        IsPause = false;
                    } else {
                        mediaPlayer = Music_lib.pause(mediaPlayer);
                        IsPause = true;
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
