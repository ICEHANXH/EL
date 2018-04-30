package com.example.testlfm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.play);
        button.setOnClickListener(v -> {
            if (!IsPermitted()) {
                requestPermissions();
            } else {
                mediaPlayer = Music_lib.GetMediaPlayer();
                Music_lib.playExternal(mediaPlayer, "bgm6.mp3");
                try {
                    new Thread(() -> {
                        TextView textView = findViewById(R.id.text);
                        Music_lib.pause(mediaPlayer);
                    }).start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void ToImage2(View view) {
        ImageView imageView = findViewById(R.id.imageView);
        Image_IO.SetImage(MainActivity.this,R.raw.new_loading,imageView);
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
