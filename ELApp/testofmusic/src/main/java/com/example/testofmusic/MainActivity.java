package com.example.testofmusic;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import music.Music_lib;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginMusic_btn(View view) {
//        Music_lib.playSong(this);
        MediaPlayer mediaPlayer = null;
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.bgm1);
            mediaPlayer.reset();
//            mediaPlayer.prepare();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            MediaPlayer finalMediaPlayer = mediaPlayer;
            mediaPlayer.setOnPreparedListener(mp -> finalMediaPlayer.start());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void endMusic_btn(View view) {
        Music_lib.play(this);

    }
}
