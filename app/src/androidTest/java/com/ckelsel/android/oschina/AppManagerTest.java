package com.ckelsel.android.oschina;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import com.ckelsel.android.oschina.AppManager;

import junit.framework.TestCase;

/**
 * https://developer.android.com/reference/junit/framework/TestCase.html
 * Created by ckelsel on 2015/9/3.
 */
public class AppManagerTest extends TestCase{
    private AppManager mAppManager;
    private Activity activity1;
    private Activity activity2;

    @Override
    protected void setUp() throws Exception {
        mAppManager = AppManager.getInstance();
        activity1 = new Activity();
        activity2 = new Activity();
    }

    @Override
    protected void tearDown() throws Exception {
        mAppManager.finishAll();
    }

    public void addTest() {
        assertEquals(0, mAppManager.size());

        mAppManager.add(null);
        assertEquals(0, mAppManager.size());

        mAppManager.add(activity1);
        mAppManager.add(activity1);
        assertEquals(1, mAppManager.size());

        mAppManager.add( activity2);
        assertEquals(2, mAppManager.size());
    }

    public void finishTest() {
        assertEquals(0, 1);
    }
}
