package com.alium.soundcloudplayer.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdulmujibaliu on 9/27/17.
 */

public class Playlist {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("created_at")
    private String date;

    @SerializedName("duration")
    private long durationInMilli;

    private String owner;

    @SerializedName("track_count")
    private int trackCount;

    @SerializedName("user_id")
    private int userID;

    @SerializedName("artwork_url")
    private String imageUrl;

    List<Track> trackList = new ArrayList<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getDurationInMilli() {
        return durationInMilli;
    }

    public void setDurationInMilli(long durationInMilli) {
        this.durationInMilli = durationInMilli;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }
}
