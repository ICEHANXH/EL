package Tmp_lib;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class file_related_to_sdcard {
    /**
     * 获取sd卡的缓存路径， 一般在卡中sdCard就是这个目录
     *
     * @return SDPath
     */
    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();// 获取根目录
        } else {
            Log.e("ERROR", "没有内存卡");
        }
        return sdDir.toString();
    }
}
