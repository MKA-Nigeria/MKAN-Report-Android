package com.alium.soundcloudplayer.network;

import com.alium.soundcloudplayer.data.deserializers.PlaylistDeserializer;
import com.alium.soundcloudplayer.data.models.Playlist;
import com.aliumujib.mkanapps.coremodule.utils.BaseNetworkHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.alium.soundcloudplayer.BuildConfig;
import com.alium.soundcloudplayer.data.deserializers.TrackDeserializer;
import com.alium.soundcloudplayer.data.models.Track;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 *
 * The NetworkHandler is a singleton and will setup the needed stuff to make network requests.
 * Settings as logging, interceptors
 */
public class NetworkHandler extends BaseNetworkHandler{
    /*************************************
     * VARIABLES
     *************************************/

    private static NetworkHandler networkHandler;

    private SoundCloudService soundCloudService;

    /*************************************
     * SINGLETON
     *************************************/

    public static NetworkHandler getInstance() {
        if (networkHandler == null) {
            networkHandler = new NetworkHandler();
        }
        return networkHandler;
    }

    public NetworkHandler() {

    }

    /*************************************
     * PUBLIC METHODS
     *************************************/

    public SoundCloudService getSoundCloudService() {
        if (soundCloudService == null) {
            initService();
        }
        return soundCloudService;
    }


    @Override
    protected void initVariables() {
        this.soundCloudService = getRetrofit().create(SoundCloudService.class);
    }

    @Override
    protected Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(Track.class, new TrackDeserializer())
                .registerTypeAdapter(Playlist.class, new PlaylistDeserializer())
                .create();
    }

    @Override
    protected String getBaseURL() {
        return PodcastModuleConstants.BASE_URL;
    }

    protected Interceptor createApiKeyQueryInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter(PodcastModuleConstants.CLIENT_ID_QUERY,
                                BuildConfig.SOUNDCLOUD_API_KEY)
                        .addQueryParameter(PodcastModuleConstants.PAGE_LIMIT, String.valueOf(200))
                        .build();
                return chain.proceed(original.newBuilder().url(url).build());
            }
        };
    }

}
