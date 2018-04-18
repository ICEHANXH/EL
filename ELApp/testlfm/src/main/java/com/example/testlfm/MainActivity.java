package com.example.testlfm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Music_lib.play(mediaPlayer, "bgm1.mp3");//还未确定
                } else {
                    Toast.makeText(this, "拒绝权限无法访问", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    public void bgm1(View view) {
        if (!PermissionInsurance()) {
            notPermitted();
        } else {
            if (mediaPlayer.isPlaying()) Music_lib.pause(mediaPlayer);
            if (mediaPlayer == null)
                mediaPlayer = new MediaPlayer();
            Music_lib.play(mediaPlayer, "bgm1.mp3");
        }
    }

    public void bgm2(View view) {
        if (!PermissionInsurance()) {
            notPermitted();
        } else {
            if (mediaPlayer.isPlaying()) Music_lib.pause(mediaPlayer);
            if (mediaPlayer == null)
                mediaPlayer = new MediaPlayer();
            Music_lib.play(mediaPlayer, "bgm2.mp3");
        }
    }

    private boolean PermissionInsurance() {
        return ContextCompat.checkSelfPermission(MainActivity.this
                , Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void notPermitted() {
        ActivityCompat.requestPermissions(MainActivity.this
                , new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 1);
    }
}
