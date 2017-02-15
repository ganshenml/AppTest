package com.example.administrator.apptest.util;

import java.text.SimpleDateFormat;

/**
 * Created by liqiang on 2016/3/24.
 */
public class StringUtils {

    public static boolean isEmpty(String s){
        return s == null || "".equals(s.trim()) || "null".equals(s.trim().toLowerCase());
    }

    public static String getDateFromLong(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String result = sdf.format(time);
        return result;
    }
}
