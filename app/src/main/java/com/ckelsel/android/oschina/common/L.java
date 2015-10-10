package com.ckelsel.android.oschina.common;

import android.util.Log;

/**
 * 日志模块
 *
 * Created by ckelsel on 2015/9/3.
 */
public class L {
    public final static boolean mUI = true;
    public final static boolean mCommon = true;
    public final static boolean mWidget = true;
    public final static boolean mAPI = true;
    public final static boolean mDialog = true;
    public final static boolean mGlobal = true;

    public final static int COMMON = 0;
    public final static int UI = 1;
    public final static int WIDGET = 2;
    public final static int API = 3;
    public final static int DIALOG = 4;
    public final static int GLOBAL = 5;

    private static void Log(int level, int module, String tag, String msg) {
        boolean enable = false;

        switch (module) {
            case API:
                enable = mAPI;
                break;
            case DIALOG:
                enable = mDialog;
                break;
            case GLOBAL:
                enable = mGlobal;
                break;
            case COMMON:
                enable = mCommon;
                break;
            case UI:
                enable = mUI;
                break;
            case WIDGET:
                enable = mWidget;
                break;
            default:
                enable = false;
                break;
        }

        if (!enable) {
            return;
        }

        switch (level) {
            case Log.VERBOSE:
                Log.v(tag, msg);
                break;
            case Log.DEBUG:
                Log.d(tag, msg);
                break;
            case Log.INFO:
                Log.i(tag, msg);
                break;
            case Log.ERROR:
                Log.e(tag, msg);
                break;
            default:
                break;
        }
    }

    public static void Error(int module, String tag, String msg) {
        Log(Log.ERROR, module, tag, msg);
    }

    public static void Debug(int module, String tag, String msg) {
        Log(Log.DEBUG, module, tag, msg);
    }

    public static void Info(int module, String tag, String msg) {
        Log(Log.INFO, module, tag, msg);
    }

    public static void Verbose(int module, String tag, String msg) {
        Log(Log.VERBOSE, module, tag, msg);
    }
}
