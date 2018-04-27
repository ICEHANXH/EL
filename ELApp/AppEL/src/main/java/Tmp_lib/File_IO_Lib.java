package Tmp_lib;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class File_IO_Lib {
//    public static String[] getAssetsAbsolutePath(Context context, String string) {
//
//    }

    /**
     * Get the inputStream of the assets file
     * You could use this to get the info from the files
     */
    public static InputStream getAssets(Context context, String string) throws IOException {
        return context.getResources()
                .getAssets()
                .open(string);

    }

    public static Uri getUriRes(Context context, int rawFile) {

        return Uri.parse("android.resource://" + context.getPackageName() + "/" + rawFile);
    }

    public static String getAssetsInfo(Context context, String string) {
        try {
            return new String(InputStreamToByte(getAssets(context, string)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] InputStreamToByte(InputStream is) throws IOException {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1) {
            bytestream.write(ch);
        }
        byte imgdata[] = bytestream.toByteArray();
        bytestream.close();
        return imgdata;
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

    /**
     * 从assets目录中复制整个文件夹内容
     *
     * @param context Context 使用CopyFiles类的Activity
     * @param oldPath String  原文件路径  如：/aa
     * @param newPath String  复制后路径  如：xx:/bb/cc
     */
    public void copyFilesFassets(Context context, String oldPath, String newPath) {
        try {
            String fileNames[] = context.getAssets().list(oldPath);//获取assets目录下的所有文件及目录名
            if (fileNames.length > 0) {//如果是目录
                File file = new File(newPath);
                file.mkdirs();//如果文件夹不存在，则递归
                for (String fileName : fileNames) {
                    copyFilesFassets(context, oldPath + "/" + fileName, newPath + "/" + fileName);
                }
            } else {//如果是文件
                InputStream is = context.getAssets().open(oldPath);
                FileOutputStream fos = new FileOutputStream(new File(newPath));
                byte[] buffer = new byte[1024];
                int byteCount = 0;
                while ((byteCount = is.read(buffer)) != -1) {//循环从输入流读取 buffer字节
                    fos.write(buffer, 0, byteCount);//将读取的输入流写入到输出流
                }
                fos.flush();//刷新缓冲区
                is.close();
                fos.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //如果捕捉到错误则通知UI线程
        }
    }


    public static byte[] WriteSomething(Context context, String string) {
        byte[] bytes = new byte[10];
        try {
            InputStream inputStream = context.getResources()
                    .getAssets()
                    .open("music/bgm4.mp3");
            bytes = new byte[20];
            inputStream.read(bytes, 0, 5);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
