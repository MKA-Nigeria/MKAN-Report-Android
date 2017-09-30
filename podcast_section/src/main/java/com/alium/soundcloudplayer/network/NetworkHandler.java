package com.alium.soundcloudplayer.network;

import com.alium.soundcloudplayer.data.deserializers.PlaylistDeserializer;
import com.alium.soundcloudplayer.data.models.Playlist;
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
public class NetworkHandler {
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

    /*************************************
     * PRIVATE METHODS
     *************************************/

    private void initService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(createApiKeyQueryInterceptor())
                .addInterceptor(createLoggingInterceptor())
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Track.class, new TrackDeserializer())
                .registerTypeAdapter(Playlist.class, new PlaylistDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WSConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        this.soundCloudService = retrofit.create(SoundCloudService.class);
    }

    private Interceptor createApiKeyQueryInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter(WSConstants.CLIENT_ID_QUERY,
                                BuildConfig.SOUNDCLOUD_API_KEY)
                        .addQueryParameter(WSConstants.PAGE_LIMIT, String.valueOf(200))
                        .build();
                return chain.proceed(original.newBuilder().url(url).build());
            }
        };
    }

    private HttpLoggingInterceptor createLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return interceptor;
    }
}
