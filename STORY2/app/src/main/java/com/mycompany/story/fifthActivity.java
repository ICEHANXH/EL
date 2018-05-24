package com.mycompany.story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * The last Shot
 *
 * Button to the task-->time countdown && input your own task */
public class fifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
    }

    public void sendMessage(View view){
        Intent intent =  new Intent(this,sixthActivity.class);
        startActivity(intent);
    }
}
