package com.alium.soundcloudplayer.network;

import com.alium.soundcloudplayer.BuildConfig;

/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 * <p>
 * All constants that will be used for web services
 */
public class PodcastModuleConstants {
    public static final String BASE_URL = "https://api.soundcloud.com/";
    public static final String USERS_ENDPOINT = "users/";
    public static final String TRACKS_ENDPOINT = "tracks/";
    public static final String PLAY_LIST_ENDPOINT = "playlists/";
    public static final String CLIENT_ID_QUERY = "client_id";

    public static final String KEY_USER = "user";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_ARTWORK_URL = "artwork_url";
    public static final String KEY_STREAM_URL = "stream_url";
    public static final String KEY_DOWNLOAD_URL = "download_url";

    public static final String KEY_TRACKS = "tracks";

    public static final String QUERY_API_KEY = "?" + PodcastModuleConstants.CLIENT_ID_QUERY + "=" + BuildConfig.SOUNDCLOUD_API_KEY;
    public static final String PAGE_LIMIT = "limit";
}
