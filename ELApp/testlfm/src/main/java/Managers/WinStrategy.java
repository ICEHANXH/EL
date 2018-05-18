package Managers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicReference;


public class WinStrategy {

    private TimeManager timeManager;
    private ClockManager clockManager;
    private ScreenManager lockScreenManager;
    private MediaPlayer mediaPlayer;
    private MusicManager musicManager;
    private FileManager fileManager;
    private TaskManager taskManager;
    private Achievement achievement;
    private Task task;
    private List<String> musicPathList;
    private boolean IsPause;
    private int MaxDelay;

    private WinStrategy(Context context) {

        this.fileManager = FileManager.getFileManager();
        this.musicManager = MusicManager.getMusicManager();
        this.mediaPlayer = musicManager.GetMediaPlayer();
        this.timeManager = TimeManager.getTimeManager(context);
        this.clockManager = ClockManager.getClockManager(context);
        this.lockScreenManager = ScreenManager.getScreenManager(context);
        this.IsPause = false;
        this.MaxDelay = 5;
        this.achievement = Achievement.getAchievement(context);
        this.musicPathList = new LinkedList<>();
        try {
            File musicBuffFile = fileManager.getAllSameSuffixPath(context, ".m4a", "/kgmusic/download", true);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(musicBuffFile));
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null && musicPathList.size() <= 10) {
                musicPathList.add(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static WinStrategy getWinStrategy(Context context) {
        return new WinStrategy(context);
    }

    public void WinStrategyOn(Context context, Task task) {
        this.task = task;
        Toast.makeText(context, "任务已经开始\n请少侠放下手机 开始静心专注吧~~~", Toast.LENGTH_LONG).show();
        PlayInArray();
        CountingPart(context, this.MaxDelay, this.task);
        ScreenListenerPart(context);
    }

    private void PlayInArray() {
        mediaPlayer = musicManager.playExternalAbsolutePath(mediaPlayer, musicPathList.get(musicPathList.size() - 1));
        AtomicReference<ListIterator<String>> iterator = new AtomicReference<>(musicPathList.listIterator());

        mediaPlayer.setOnCompletionListener(mp -> {
            if (!iterator.get().hasNext()) {
                iterator.set(musicPathList.listIterator());
            }
            mediaPlayer = musicManager.playExternalAbsolutePath(mediaPlayer, iterator.get().next());
        });
    }

    private void ScreenListenerPart(Context context) {
        ScreenManager l = new ScreenManager(context);
        l.begin(new ScreenManager.ScreenStateListener() {

            @Override
            public void onUserPresent() {
                mediaPlayer = musicManager.pause(mediaPlayer);
                IsPause = true;
                Toast.makeText(context, "任务进行中 请保持专注\n不要玩手机哦~", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onScreenOn() {
//                Toast.makeText(context, "天干物燥\n小心火烛", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onScreenOff() {
                mediaPlayer = musicManager.ContinueToPlay(mediaPlayer);
                IsPause = false;
            }
        });
    }

    private void CountingPart(Context context, int Max, Task task) {
        @SuppressLint("HandlerLeak") Handler handler = new Handler() {
            //重写handleMessage方法获得子线程传来的数据
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int ms = msg.arg1;
                if (ms == Max) {
                    Toast.makeText(context, "任务失败", Toast.LENGTH_LONG).show();
                    taskManager.TaskFail(task);

                }
            }
        };
        CountingUp countingUp = CountingUp.getCountingUp(handler, 1);
        new Thread(countingUp).start();
    }


    public int getMaxDelay() {
        return MaxDelay;
    }

    public void setMaxDelay(int maxDelay) {
        MaxDelay = maxDelay;
    }
}
