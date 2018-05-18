package Managers;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.elapp.R;


/*
* 晚安机制
* 所有在晚安时候的操作全部都可以放在onCreate里面
* 早安机制同理
* */

public class GoodEvening extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MusicManager musicManager = MusicManager.getMusicManager();
        musicManager.play(this, mediaPlayer, R.raw.bgm8);
    }
}
