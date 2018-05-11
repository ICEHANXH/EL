package com.example.testlfm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import Managers.Achievement;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void playAndCount(View view) {
        Achievement a = Achievement.getAchievement(this);
        a.setAccomplishment("233");
        a.setCoin("333");
        TextView textView = findViewById(R.id.textView);
        textView.setText(a.getAccomplishment() + "\n" + a.getCoin());
    }

    public void btn2Event(View view) {

    }

    public void btn3Event(View view) {
        Intent intent = new Intent(this, Another.class);
        startActivity(intent);
    }
}
