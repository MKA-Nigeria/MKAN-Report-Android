package com.alium.soundcloudplayer.ui.fragments.parent;

import java.util.List;

import io.reactivex.Observable;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import com.aliumujib.jean.podplayer.JcAudio;
import com.aliumujib.mkanapps.coremodule.basemvpcontracts.BaseContracts;

/**
 * Created by abdulmujibaliu on 9/26/17.
 */

public interface IPodcastPlayerContracts {

    interface PodcastPlayerPresenter extends BaseContracts.BasePresenter {

        void playPodCast(int position, Track track);


    }

    interface PodcastPlayerView extends BaseContracts.BaseView<PodcastPlayerPresenter> {

        void playPodCast(int position, Track track);

        void initPlayerTracks(List<JcAudio> audios);
    }
}
