package com.ckelsel.android.oschina.ui.fragments;

import android.os.Bundle;

import com.ckelsel.android.oschina.R;
import com.ckelsel.android.oschina.adapter.ViewPageFragmentAdapter;
import com.ckelsel.android.oschina.ui.basefragment.BaseViewPagerFragment;

/**
 * Created by ckelsel on 2015/10/2.
 */
public class ExploreViewPagerFragment extends BaseViewPagerFragment {
    public static ExploreViewPagerFragment newInstance() {
        return new ExploreViewPagerFragment();
    }

    @Override
    protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
//        String[] title = getResources().getStringArray(R.array.explore_title_array);
//        Bundle featuredBundle = new Bundle();
//        featuredBundle.putByte(EXPLORE_TYPE, TYPE_FEATURED);
//        adapter.addTab(title[0], "featured", ExploreProjectsFragment.class, featuredBundle);
//        Bundle popularBundle = new Bundle();
//        popularBundle.putByte(EXPLORE_TYPE, TYPE_POPULAR);
//        adapter.addTab(title[1], "popular", ExploreProjectsFragment.class, popularBundle);
//        Bundle latestdBundle = new Bundle();
//        latestdBundle.putByte(EXPLORE_TYPE, TYPE_LATEST);
//        adapter.addTab(title[2], "latest", ExploreProjectsFragment.class, latestdBundle);
    }
}
