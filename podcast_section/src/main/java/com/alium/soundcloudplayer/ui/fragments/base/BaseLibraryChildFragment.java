package com.alium.soundcloudplayer.ui.fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ProgressBar;

import com.alium.soundcloudplayer.R;
import com.alium.soundcloudplayer.repositories.SoundCloudRepository;
import com.alium.soundcloudplayer.ui.fragments.parent.IPodcastPlayerContracts;
import com.aliumujib.mkanapps.coremodule.base.BaseFragment;

/**
 * Created by abdulmujibaliu on 9/27/17.
 */

public abstract class BaseLibraryChildFragment extends BaseFragment {

    protected final String TAG = getClass().getSimpleName();

    protected IPodcastPlayerContracts.PodcastPlayerView parentView;
    protected ProgressBar progressBar;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected SoundCloudRepository soundCloudRepository = new SoundCloudRepository();

    public void onAttachToParentFragment(Fragment fragment) {
        try {
            parentView = (IPodcastPlayerContracts.PodcastPlayerView) fragment;

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

    public void showLoading(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideLoading(){
        progressBar.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public  void initView(View rootView){
        this.progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        this.mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeContainer);
    }
}
