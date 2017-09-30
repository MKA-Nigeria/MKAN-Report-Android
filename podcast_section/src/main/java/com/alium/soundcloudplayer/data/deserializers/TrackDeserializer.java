package com.alium.soundcloudplayer.data.deserializers;

import com.alium.soundcloudplayer.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import com.alium.soundcloudplayer.data.models.Track;
import com.alium.soundcloudplayer.network.WSConstants;


/**
 * Created by Abdul-Mujeeb Aliu on 21-9-2017
 * <p>
 * TrackDeserializer will be used to map the JSON to the defined Track model
 */
public class TrackDeserializer implements JsonDeserializer<Track> {


    @Override
    public Track deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject data = json.getAsJsonObject();
        if (data != null && !data.isJsonNull()) {
            Track track = new Gson().fromJson(data, Track.class);
            track.setOwner(findOwner(data));
            track.setImageUrl(getBigArtwork(data));
            track.setDownloadUrl(updateAuthUrl(data, WSConstants.KEY_DOWNLOAD_URL));
            track.setStreamUrl(updateAuthUrl(data, WSConstants.KEY_STREAM_URL));
            return track;
        }
        return null;
    }

    /**
     * Updates the URL as value with the API KEY as query, so that the URL can be requested
     *
     * @param data json
     * @param key  json key
     * @return URL
     */
    private String updateAuthUrl(JsonObject data, String key) {
        JsonElement obj = data.get(key);
        if (obj != null && !obj.isJsonNull()) {
            return obj.getAsString() + WSConstants.QUERY_API_KEY;
        }
        return null;
    }

    /**
     * Updates the image url to the biggest format
     *
     * @param data json
     * @return image url
     */
    private String getBigArtwork(JsonObject data) {
        JsonElement obj = data.get(WSConstants.KEY_ARTWORK_URL);
        if (obj != null && !obj.isJsonNull()) {
            return obj.getAsString().replace("large", "t500x500");
        }
        return null;
    }

    /**
     * Gets the username from the owner object
     *
     * @param data json
     * @return owner username
     */
    private String findOwner(JsonObject data) {
        JsonObject obj = data.get(WSConstants.KEY_USER).getAsJsonObject();
        if (obj != null && !obj.isJsonNull()) {
            return obj.get(WSConstants.KEY_USERNAME).getAsString();
        }
        return null;
    }
}
