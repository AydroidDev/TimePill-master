package com.dante.diary.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dante.diary.base.App;

import java.util.Set;



public class SpUtil {

    private static SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(App.context);
    private static SharedPreferences.Editor editor = sp.edit();

    public static void save(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public static void save(String key, Set<String> value) {
        editor.putStringSet(key, value);
        editor.apply();
    }

    public static void save(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void save(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public static String get(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    public static void remove(String key) {
        editor.remove(key).apply();
    }

    public static String getString(String key) {
        return sp.getString(key, "");
    }

    public static Set<String> getStringSet(String key) {
        return sp.getStringSet(key, null);
    }

    public static int getInt(String key) {
        return sp.getInt(key, 0);
    }

    public static int getInt(String key, int def) {
        return sp.getInt(key, def);
    }

    public static boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    public static boolean getBoolean(String key, boolean def) {
        return sp.getBoolean(key, def);
    }

    public static void clear() {
        editor.clear().apply();
    }
}
