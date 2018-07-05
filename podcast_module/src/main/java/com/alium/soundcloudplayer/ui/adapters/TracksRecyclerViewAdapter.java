package com.alium.soundcloudplayer.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import com.alium.soundcloudplayer.R;
import com.alium.soundcloudplayer.data.models.Track;

/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 */


public class TracksRecyclerViewAdapter extends RecyclerView.Adapter<TracksRecyclerViewAdapter.BaseVH> {

    private final List<Track> mTracks;
    private OnTrackClickListener onTrackClickListener;
    private String TAG = getClass().getSimpleName();

    private static final int SHUFFLE_BUTTON = 0;
    private static final int SONG = 1;

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? SHUFFLE_BUTTON : SONG;
    }

    public TracksRecyclerViewAdapter() {
        this.mTracks = new ArrayList<>();
    }

    public void addTracks(List<Track> tracks) {
        this.mTracks.addAll(tracks);
        notifyDataSetChanged();
    }

    public void clearTracks() {
        mTracks.clear();
        notifyDataSetChanged();
    }

    @Override
    public BaseVH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SHUFFLE_BUTTON) {
            Log.d(TAG, "IS SHUFFLE_BUTTON");
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_shuffle_header, parent, false);
            return new BaseVH(view);
        } else {
            Log.d(TAG, "IS SONG");
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_track_card, parent, false);
            return new ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(BaseVH holder, int position) {
        if (position == 0) {

        } else {
            Track track = mTracks.get(position - 1);
//            Log.d(TAG, track.getStreamUrl());
            ((ViewHolder) holder).bindTrack(track);
        }
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public void setOnTrackClickListener(OnTrackClickListener onTrackClickListener) {
        this.onTrackClickListener = onTrackClickListener;
    }

    public class BaseVH extends RecyclerView.ViewHolder {

        public BaseVH(View itemView) {
            super(itemView);
        }

    }

    public class ViewHolder extends BaseVH implements View.OnClickListener {


        View longSeperator;
        ImageView iconImage;
        TextView titleText, subTitleText;

        public ViewHolder(View view) {
            super(view);

            longSeperator = view.findViewById(R.id.long_separator);
            iconImage = (ImageView) view.findViewById(R.id.track_card_thumbnail);
            titleText = (TextView) view.findViewById(R.id.track_card_title);
            subTitleText = (TextView) view.findViewById(R.id.item_view_user__description);

        }

        public void bindShuffle() {
            longSeperator.setVisibility(View.VISIBLE);
        }

        public void bindTrack(Track track) {
            longSeperator.setVisibility(View.GONE);
            subTitleText.setText(track.getOwner() + ", " + track.getDownloadCount() + " downloads" + ", " + track.getPlayCount() + " plays ");
            Picasso.with(itemView.getContext()).load(track.getImageUrl()).into(iconImage);
            titleText.setText(track.getTitle());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onTrackClickListener != null) {
                Track Track = mTracks.get(getAdapterPosition() -1);
                onTrackClickListener.onTrackClick(getAdapterPosition(), Track, iconImage);
            }
        }
    }

    public interface OnTrackClickListener {

        void onTrackClick(int position, Track track, View sharedImage);

    }
}
