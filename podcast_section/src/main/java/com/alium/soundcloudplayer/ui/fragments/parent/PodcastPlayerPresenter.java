package com.alium.soundcloudplayer.ui.fragments.parent;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import com.alium.soundcloudplayer.managers.DataManager;
import com.aliumujib.jean.podplayer.JcAudio;

/**
 * Created by abdulmujibaliu on 9/27/17.
 */

public class PodcastPlayerPresenter implements IPodcastPlayerContracts.PodcastPlayerPresenter {

    private DataManager dataManager = new DataManager();
    private IPodcastPlayerContracts.PodcastPlayerView mPodcastPlayerView;

    public PodcastPlayerPresenter(IPodcastPlayerContracts.PodcastPlayerView podcastPlayerView) {
        this.mPodcastPlayerView = podcastPlayerView;
    }

    @Override
    public void playPodCast(int position, Track track) {
        mPodcastPlayerView.playPodCast(position, track);
    }

    @Override
    public void onCreate() {
        mPodcastPlayerView.initPlayerTracks(new ArrayList<JcAudio>());
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}
