package com.alium.soundcloudplayer.ui.fragments.tracklist;

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
import com.alium.soundcloudplayer.ui.fragments.base.BaseLibraryChildFragment;


/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 */

public class TrackListFragment extends BaseLibraryChildFragment implements TrackListContracts.TrackListView {

    private TracksRecyclerViewAdapter mAdapter;
    private TrackListContracts.TrackListPresenter presenter;

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

        setPresenter(new TrackListPresenter(this, dataManager, parentView));

        presenter.onCreate();

        return rootView;
    }


    private void initViews(View rootView) {
        super.initView(rootView);
        this.mAdapter = new TracksRecyclerViewAdapter();

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getAllTracks();
            }
        });
        mAdapter.setOnTrackClickListener(new TracksRecyclerViewAdapter.OnTrackClickListener() {
            @Override
            public void onTrackClick(int position, Track track, View sharedImage) {
                presenter.playTrack(position, track);
            }
        });
    }



    @Override
    public void setPresenter(TrackListContracts.TrackListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setData(List<Track> tracks) {
        mAdapter.clearTracks();
        mAdapter.addTracks(tracks);
    }

    @Override
    public void addMoreTracks(List<Track> tracks) {

    }
}
