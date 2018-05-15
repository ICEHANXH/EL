package com.example.testlfm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import Managers.MusicManager;

public class myReceiver extends BroadcastReceiver {
    private MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "开始播放", Toast.LENGTH_SHORT).show();
        MusicManager musicManager = MusicManager.getMusicManager();
        musicManager.play(context, mediaPlayer, R.raw.bgm1);
    }
}