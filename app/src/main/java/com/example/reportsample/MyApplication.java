package com.example.reportsample;

import android.app.Application;

public class MyApplication extends Application {

    private static Application mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Application getInstance() {
        return mContext;
    }
}
