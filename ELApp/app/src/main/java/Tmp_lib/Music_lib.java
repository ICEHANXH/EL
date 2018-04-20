package Tmp_lib;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Environment;

import java.io.File;

/*
*1. To get the source
* a. 用户在应用中事先自带的resource资源
例如：MediaPlayer.create(this, R.raw.test);
b. 存储在SD卡或其他文件路径下的媒体文件
例如：mp.setDataSource("/sdcard/test.mp3");
c. 网络上的媒体文件
例如：mp.setDataSource("http://www.citynorth.cn/music/confucius.mp3");
* */

//尚未实现某一个序列音乐播放
//暂时未考虑service  ——2018.4.18

public class Music_lib {

    public static MediaPlayer GetMediaPlayer(Context context, int rawSource) {
        return MediaPlayer.create(context, rawSource);
    }

    public static MediaPlayer GetMediaPlayer() {
        return new MediaPlayer();
    }

    /**
     * @param mediaPlayer
     */
    public static MediaPlayer play(MediaPlayer mediaPlayer, String source) {
        try {
            if (mediaPlayer == null) {
                mediaPlayer = Music_lib.GetMediaPlayer();
            }
            if (mediaPlayer.isPlaying())
                mediaPlayer.reset();
            File file = new File(Environment.getExternalStorageDirectory()
                    , "/music/" + source);
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
            MediaPlayer finalMediaPlayer = mediaPlayer;
            mediaPlayer.setOnPreparedListener(mp -> finalMediaPlayer.start());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }

    public static MediaPlayer pause(MediaPlayer mediaPlayer) {
        try {
            if (mediaPlayer == null)
                return null;
            if (isPlay(mediaPlayer))
                mediaPlayer.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }

    public static boolean isPlay(MediaPlayer mediaPlayer) {
        return mediaPlayer.isPlaying();
    }

    public static MediaPlayer stop(MediaPlayer mediaPlayer) {
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
//            mediaPlayer.release();
            mediaPlayer.prepareAsync();

        }
        return mediaPlayer;
    }

    public static void setLooping(MediaPlayer mediaPlayer, String source, boolean pro) {
        mediaPlayer.setLooping(pro);
        mediaPlayer.setOnCompletionListener(mp -> {
            if (pro) play(mediaPlayer, source);
            else stop(mediaPlayer);
        });
    }

    public static void errorSolution(MediaPlayer mediaPlayer) {

    }

    public static void PermissionRequest() {
//        if (ContextCompat.checkSelfPermission(MainActivity.this
//                , Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(MainActivity.this
//                    , new String[]{
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE
//                    }, 1);
//        } else {
//            initMediaPlayer();
//        }
    }
}
