package com.example.administrator.apptest.callback;


import android.util.Log;

import com.example.administrator.apptest.util.JsonParser;

/**
 * Json数据解析
 *
 * @param <T>
 * @author Administrator
 */
public abstract class JsonCallBack<T> extends AbstractCallBack<T> {
    @Override
    protected T bindData(String content) {
        Log.e("服务器返回的结果2", content);
        if (mReturnClass != null) {
            return JsonParser.deserializeByJson(content, mReturnClass);
        } else if (mReturnType != null) {
            return JsonParser.deserializeByJson(content, mReturnType);
        }
        return null;
    }
}
