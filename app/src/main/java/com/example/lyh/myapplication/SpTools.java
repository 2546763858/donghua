package com.example.lyh.myapplication;

import android.content.Context;
import android.content.SharedPreferences;


public class SpTools {
    private static final String CONFIGFILE = "fc_sp_name";

    public static void setBoolean(String key, boolean value) {
        SharedPreferences sp = MyApp.app.getSharedPreferences(CONFIGFILE, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();

    }


    public static boolean getBoolean(String key, boolean defValue) {
        SharedPreferences sp = MyApp.app.getSharedPreferences(CONFIGFILE, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void setString(String key, String value) {
        SharedPreferences sp = MyApp.app.getSharedPreferences(CONFIGFILE, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static String getString(String key, String defValue) {
        SharedPreferences sp = MyApp.app.getSharedPreferences(CONFIGFILE, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void setInt(String key, int value) {
        SharedPreferences sp = MyApp.app.getSharedPreferences(CONFIGFILE, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }


    public static int getInt(String key, int defValue) {
        SharedPreferences sp = MyApp.app.getSharedPreferences(CONFIGFILE, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static void setLong(String key, long value) {
        SharedPreferences sp = MyApp.app.getSharedPreferences(CONFIGFILE, Context.MODE_PRIVATE);
        sp.edit().putLong(key, value).commit();

    }

    public static long getLong(String key, long defValue) {
        SharedPreferences sp = MyApp.app.getSharedPreferences(CONFIGFILE, Context.MODE_PRIVATE);
        return sp.getLong(key, defValue);
    }
}
