package com.example.testofmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;

public class Music_activity extends AppCompatActivity {
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_activity);
    }

    public void play(View view) {
        try {
            mediaPlayer.setDataSource("http://www.citynorth.cn/music/confucius.mp3");
            mediaPlayer.prepareAsync();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause(View view) {

    }

    public void stop(View view) {
    }
}
