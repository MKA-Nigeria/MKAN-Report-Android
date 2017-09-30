package com.alium.soundcloudplayer.data.deserializers;

import android.util.Log;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import com.alium.soundcloudplayer.network.WSConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdulmujibaliu on 9/27/17.
 */

public class PlaylistDeserializer implements JsonDeserializer<Playlist> {

    private String TAG = getClass().getSimpleName();

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


    private List<Track> findTrackList(JsonObject data) {
        JsonArray jsonArray = data.get(WSConstants.KEY_TRACKS).getAsJsonArray();
        if (jsonArray != null && !jsonArray.isJsonNull() && !(jsonArray.size() == 0)) {
            List<Track> trackList = new ArrayList<>();
            for (JsonElement jsonObject : jsonArray) {
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Track.class, new TrackDeserializer()).create();
                Track track = gson.fromJson(jsonObject, Track.class);
                trackList.add(track);
            }
            return trackList;
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


    @Override
    public Playlist deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject data = json.getAsJsonObject();

        if (data != null && !data.isJsonNull()) {
            Playlist playlist = new Gson().fromJson(data, Playlist.class);
            playlist.setOwner(findOwner(data));
            playlist.setTrackList(findTrackList(data));
            playlist.setImageUrl(getBigArtwork(data));
            return playlist;
        }
        return null;
    }
}
