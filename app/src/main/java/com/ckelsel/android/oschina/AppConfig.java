package com.ckelsel.android.oschina;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import com.ckelsel.android.oschina.common.Contanst;

/**
 * Created by ckelsel on 2015/9/4.
 */
public class AppConfig {

    private final static String APP_CONFIG = "config";

    public final static String CONF_APP_UNIQUEID = "APP_UNIQUEID";

    public final static String CONF_LOAD_IMAGE = "perf_loadimage";

    public final static String CONF_HTTPS_LOGIN = "perf_httpslogin";

    public final static String CONF_RECEIVENOTICE = "perf_receivenotice";

    public final static String CONF_VOICE = "perf_voice";

    public final static String CONF_CHECKUP = "perf_checkup";

    public final static String CONF_FRIST_START = "isFristStart";

    private static AppConfig mAppConfig;
    
    private AppContext mAppContext;

    private AppConfig() {
        mAppContext = AppContext.getInstance();
    }

    public static AppConfig getInstance() {
        if (mAppConfig == null) {
            mAppConfig = new AppConfig();
        }
        return mAppConfig;
    }


    /**
     * 获得用户的token
     *
     * @return
     */
    public String getPrivateToken() {
        return get(Contanst.PROP_KEY_PRIVATE_TOKEN);
    }

    public String get(String key) {
        Properties props = get();
        return (props != null) ? props.getProperty(key) : null;
    }

    public Properties get() {
        FileInputStream fis = null;
        Properties props = new Properties();
        try {
            // 读取files目录下的config
            // fis = activity.openFileInput(APP_CONFIG);

            // 读取app_config目录下的config
            File dirConf = mAppContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            fis = new FileInputStream(dirConf.getPath() + File.separator
                    + APP_CONFIG);

            props.load(fis);
        } catch (Exception e) {
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
        return props;
    }

    private void setProps(Properties p) {
        FileOutputStream fos = null;
        try {
            // 把config建在files目录下
            // fos = activity.openFileOutput(APP_CONFIG, Context.MODE_PRIVATE);

            // 把config建在(自定义)app_config的目录下
            File dirConf = mAppContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            File conf = new File(dirConf, APP_CONFIG);
            fos = new FileOutputStream(conf);

            p.store(fos, null);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public void set(Properties ps) {
        Properties props = get();
        props.putAll(ps);
        setProps(props);
    }

    public void set(String key, String value) {
        Properties props = get();
        props.setProperty(key, value);
        setProps(props);
    }

    public void remove(String... key) {
        Properties props = get();
        for (String k : key)
            props.remove(k);
        setProps(props);
    }
}
