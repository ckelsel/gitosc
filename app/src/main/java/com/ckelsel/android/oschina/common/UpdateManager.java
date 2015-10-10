package com.ckelsel.android.oschina.common;

import android.app.AlertDialog;
import android.content.pm.PackageInfo;

import com.ckelsel.android.oschina.AppContext;
import com.ckelsel.android.oschina.api.GitOSCApi;
import com.ckelsel.android.oschina.dialog.LightProgressDialog;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

/**
 * Created by ckelsel on 2015/9/4.
 */
public class UpdateManager {

    private static final int DOWN_NOSDCARD = 0;
    private static final int DOWN_UPDATE = 1;
    private static final int DOWN_OVER = 2;

    private static final int DIALOG_TYPE_LATEST = 0;
    private static final int DIALOG_TYPE_FAIL = 1;

    private static UpdateManager mUpdateManager;
    private AppContext mAppContext;
    private int mCurrentVersion;



    private UpdateManager() {
        mAppContext = AppContext.getInstance();
        getCurrentVersion();
    }

    public static UpdateManager getInstance() {
        if (mUpdateManager == null) {
            mUpdateManager = new UpdateManager();
        }
        return mUpdateManager;
    }

    public void update() {
        final AlertDialog dialog = LightProgressDialog.create(mAppContext, "正在检测，请稍候...");
        dialog.setCanceledOnTouchOutside(false);

        GitOSCApi.getUpdateInfo(new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void getCurrentVersion() {
        try {
            PackageInfo info = mAppContext.getPackageManager().getPackageInfo(mAppContext.getPackageName(), 0);
            mCurrentVersion = info.versionCode;
        } catch (Exception e) {

        }

    }
}
