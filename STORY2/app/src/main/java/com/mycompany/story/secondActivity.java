package com.mycompany.story;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

/**
 * Do task(time Countdown)
 * button(Next!)-->The second shot
 * */
public class secondActivity extends AppCompatActivity {

//    private TextView countdownText;
//    private Button countdownButton;
//
//    private CountDownTimer counteDownTimer;
//    private long timeLeftInMillisecond = 600000;//10 mins
//    private boolean timeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        countdownButton = findViewById(R.id.countdown_button);
//        countdownText = findViewById(R.id.countdown_text);
    }


    /**Called when the user clicks the Send button*/
    public void sendMessage(View view){
        Intent intent =  new Intent(this,thirdActivity.class);
        startActivity(intent);
    }


}
