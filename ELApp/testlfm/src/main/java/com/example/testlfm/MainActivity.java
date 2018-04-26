package com.example.testlfm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean IsPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.image1);
        Button buttonT = findViewById(R.id.trans);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!IsPermitted()) {
                    requestPermissions();
                } else {
                    mediaPlayer = Music_lib.GetMediaPlayer();
//                    Music_lib.play(mediaPlayer, "Taylor Swift-End Game.mp3");
                    try {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    new timer(10);
                                    Music_lib.pause(mediaPlayer);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //System.out.println(3);
                }
            }
        });
        buttonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    public void ToImage2(View view) {
        try {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer == null) {
                        mediaPlayer = Music_lib.GetMediaPlayer();
                        mediaPlayer = Music_lib.playExternal(mediaPlayer, "bgm6.mp3");
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

    private boolean IsPermitted() {
        return ContextCompat.checkSelfPermission(MainActivity.this
                , Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(MainActivity.this
                , new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 1);
    }
}
