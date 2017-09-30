package com.alium.soundcloudplayer.ui.mvp;

import java.util.List;

import io.reactivex.Observable;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;

/**
 * Created by abdulmujibaliu on 9/26/17.
 */

public interface IPodcastPlayerContracts {

    interface PodcastPlayerPresenter {

        void playPodCast(int position, Track track);

        Observable<List<Track>> getAllPodcasts();

        Observable<List<Playlist>> getAllPlayLists();

    }

    interface PodcastPlayerView {

        PodcastPlayerPresenter getPresenter();

        void playPodCast(int position, Track track);
    }
}
