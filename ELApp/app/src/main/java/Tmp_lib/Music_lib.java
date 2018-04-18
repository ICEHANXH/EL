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
    /**
     * @param context     :The source of the service or activity.
     * @param rawSource   :The source of the media in R.raw.xxx
     * @param mediaPlayer
     */
    public static MediaPlayer play(Context context, int rawSource, MediaPlayer mediaPlayer) {

        try {
            mediaPlayer = MediaPlayer.create(context, rawSource);
            MediaPlayer finalMediaPlayer = mediaPlayer;
            mediaPlayer.setOnPreparedListener(mp -> finalMediaPlayer.start());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }

    /**
     * @param mediaPlayer
     * @param source      :url from the service computer or native dic in the cellPhone
     *                    ps: the source is just the name of the bgm (后缀也要加)
     *                    ps:所有的音乐文件全部放进music  ,这里的文件目录是模拟器的目录
     *                    查看模拟器目录，在AS里面双击shift，查找  device file explorer
     */
    public static MediaPlayer play(MediaPlayer mediaPlayer, String source) {
        try {
            File file = new File(Environment.getExternalStorageDirectory()
                    , "/music/" + source);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(mp -> mediaPlayer.start());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }

    public static void pause(MediaPlayer mediaPlayer) {
        try {
            if (isPlay(mediaPlayer)) mediaPlayer.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPlay(MediaPlayer mediaPlayer) {
        return mediaPlayer.isPlaying();
    }

    public static void stopAndRelease(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    public static void setLooping(MediaPlayer mediaPlayer, String source, boolean pro) {
        mediaPlayer.setLooping(pro);
        mediaPlayer.setOnCompletionListener(mp -> {
            if (pro) play(mediaPlayer, source);
            else stopAndRelease(mediaPlayer);
        });
    }

    public static void errorSolution(MediaPlayer mediaPlayer) {

    }


}
