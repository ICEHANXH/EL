package Managers;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.example.testlfm.R;

public class WinStrategy {

    public void WinStragegyOn(Context context) {
        ScreenManager l = new ScreenManager(context);
        l.begin(new ScreenManager.ScreenStateListener() {

            @Override
            public void onUserPresent() {
                Toast.makeText(context, "onUserPresent", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onScreenOn() {
                Toast.makeText(context, "onScreenOn", Toast.LENGTH_SHORT).show();
                MusicManager.getMusicManager().play(context, new MediaPlayer(), R.raw.bgm1);

            }

            @Override
            public void onScreenOff() {
                Toast.makeText(context, "onScreenOff", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
