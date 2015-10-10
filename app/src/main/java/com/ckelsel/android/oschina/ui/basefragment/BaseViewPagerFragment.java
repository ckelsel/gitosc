package com.ckelsel.android.oschina.ui.basefragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.ckelsel.android.oschina.R;
import com.ckelsel.android.oschina.adapter.ViewPageFragmentAdapter;
import com.ckelsel.android.oschina.widget.PagerSlidingTabStrip;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ckelsel on 2015/10/2.
 */
public abstract class BaseViewPagerFragment extends baseFragment {
    @Bind(R.id.pager)
    ViewPager mViewPager;

    @Bind(R.id.pager_tabstrip)
    PagerSlidingTabStrip mTabStrip;

    ViewPageFragmentAdapter mTabsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.base_viewpage_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mTabsAdapter = new ViewPageFragmentAdapter(
                getChildFragmentManager(), mTabStrip, mViewPager);

        onSetupTabAdapter(mTabsAdapter);
        mTabsAdapter.notifyDataSetChanged();
        mViewPager.setOffscreenPageLimit(2);
        if (savedInstanceState != null) {
            int pos = savedInstanceState.getInt("position");
            mViewPager.setCurrentItem(pos, true);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", mViewPager.getCurrentItem());
    }

    protected abstract void onSetupTabAdapter(ViewPageFragmentAdapter adapter);
}
