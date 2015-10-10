package com.ckelsel.android.oschina.ui.test;

import android.test.ActivityInstrumentationTestCase2;

import com.ckelsel.android.oschina.ui.MainActivity;

/**
 * https://developer.android.com/reference/android/test/ActivityInstrumentationTestCase2.html
 *
 * Created by ckelsel on 2015/9/3.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {

    }

    @Override
    protected void tearDown() throws Exception {

    }

    public void testPreconditions() {

    }

    public void failue() {
        assertEquals(0, 1);
    }
}
