package com.example.testlfm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.coder.circlebar.CircleBar;

public class Another extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        CircleBar circleBar = findViewById(R.id.pro);
        circleBar.setMaxstepnumber(100);
        int[] mColors = new int[]{0xFF123456, 0xFF369852, 0xFF147852};

        circleBar.setShaderColor(mColors);
        circleBar.update(100, 10000);
        circleBar.set
    }
}
