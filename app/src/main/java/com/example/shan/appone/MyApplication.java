package com.example.shan.appone;

import android.app.Application;
import android.content.Context;

/**
 * Created by shan on 24.03.2018.
 */

public class MyApplication extends Application {

    private static Context mContext;

    public MyApplication() {
    }

    @Override

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
