package com.alium.soundcloudplayer.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ProgressBar;

import com.alium.soundcloudplayer.R;
import com.alium.soundcloudplayer.ui.mvp.IPodcastPlayerContracts;

/**
 * Created by abdulmujibaliu on 9/27/17.
 */

public abstract class BaseLibraryChildFragment extends Fragment {

    protected final String TAG = getClass().getSimpleName();

    protected IPodcastPlayerContracts.PodcastPlayerView mParentFragment;
    protected ProgressBar progressBar;
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    public void onAttachToParentFragment(Fragment fragment) {
        try {
            mParentFragment = (IPodcastPlayerContracts.PodcastPlayerView) fragment;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    fragment.toString() + " must implement OnPlayerSelectionSetListener");
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onAttachToParentFragment(getParentFragment());
    }

    protected void showLoading(){
        progressBar.setVisibility(View.VISIBLE);
    }

    protected void hideLoading(){
        progressBar.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public abstract void initData();

    public  void initView(View rootView){
        this.progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        this.mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeContainer);
    }
}
