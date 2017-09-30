package com.aliumujib.majlis.mkanreport.podcast;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alium.soundcloudplayer.ui.fragments.PodcastsLibraryFragment;
import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.main.mvp.IMainActivityView;

/**
 * Created by abdulmujibaliu on 9/30/17.
 */

public class PodcastsFragment extends PodcastsLibraryFragment {


    public static PodcastsFragment newInstance() {
        PodcastsFragment fragment = new PodcastsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getNavigationIcon() {
        return R.drawable.ic_menu_white_18dp;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mToolbar.setNavigationOnClickListener(v -> mMainActivityView.openDrawer());
        mToolbar.setTitle("Podcasts");

    }

    //TO BE COPIED AND PASTED IN EACH LIBRARY FRAGMENT THAT DEALS WITH NAV DRAWER
    private IMainActivityView mMainActivityView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof IMainActivityView) {
            mMainActivityView = (IMainActivityView) context;
        }
    }
}
