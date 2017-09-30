package com.alium.soundcloudplayer.ui.mvp;

import java.util.List;

import io.reactivex.Observable;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import com.alium.soundcloudplayer.managers.DataManager;

/**
 * Created by abdulmujibaliu on 9/27/17.
 */

public class PodcastPlayerPresenter implements IPodcastPlayerContracts.PodcastPlayerPresenter {

    DataManager mDataManager = new DataManager();
    private IPodcastPlayerContracts.PodcastPlayerView mPodcastPlayerView;

    public PodcastPlayerPresenter(IPodcastPlayerContracts.PodcastPlayerView podcastPlayerView) {
        this.mPodcastPlayerView = podcastPlayerView;
    }

    @Override
    public void playPodCast(int position, Track track) {
        mPodcastPlayerView.playPodCast(position, track);
    }

    @Override
    public Observable<List<Track>> getAllPodcasts() {
        return mDataManager.getAllPodcasts();
    }

    @Override
    public Observable<List<Playlist>> getAllPlayLists() {
        return mDataManager.getAllPlayLists();
    }
}
