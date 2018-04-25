package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

public class appInteraction {
    final String keep = "http://gotokeep.com/";
    final String Scallop_word = "https://www.shanbay.com/";


    private static boolean isApkInstalled(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void openApp(Context context, String packageName){
        if (isApkInstalled(context, packageName)){
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            if (intent != null) {
                intent.putExtra("another", "110");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        } else{
            Intent viewIntent = new Intent();
            viewIntent.setAction("android.intent.action.VIEW");
            Uri content_url = Uri.parse("http://gotokeep.com/");
            viewIntent.setData(content_url);
            context.startActivity(viewIntent);
        }
    }
}