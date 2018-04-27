package Tmp_lib;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class File_IO_Lib {

    /**
     * Get the inputStream of the assets file
     */
    public static InputStream getAssets(Context context, String string) throws IOException {
        return context.getAssets().open(string);
    }

    public static Uri getUriRes(Context context, int rawFile) {
        return Uri.parse("android.resource://" + context.getPackageName() + "/" + rawFile);
    }

    /**
     * 获取sd卡的缓存路径， 一般在卡中sdCard就是这个目录
     *
     * @return SDPath
     */
    public static String getSDPath() {
        return getSDcardDic().getAbsolutePath();
    }

    /**
     * @return SDcardDic
     */
    public static File getSDcardDic() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory().getAbsoluteFile();// 获取根目录
        } else {
            Log.e("ERROR", "没有内存卡");
        }
        return sdDir;
    }

    /**
     * 获取缓存文件夹目录 如果不存在创建 否则则创建文件夹
     *
     * @return filePath
     */
    public static String isExistsFilePath() {
        String filePath = getSDPath();
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return filePath;
    }
}
