package com.example.testlfm;

import android.content.Context;
import android.net.Uri;

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

    public static Uri getUriAssets(String string) {
        Uri uri = null;
        try {
           uri = Uri.parse("android.resource://"+""+"/raw/sample.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uri;
    }
}
