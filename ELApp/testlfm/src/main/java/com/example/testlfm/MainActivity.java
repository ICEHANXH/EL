package com.example.testlfm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!IsPermitted()) {
            requestPermissions();
        } else {

            ImageView imageView = findViewById(R.id.imageView);
            Button button = findViewById(R.id.button);
            File file = new File(Environment.getExternalStorageDirectory()
                    , "/pictures/imah.jpg");
            Picasso.with(this)
                    .load(file)
                    .into(imageView);
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
