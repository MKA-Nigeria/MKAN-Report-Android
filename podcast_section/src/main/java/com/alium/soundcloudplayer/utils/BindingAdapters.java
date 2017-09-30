package com.alium.soundcloudplayer.utils;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import com.alium.soundcloudplayer.R;

/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 */

public class BindingAdapters {

    /**
     * Bind image (by XML files) without any placeholder or fallback image
     */
    @BindingAdapter("bind:imageUrlSimple")
    public static void loadSimpleImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(imageView.getContext()).load(url).into(imageView);
        }
    }

    /**
     * Bind image (by XML files) with placeholder and fallback image
     */
    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder).into(imageView);
    }
}