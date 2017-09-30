package com.alium.soundcloudplayer.network;

import java.util.List;

import io.reactivex.Observable;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 *
 * Interface to get data from SoundCloud that will be used by Retrofit2
 */
public interface SoundCloudService {

    @GET(WSConstants.USERS_ENDPOINT + "{userId}/" + WSConstants.TRACKS_ENDPOINT)
    Observable<List<Track>> getTracks(@Path("userId") String userId);


    @GET(WSConstants.USERS_ENDPOINT + "{userId}/" + WSConstants.PLAY_LIST_ENDPOINT)
    Observable<List<Playlist>> getPlayLists(@Path("userId") String userId);

}
