package com.example.testlfm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean IsPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ToImage2(View view) {
        ImageView imageView = findViewById(R.id.imageView);
        Image_IO.SetImage(MainActivity.this, R.raw.new_loading, imageView);
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

    public void play(View view) {
        TextView textView = findViewById(R.id.text);
        if (!IsPermitted()) {
            requestPermissions();
        } else {
            if (mediaPlayer == null) {
                mediaPlayer = Music_lib.GetMediaPlayer();
                mediaPlayer = Music_lib.play(this, mediaPlayer, "bgm2.mp3");
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

    public void getInfo(View view) {
        TextView textView = findViewById(R.id.text);
        if (!IsPermitted()) {
            requestPermissions();
        } else {
            try {
                File file = File_IO_Lib.getAllSameSuffixPath(this, ".mp3", "buff.txt", true);
                textView.setText(file.getPath());
                BufferedReader bufferedReader =
                        new BufferedReader(new FileReader(file));
                String s;
                s = bufferedReader.readLine();
                if (mediaPlayer == null) {
                    mediaPlayer = Music_lib.GetMediaPlayer();
                }
                mediaPlayer = Music_lib.playExternalAbsolutePath(mediaPlayer, s);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
