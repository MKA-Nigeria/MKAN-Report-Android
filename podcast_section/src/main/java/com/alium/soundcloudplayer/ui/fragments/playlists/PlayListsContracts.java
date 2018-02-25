package com.alium.soundcloudplayer.ui.fragments.playlists;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import com.aliumujib.mkanapps.coremodule.basemvpcontracts.BaseContracts;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by aliumujib on 25/02/2018.
 */

public interface PlayListsContracts {

    interface PlayListsPresenter extends BaseContracts.BasePresenter {

        void getAllPlayLists();

        void playTrack(int position, Track track);

    }


    interface PlayListsView extends BaseContracts.BaseView<PlayListsPresenter> {

        void setData(List<Playlist> playlists);

        void addMorePlayLists(List<Playlist> playlists);

    }
}
