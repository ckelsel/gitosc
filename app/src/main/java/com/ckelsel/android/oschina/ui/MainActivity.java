package com.ckelsel.android.oschina.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ckelsel.android.oschina.AppContext;
import com.ckelsel.android.oschina.AppManager;
import com.ckelsel.android.oschina.R;
import com.ckelsel.android.oschina.common.L;
import com.ckelsel.android.oschina.common.UpdateManager;
import com.ckelsel.android.oschina.ui.DrawerNavigationMenu;

import com.ckelsel.android.oschina.interfaces.DrawerMenuCallBack;
import com.ckelsel.android.oschina.ui.fragments.ExploreViewPagerFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class MainActivity extends ActionBarActivity implements DrawerMenuCallBack{
    private final static String TAG = "MainActivity";

    static final String DRAWER_MENU_TAG = "drawer_menu";
    static final String DRAWER_CONTENT_TAG = "drawer_content";

    static final String CONTENT_TAG_EXPLORE = "content_explore";
    static final String CONTENT_TAG_MYSELF = "content_myself";

    static final String CONTENTS[] = {
            CONTENT_TAG_EXPLORE,
            CONTENT_TAG_MYSELF
    };

    final String TITLES[] = {
            "发现",
            "我的"
    };

    // 当前显示的界面标识
    private String mCurrentContentTag;

    private String mActionBarTitle;

    private AppContext mAppContext;

    private ActionBar mActionBar;

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Bind(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;

    private FragmentManager mFragmentManager;

    private DrawerNavigationMenu mDrawerNavigationMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        initView(savedInstanceState);
        L.Debug(L.UI, TAG, "onCreate");
    }

    private void init() {
        AppManager.getInstance().add(this);

        mAppContext = (AppContext) getApplicationContext();
        mActionBar = getSupportActionBar();
        mFragmentManager = getSupportFragmentManager();
        mDrawerNavigationMenu = DrawerNavigationMenu.newInstance();
    }


    private void initView(Bundle savedInstanceState) {
        //显示左上角的箭头
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, null, 0, 0);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        //默认显示“发现”页面
        if (savedInstanceState == null) {
            showExplore();
        }
    }

    private void showExplore() {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.replace(R.id.main_slidingmenu_frame, mDrawerNavigationMenu, DRAWER_MENU_TAG);
        ft.replace(R.id.main_content, ExploreViewPagerFragment.newInstance(), DRAWER_CONTENT_TAG);
        ft.commit();

        mActionBarTitle= TITLES[0];
        mActionBar.setTitle(mActionBarTitle);
        mCurrentContentTag = CONTENT_TAG_EXPLORE;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mActionBarDrawerToggle.syncState();

        if (mAppContext.isNeedUpdate()) {
            UpdateManager.getInstance().update();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickLogin() {

    }

    public void onClickSetting() {

    }

    public void onClickExplore() {

    }

    public void onClickMySelf() {

    }

    public void onClickLanguage() {

    }

    public void onClickShake() {

    }

    public void onClickScan() {

    }

}
