package com.ckelsel.android.oschina;

import android.app.Activity;
import com.ckelsel.android.oschina.AppManager;

import org.junit.Test;
import java.util.regex.Pattern;
import static org.junit.Assert.*;

/**
 * https://developer.android.com/reference/junit/framework/TestCase.html
 * Created by ckelsel on 2015/9/3.
 */
public class AppManagerTest {
    private AppManager mAppManager = AppManager.getInstance();
    private Activity activity1 = new Activity();;
    private Activity activity2 = new Activity();;

    @Test
    public void AppManager_add() {
        assertEquals(0, mAppManager.size());

        mAppManager.add(null);
        assertEquals(0, mAppManager.size());

        mAppManager.add(activity1);
        mAppManager.add(activity1);
        assertEquals(1, mAppManager.size());

        mAppManager.add( activity2);
        assertEquals(2, mAppManager.size());
    }

    @Test
    public void AppManager_finishAll() {
        mAppManager.finishAll();
        assertEquals(0, mAppManager.size());
    }
}
