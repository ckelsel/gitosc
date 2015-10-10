package com.ckelsel.android.oschina;

import android.app.Activity;

import java.util.Stack;

/**
 * 全局类
 * 管理所有的Activity
 *
 * Created by ckelsel on 2015/9/3.
 */
public class AppManager {
    private static AppManager mInstance;

    private Stack<Activity> mStack;

    private AppManager() {
        mStack = new Stack<>();
    }

    public static AppManager getInstance() {
        if (mInstance == null) {
            mInstance = new AppManager();
        }
        return mInstance;
    }

    public void add(Activity activity) {
        if (activity != null) {
            if (!mStack.contains(activity)) {
                mStack.add(activity);
            }
        }
    }

    public void finish(Activity activity) {
        if (activity != null) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public int size() {
        return mStack.size();
    }

    public void finishAll() {
        for (Activity activity : mStack) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
