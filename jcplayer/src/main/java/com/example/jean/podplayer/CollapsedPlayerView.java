package com.example.jean.podplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by abdulmujibaliu on 9/27/17.
 */

public class CollapsedPlayerView extends RelativeLayout {

    private  View mRootView;
    private  ImageView mCurrentAudioImage;
    private  ProgressBar mProgress;
    private  TextView mAudioName;
    private  TextView mArtistName;


    public CollapsedPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mRootView = inflater.inflate(R.layout.bottom_nowplaying_card, this, true);


        mCurrentAudioImage = (ImageView) mRootView.findViewById(R.id.album_art_nowplayingcard);
        mProgress = (ProgressBar) mRootView.findViewById(R.id.song_progress_normal);
        mAudioName = (TextView) mRootView.findViewById(R.id.title);
        mArtistName = (TextView) mRootView.findViewById(R.id.artist);
    }


    public void setCurrentTrack(JcAudio jcAudio) {
        Picasso.with(getContext()).load(jcAudio.getArtURL()).fit().centerCrop().into(mCurrentAudioImage);
        mProgress.setProgress(0);
        mAudioName.setText(jcAudio.getTitle());
        mArtistName.setText(jcAudio.getSubTitle());
    }


    public void updateProgress(JcAudio jcAudio, int progress) {
        mProgress.setProgress(progress);
    }
}
