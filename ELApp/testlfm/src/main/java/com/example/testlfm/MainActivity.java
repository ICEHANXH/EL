package com.example.testlfm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.File;

import libs.Image_IO;
import libs.Music_lib;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private boolean IsPause = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!IsPermitted()) {
            requestPermissions();
        } else {
            ImageView imageView = findViewById(R.id.imageView);
            Image_IO.SetImage(this, "java.jpg", imageView);
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

    public void ToImage2(View view) {
        if (!IsPermitted()) {
            requestPermissions();
        } else {
            ImageView imageView = findViewById(R.id.imageView);
            Image_IO.SetImage(MainActivity.this, "java.jpg", imageView);
            File file = new File(Environment.getExternalStorageDirectory()
                    , "/pictures/" + "java.jpg");
            Picasso.with(this)
                    .load(file)
                    .transform(new CircleTransform())
                    .transform(new BlurTransformation(MainActivity.this))
                    .into(imageView);

        }
    }

    public void ToImage1(View view) {
        if (!IsPermitted()) {
            requestPermissions();
        } else {
            ImageView imageView = findViewById(R.id.imageView);
            Image_IO.SetImage(MainActivity.this, "imah.jpg", imageView);
            File file = new File(Environment.getExternalStorageDirectory()
                    , "/pictures/" + "imah.jpg");
            Picasso.with(this)
                    .load(file)
                    .transform(new CircleTransform())
                    .transform(new BlurTransformation(MainActivity.this))
                    .into(imageView);
        }
    }

    private static Transformation getTransformation(final ImageView view) {
        return new Transformation() {
            @Override
            public Bitmap transform(Bitmap source) {
                int targetWidth = view.getWidth();

                //返回原图
                if (source.getWidth() == 0 || source.getWidth() < targetWidth) {
                    return source;
                }

                //如果图片大小大于等于设置的宽度，则按照设置的宽度比例来缩放
                double aspectRatio = (double) source.getHeight() / (double) source.getWidth();
                int targetHeight = (int) (targetWidth * aspectRatio);
                if (targetHeight == 0 || targetWidth == 0) {
                    return source;
                }
                Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                if (result != source) {
                    // Same bitmap is returned if sizes are the same
                    source.recycle();
                }
                return result;
            }

            @Override
            public String key() {
                return "transformation" + " desiredWidth";
            }
        };
    }

    public void playMusic(View view) {
        Button button = findViewById(R.id.play);
        if (!IsPermitted()) {
            requestPermissions();
        } else {
            if (IsPause) {
                mediaPlayer = Music_lib.ContinueToPlay(mediaPlayer);
                IsPause = false;
                button.setText("正在播放中");
            } else {
                mediaPlayer = Music_lib.pause(mediaPlayer);
                IsPause = true;
                button.setText("音乐已暂停");
            }
        }
    }

    public void ToSong1(View view) {
        if (mediaPlayer == null)
            this.mediaPlayer = Music_lib.GetMediaPlayer();
        this.mediaPlayer = Music_lib.stop(mediaPlayer);
        this.mediaPlayer = Music_lib.play(mediaPlayer, "bgm1.mp3");
    }

    public void ToSong2(View view) {
        if (mediaPlayer == null)
            this.mediaPlayer = Music_lib.GetMediaPlayer();
        this.mediaPlayer = Music_lib.stop(mediaPlayer);
        this.mediaPlayer = Music_lib.play(mediaPlayer, "bgm2.mp3");
    }
}
