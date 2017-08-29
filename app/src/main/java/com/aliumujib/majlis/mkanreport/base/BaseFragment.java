package com.aliumujib.majlis.mkanreport.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.alium.mkan_report_data.constants.Constants;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;
import com.aliumujib.majlis.mkanreport.utils.SharedHelper;
import com.aliumujib.majlis.mkanreport.utils.Utils;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;


/**
 * A placeholder fragment containing a simple view.
 */
public class BaseFragment extends Fragment {

    public SharedHelper mSharedHelperInstance;
    public ParseUser mCurrentParseUser;
    public Context mContext;

    public ImageView mLoadingImage;
    public View mEntireScreenView;
    public String TAG = getClass().getSimpleName();

    //TODO ALWAYS NAME THE ROOTVIEW OF MAINCONTENT entire_screen_view ALWAYS!

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSharedHelperInstance = BaseApplication.getInstance().getmAppSharedPrefHelper();
        mCurrentParseUser = ParseUser.getCurrentUser();
        mContext = getContext();

    }




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public void showContentView() {
        if (mEntireScreenView != null && (mEntireScreenView.getVisibility() == View.INVISIBLE || mEntireScreenView.getVisibility() == View.GONE)) {
            Utils.toggleVisibility(mEntireScreenView);
        } else {
            Log.d(TAG, "cant show: Content view is null");
        }
    }

    protected void hideLoading() {
        showContentView();
        hideLoadingViewFullScreen();
    }

    protected void showLoading() {
        hideContentView();
        showLoadingViewFullScreen();
    }

    public void hideContentView() {
        if (mEntireScreenView != null && mEntireScreenView.getVisibility() == View.VISIBLE) {
            Utils.toggleVisibility(mEntireScreenView);
        } else {
            Log.d(TAG, "cant hide: Content view is null");
        }
    }

    public void showLoadingViewFullScreen() {
        if (mLoadingImage != null && (mLoadingImage.getVisibility() == View.INVISIBLE || mLoadingImage.getVisibility() == View.GONE)) {
            Utils.toggleVisibility(mLoadingImage);
        } else {
            Log.d(TAG, "cant show: loading view is null");
        }
    }

    public void hideLoadingViewFullScreen() {
        if (mLoadingImage != null && mLoadingImage.getVisibility() == View.VISIBLE) {
            Utils.toggleVisibility(mLoadingImage);
        } else {
            Log.d(TAG, "cant show: loading view is null");
        }
    }

    public void showNetworkOpNotification(String title, int intID) {
        if (mContext != null) {
            ((BaseActivity) mContext).showUploadNotification(title, intID);
        }
    }

    public ParseGeoPoint getLocation() {
        if (((BaseActivity) getActivity()).getmGeneralParseGeoPoint() != null) {
            return ((BaseActivity) getActivity()).getmGeneralParseGeoPoint();
        } else {
            return null;
        }
    }


    public void toggleHomeAsUpEnabled(boolean toggle) {
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(toggle);
        }
    }


    public void setupActionBarFragment(@IdRes int toolbarID, View contentView) {
        Toolbar toolbar = (Toolbar) contentView.findViewById(toolbarID);
        ((BaseActivity) getActivity()).setSupportActionBar(toolbar);
    }

    public void setActionBarTitleFragment(String title) {
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    public void setUpBackButtonFragment() {
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public ParseUser getCurrentUser() {
        return ParseUser.getCurrentUser();
    }


    public boolean isUserLoggedIn() {
        if (getCurrentUser() != null) {
            return true;
        } else {
            return false;
        }
    }

    public void hideKeyBoard(View view) {
        ((BaseActivity) getActivity()).hideKeyBoard(view);
    }

    public void replaceChildFragment(Fragment fragment, int frameID) {
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getFragmentManager();


        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(frameID, fragment, Constants.SEARCH_FRAGMENT_TAG);

        ft.commit();
    }


    public void cancelNetworkOpNotification(int intID) {
        if (mContext != null) {
            ((BaseActivity) mContext).cancelNetWorkOpNotifcation(intID);
        }
    }
}
