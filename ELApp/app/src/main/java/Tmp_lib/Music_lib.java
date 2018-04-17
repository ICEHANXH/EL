package Tmp_lib;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.lenovo.elapp.R;

/*
*1. To get the source
* a. 用户在应用中事先自带的resource资源
例如：MediaPlayer.create(this, R.raw.test);
b. 存储在SD卡或其他文件路径下的媒体文件
例如：mp.setDataSource("/sdcard/test.mp3");
c. 网络上的媒体文件
例如：mp.setDataSource("http://www.citynorth.cn/music/confucius.mp3");
* */
public class Music_lib {
    //    private static final String THEME = "java/music_buff/theme.mp3";
//    private static final String BG1 = "../music_buff/bgm1.mp3";
//    private static final String BG2 = "../music_buff/bgm2.mp3";
//    private static final String BG3 = "../music_buff/bgm3.mp3";
//    private static final String BG4 = "../music_buff/bgm4.mp3";
//    private static final String BG5 = "../music_buff/bgm5.mp3";
//    private static final String BG6 = "../music_buff/bgm6.mp3";
//    private static final String BG7 = "../music_buff/bgm7.mp3";
//    private static final String BG8 = "../music_buff/bgm8.mp3";
//    private static final String BG9 = "../music_buff/bgm9.mp3";
//    private static final String BG10 = "../music_buff/bgm10.mp3";
//    private static final String BG11 = "../music_buff/bgm11.mp3";
//    private static final String BG12 = "../music_buff/bgm12.mp3";
//    private static final String BG13 = "../music_buff/effect4.mp3";
//    private static final String BG14 = "../music_buff/effect1.mp3";
//    private static final String BG15 = "../music_buff/bgm15.mp3";
//    private static final String EFFECT1 = "../music_buff/effect.mp3";
//    private static final String EFFECT2 = "../music_buff/eliminate1.mp3";
//    private static final String EFFECT3 = "../music_buff/change.mp3";
//    private static final String[] songs = {
//            THEME, BG1, BG2, BG3, BG4, BG5, BG6,
//            BG7, BG8, BG9, BG10, BG11, BG12, BG13,
//            BG14, BG15, EFFECT1, EFFECT2, EFFECT3,
//    };
    private static MediaPlayer mediaPlayer = null;

    /**
     * @param context   :The source of the service or activity.
     * @param rawSource :The source of the media in R.raw.xxx
     * @return :The specific MediaPlayer
     */
    public static MediaPlayer play(Context context, int rawSource) {

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
     * @param source :url from the service computer or native dic in the cellPhone
     * @return :The specific MediaPlayer
     */
    public static MediaPlayer play(String source) {
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(source);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
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

    public static void setLooping(MediaPlayer mediaPlayer, Context context, boolean pro) {
        mediaPlayer.setLooping(pro);
        mediaPlayer.setOnCompletionListener(mp -> {
            if (pro) play(context, R.raw.bgm1);
            else stopAndRelease(mediaPlayer);
        });
    }

    public static void errorSolution(MediaPlayer mediaPlayer) {

    }
}
