package com.ckelsel.android.oschina;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.ckelsel.android.oschina.common.L;
import com.ckelsel.android.oschina.common.StringUtils;

import java.util.Properties;
import java.util.UUID;

/**
 * 全局类
 * app会话上下文
 *
 * Created by ckelsel on 2015/9/3.
 */
public class AppContext extends Application {
    private final static String TAG = "AppContext";
    private static AppContext mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;

        L.Debug(L.GLOBAL, TAG, "onCreate");
    }

    public static AppContext getInstance() {
        return mAppContext;
    }

    public boolean isLogin() {
        return false;
    }

    public boolean isNeedUpdate() {
        return true;
    }

    public void setProperties(Properties ps) {
        AppConfig.getInstance().set(ps);
    }

    public Properties getProperties() {
        return AppConfig.getInstance().get();
    }

    public void setProperty(String key, String value) {
        AppConfig.getInstance().set(key, value);
    }

    public String getProperty(String key) {
        String res = AppConfig.getInstance().get(key);
        return res;
    }

    public void removeProperty(String... key) {
        AppConfig.getInstance().remove(key);
    }

    /**
     * 获取App唯一标识
     *
     * @return
     */
    public String getAppId() {
        String uniqueID = getProperty(AppConfig.CONF_APP_UNIQUEID);
        if (StringUtils.isEmpty(uniqueID)) {
            uniqueID = UUID.randomUUID().toString();
            setProperty(AppConfig.CONF_APP_UNIQUEID, uniqueID);
        }
        return uniqueID;
    }

    /**
     * 获取App安装包信息
     *
     * @return
     */
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
            L.Error(L.GLOBAL, TAG, e.getMessage());
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }
}
