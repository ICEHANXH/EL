package com.example.testofmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.begin);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Music_activity.class);
            startActivity(intent);
        });
    }

    public void beginMusic_btn(View view) {
////        Music_lib.playSong(this);
//        MediaPlayer mediaPlayer = null;
//        try {
//            mediaPlayer = MediaPlayer.create(this, R.raw.bgm1);
//            mediaPlayer.reset();
////            mediaPlayer.prepare();
//            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            MediaPlayer finalMediaPlayer = mediaPlayer;
//            mediaPlayer.setOnPreparedListener(mp -> finalMediaPlayer.start());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        iniPlayer();
    }

    private void iniPlayer() {
        try {
//            File file = new File(Environment.getExternalStorageDirectory()
//                    , "bmg.mp3");
//            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    public void endMusic_btn(View view) {
        iniPlayer();
    }
}
