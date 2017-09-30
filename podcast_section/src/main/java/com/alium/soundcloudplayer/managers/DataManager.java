package com.alium.soundcloudplayer.managers;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import com.alium.soundcloudplayer.network.NetworkHandler;


/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 * <p>
 * The DataManager is used to get the needed data
 */
public class DataManager {

    public static final String MKAN_NG = "204709701";
    public static final String VOICE_OF_ISLAM = "182328357";

    public DataManager() {
    }

    /**
     * Get music from SoundCloud from a user
     *
     * @param userId     SoundCloud userId
     * @param subscriber subscriber to receive tracks
     * @return Subscription
     */
    public void getMusic(String userId, Observer<List<Track>> subscriber) {
        NetworkHandler.getInstance().getSoundCloudService().getTracks(userId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }


    public Observable<List<Track>> getAllPodcasts() {
        return Observable.zip(NetworkHandler.getInstance().getSoundCloudService().getTracks(MKAN_NG), NetworkHandler.getInstance().getSoundCloudService().getTracks(VOICE_OF_ISLAM), new BiFunction<List<Track>, List<Track>, List<Track>>() {

            @Override
            public List<Track> apply(List<Track> tracks, List<Track> tracks2) throws Exception {

                List<Track> totalList = new ArrayList<>();
                totalList.addAll(tracks);
                totalList.addAll(tracks2);

                return totalList;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
        //.subscribe(subscriber);
    }



    public Observable<List<Playlist>> getAllPlayLists() {
        return Observable.zip(NetworkHandler.getInstance().getSoundCloudService().getPlayLists(MKAN_NG), NetworkHandler.getInstance().getSoundCloudService().getPlayLists(VOICE_OF_ISLAM), new BiFunction<List<Playlist>, List<Playlist>, List<Playlist>>() {

            @Override
            public List<Playlist> apply(List<Playlist> playlist1, List<Playlist> playlist2) throws Exception {

                List<Playlist> totalList = new ArrayList<>();
                totalList.addAll(playlist1);
                totalList.addAll(playlist2);

                return totalList;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
        //.subscribe(subscriber);
    }
}
