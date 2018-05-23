package com.mycompany.story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class fourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }

    /**Called when the user clicks the Send button*/
    public void sendMessage(View view){
        Intent intent =  new Intent(this,fifthActivity.class);
        startActivity(intent);
    }
}
