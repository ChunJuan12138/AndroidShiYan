package com.example.ZZW.mobileshop.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ZZW.mobileshop.common.MobileShopApp;

public class SpTools {

    private static final String CONFIG_FILE_NAME = "mobileshop_config_file";


    public static void putBoolean(String key, boolean value) {
        SharedPreferences sp = MobileShopApp.getContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();//提交保存键值对

    }

    public static boolean getBoolean(String key, boolean defValue) {
        SharedPreferences sp = MobileShopApp.getContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }


    public static void putString(String key, String value) {
        SharedPreferences sp = MobileShopApp.getContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();//提交保存键值对

    }

    public static String getString(String key, String defValue) {
        SharedPreferences sp = MobileShopApp.getContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }


    public static void putInt(String key, int value) {
        SharedPreferences sp = MobileShopApp.getContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();//提交保存键值对

    }


    public static int getInt(String key, int defValue) {
        SharedPreferences sp = MobileShopApp.getContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }


    public static void putLong(String key, long value) {
        SharedPreferences sp = MobileShopApp.getContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putLong(key, value).commit();//提交保存键值对

    }

    public static long getLong(String key, long defValue) {
        SharedPreferences sp = MobileShopApp.getContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getLong(key, defValue);
    }
}
