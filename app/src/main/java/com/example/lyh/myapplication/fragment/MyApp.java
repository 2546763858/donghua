package com.example.lyh.myapplication.fragment;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MyApp extends Application {

    public static Context app;
    @Override
    public void onCreate() {
        super.onCreate();

        app=getApplicationContext();



        OkHttpClient okHttpClient = new OkHttpClient.Builder()

                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)

                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

}
