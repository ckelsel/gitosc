package com.ckelsel.android.oschina.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.ckelsel.android.oschina.AppContext;
import com.ckelsel.android.oschina.R;
import com.ckelsel.android.oschina.common.L;
import com.ckelsel.android.oschina.interfaces.DrawerMenuCallBack;
import com.ckelsel.android.oschina.widget.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DrawerNavigationMenu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DrawerNavigationMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrawerNavigationMenu extends Fragment implements View.OnClickListener {
    @Bind(R.id.iv_portrait)
    CircleImageView ivPortrait;

    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.menu_user_info_layout)
    LinearLayout menuUserInfoLayout;
    @Bind(R.id.menu_user_info_login_tips_layout)
    LinearLayout menuUserInfoLoginTipsLayout;

    @Bind(R.id.menu_item_explore)
    LinearLayout menuItemExplore;
    @Bind(R.id.menu_item_myself)
    LinearLayout menuItemMyself;
    @Bind(R.id.menu_item_language)
    LinearLayout menuItemLanguage;
    @Bind(R.id.menu_item_shake)
    LinearLayout menuItemShake;
    @Bind(R.id.menu_item_scan)
    LinearLayout menuItemScan;
    @Bind(R.id.menu_item_setting)
    LinearLayout menuItemSetting;

    private final String TAG = "DrawerNavigationMenu";

    // 当前操作的菜单项
    private View mSavedView;

    private DrawerMenuCallBack mCallBack;

    public static DrawerNavigationMenu newInstance() {
        return new DrawerNavigationMenu();
    }

    public DrawerNavigationMenu() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        L.Debug(L.UI, TAG, "onCreate");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        highlightSelectedItem(menuItemExplore);
        initUserView();
    }

    private void initUserView() {
        if (!AppContext.getInstance().isLogin()) {
            ivPortrait.setImageResource(R.drawable.mini_avatar);
            tvName.setText("");
            menuUserInfoLayout.setVisibility(View.GONE);
            menuUserInfoLoginTipsLayout.setVisibility(View.VISIBLE);
            return;
        }

        L.Error(L.UI, TAG, "User Logon Not Implement");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_drawer_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private void highlightSelectedItem(View v) {
        setSelected(null, false);
        setSelected(v, true);
    }

    private void setSelected(View v, boolean selected) {
        View view;

        if (v == null && mSavedView == null) {
            return;
        }

        if (v != null) {
            mSavedView = v;
        }
        view = mSavedView;

        if (selected) {
            ViewCompat.setHasTransientState(view, true);
            view.setBackgroundResource(R.color.menu_layout_item_pressed_color);
        } else {
            ViewCompat.setHasTransientState(view, false);
            view.setBackgroundResource(R.drawable.menu_layout_item_selector);
        }
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof DrawerMenuCallBack) {
            mCallBack = (DrawerMenuCallBack)activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mCallBack = null;
    }

    @Override
    @OnClick({R.id.menu_user_layout, R.id.menu_item_explore, R.id.menu_item_myself, R.id.menu_item_language,
            R.id.menu_item_shake, R.id.menu_item_scan, R.id.menu_item_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu_user_layout:
                onClickLogin();
                break;
            case R.id.menu_item_explore:
                onClickExplore();
                highlightSelectedItem(view);
                break;
            case R.id.menu_item_myself:
                onClickMySelf();
                if (AppContext.getInstance().isLogin()) {
                    highlightSelectedItem(view);
                }
                break;
            case R.id.menu_item_language:
                onClickLanguage();
                break;
            case R.id.menu_item_shake:
                onClickShake();
                break;
            case R.id.menu_item_scan:
                onClickScan();
                break;
            case R.id.menu_item_setting:
                onClickSetting();
                break;
            default:
                break;
        }
    }


    private void onClickLogin() {
        if (mCallBack != null) {
            mCallBack.onClickLogin();
        }
    }

    private void onClickSetting() {
        if (mCallBack != null) {
            mCallBack.onClickSetting();
        }
    }

    private void onClickExplore() {
        if (mCallBack != null) {
            mCallBack.onClickExplore();
        }
    }

    private void onClickMySelf() {
        if (mCallBack != null) {
            mCallBack.onClickMySelf();
        }
    }

    private void onClickLanguage() {
        if (mCallBack != null) {
            mCallBack.onClickLanguage();
        }
    }

    private void onClickShake() {
        if (mCallBack != null) {
            mCallBack.onClickShake();
        }
    }

    private void onClickScan() {
        if (mCallBack != null) {
            mCallBack.onClickScan();
        }
    }
}
