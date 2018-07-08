/*
 * Terry S, 2018, month: 7, date: 8
 */

package com.example.android.android_me;

import android.util.Log;

public class LogUtil {

    private static String TAG = LogUtil.class.getSimpleName();

    public static void logStuff(String string1) {
        Log.v("ttt >>> " + TAG, string1);
    }

    public static void sayNull() {
        Log.v(TAG, "THE THING IS NULL");
    }

}
