package com.ckelsel.android.oschina;

import android.test.AndroidTestRunner;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Created by ckelsel on 2015/9/3.
 */
public class MyTestSuite extends AndroidTestRunner{
    public static void run() {
        MyTestSuite main = new MyTestSuite();
        Class[] testClasses = { AppManagerTest.class};
        TestSuite test = new TestSuite(testClasses);
        main.setTest(test);
        main.runTest();
    }
}
