package com.example.lenovo.elapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        /*ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }*/
    }
}
