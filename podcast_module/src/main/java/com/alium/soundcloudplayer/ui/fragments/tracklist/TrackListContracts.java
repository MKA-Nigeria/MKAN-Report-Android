package com.alium.soundcloudplayer.ui.fragments.tracklist;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import com.aliumujib.mkanapps.coremodule.basemvpcontracts.BaseContracts;

import java.util.List;

/**
 * Created by aliumujib on 25/02/2018.
 */

public interface TrackListContracts {

    interface TrackListPresenter extends BaseContracts.BasePresenter {

        void getAllTracks();

        void playTrack(int position, Track track);

    }


    interface TrackListView extends BaseContracts.BaseView<TrackListPresenter> {

        void setData(List<Track> playlists);

        void addMoreTracks(List<Track> playlists);

    }
}
