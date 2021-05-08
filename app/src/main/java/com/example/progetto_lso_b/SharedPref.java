package com.example.progetto_lso_b;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref //singleton per le shared pref
{
    private static SharedPreferences sp;


    private SharedPref()
    {

    }

    public static void init(Context context)
    {
        if(sp == null)
            sp = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }

    public static String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static boolean isSignedUp(String key){
        return sp.getBoolean("signUp",false);
    }


    public static void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

}
