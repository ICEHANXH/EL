package com.mycompany.story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    /**Called when the user clicks the Send button*/
    public void sendMessage(View view){
        Intent intent =  new Intent(this,thirdActivity.class);
        startActivity(intent);
    }
}
