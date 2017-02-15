package com.example.administrator.apptest.callback;


import com.example.administrator.apptest.util.AppException;

/**
 * Created by Stay on 12/7/15.
 * Powered by www.stay4it.com
 */
public interface OnGlobalExceptionListener {

    boolean handleException(AppException exception);
}
