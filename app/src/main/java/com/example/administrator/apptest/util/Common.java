package com.example.administrator.apptest.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.net.URLEncoder;

/**
 * Created by liqiang on 2016/6/3.
 */
public class Common {

    public static int dip2px(Context context, float dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取当前程序的版本号
     */
    public static String getVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();// 获取packagemanager的实例
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(),0);// getPackageName()是你当前类的包名，0代表是获取版本信息
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packInfo.versionName;
    }


    public static String toURLEncoded(String paramString) {
        if (paramString == null || paramString.equals("")) {
            Log.e("toURLEncoded error",paramString);
            return "";
        }

        try
        {
            String str = new String(paramString.getBytes(), "UTF-8");
            str = URLEncoder.encode(str, "UTF-8");
            return str;
        }
        catch (Exception localException)
        {
            Log.e("toURLEncoded error",paramString, localException);
        }

        return "";
    }


}
