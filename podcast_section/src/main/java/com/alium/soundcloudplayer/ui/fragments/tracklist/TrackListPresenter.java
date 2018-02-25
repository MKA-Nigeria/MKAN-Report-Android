package com.alium.soundcloudplayer.ui.fragments.tracklist;

import com.alium.soundcloudplayer.data.models.Track;
import com.alium.soundcloudplayer.repositories.SoundCloudRepository;
import com.alium.soundcloudplayer.ui.fragments.parent.IPodcastPlayerContracts;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by aliumujib on 25/02/2018.
 */

public class TrackListPresenter implements TrackListContracts.TrackListPresenter {

    private final TrackListContracts.TrackListView view;
    private final SoundCloudRepository soundCloudRepository;
    private final IPodcastPlayerContracts.PodcastPlayerView parentView;

    public TrackListPresenter(TrackListContracts.TrackListView view, SoundCloudRepository soundCloudRepository, IPodcastPlayerContracts.PodcastPlayerView parentView) {

        this.view = view;
        this.soundCloudRepository = soundCloudRepository;
        this.parentView = parentView;

    }

    @Override
    public void getAllTracks() {
        view.showLoading();
        soundCloudRepository.getAllPodcasts().subscribe(new Consumer<List<Track>>() {
            @Override
            public void accept(List<Track> tracks) throws Exception {
                view.hideLoading();
                view.setData(tracks);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                view.hideLoading();
                view.showError();
                view.showMessage(throwable.getMessage());
            }
        });
    }

    @Override
    public void playTrack(int position, Track track) {
        parentView.playPodCast(position, track);
    }

    @Override
    public void onCreate() {
        getAllTracks();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}
