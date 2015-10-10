package com.ckelsel.android.oschina.common;

import android.content.Context;
import android.content.Intent;

import com.ckelsel.android.oschina.ui.MainActivity;

/**
 * Created by ckelsel on 2015/9/3.
 */
public class UIHelper {
        /**
         * 进入主界面
         * */
        public static void goMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
