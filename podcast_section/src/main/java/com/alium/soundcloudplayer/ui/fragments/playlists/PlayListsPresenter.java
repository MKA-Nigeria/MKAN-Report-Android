package com.alium.soundcloudplayer.ui.fragments.playlists;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import com.alium.soundcloudplayer.managers.DataManager;
import com.alium.soundcloudplayer.ui.fragments.parent.IPodcastPlayerContracts;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by aliumujib on 25/02/2018.
 */

public class PlayListsPresenter implements PlayListsContracts.PlayListsPresenter {


    private final PlayListsContracts.PlayListsView view;
    private final IPodcastPlayerContracts.PodcastPlayerView parentView;
    private DataManager dataManager;

    public PlayListsPresenter(PlayListsContracts.PlayListsView view, IPodcastPlayerContracts.PodcastPlayerView parentView, DataManager dataManager) {

        this.view = view;
        this.parentView = parentView;
        this.dataManager = dataManager;
    }

    @Override
    public void onCreate() {
        this.getAllPlayLists();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void getAllPlayLists() {
        dataManager.getAllPlayLists().subscribe(new Consumer<List<Playlist>>() {
            @Override
            public void accept(List<Playlist> playlists) throws Exception {
                view.setData(playlists);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                view.showMessage(throwable.getMessage());
            }
        });
    }

    @Override
    public void playTrack(int position, Track track) {
        parentView.playPodCast(position, track);
    }



}
