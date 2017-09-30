package com.alium.soundcloudplayer.ui.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import com.alium.soundcloudplayer.R;
import com.alium.soundcloudplayer.data.models.Track;
import com.alium.soundcloudplayer.ui.adapters.TracksRecyclerViewAdapter;


/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 */

public class TrackListFragment extends BaseLibraryChildFragment {

    private TracksRecyclerViewAdapter mAdapter;

    public TrackListFragment() {
    }

    public static TrackListFragment newInstance() {
        TrackListFragment fragment = new TrackListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_track_list, container, false);
        initViews(rootView);
        initData();
        return rootView;
    }

    @Override
    public void initData() {
        showLoading();
        loadTracks();
    }

    private void initViews(View rootView) {
        super.initView(rootView);
        this.mAdapter = new TracksRecyclerViewAdapter();

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadTracks();
            }
        });
        mAdapter.setOnTrackClickListener(new TracksRecyclerViewAdapter.OnTrackClickListener() {
            @Override
            public void onTrackClick(int position, Track track, View sharedImage) {
                mParentFragment.playPodCast(position, track);
            }
        });
    }


    public void loadTracks() {
        mParentFragment.getPresenter().getAllPodcasts().subscribe(new Observer<List<Track>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                hideLoadingIndicators();
            }

            @Override
            public void onError(Throwable e) {
                hideLoadingIndicators();
                String errorMsg = "Loading tracks went wrong";
                Log.e(TAG, errorMsg, e);
                Toast.makeText(getContext(), errorMsg, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(List<Track> tracks) {
                mAdapter.clearTracks();
                mAdapter.addTracks(tracks);
            }
        });
    }


    private void hideLoadingIndicators() {
        hideLoading();
    }
}
