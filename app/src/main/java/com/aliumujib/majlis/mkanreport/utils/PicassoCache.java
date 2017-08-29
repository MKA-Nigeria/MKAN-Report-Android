package com.aliumujib.majlis.mkanreport.utils;

/**
 * Created by Abdul-Mujeeb Aliu on 11/6/2015.
 */

import android.content.Context;
import android.net.Uri;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class PicassoCache {

    private static Picasso picassoInstance = null;

    private PicassoCache(Context context) {

        Downloader downloader = new OkHttpDownloader(context, Integer.MAX_VALUE);
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse.newBuilder().header("Cache-Control", "max-age=" + (60 * 60 * 24 * 365)).build();
            }
        });

        okHttpClient.setCache(new Cache(context.getCacheDir(), Integer.MAX_VALUE));
        OkHttpDownloader okHttpDownloader = new OkHttpDownloader(okHttpClient);

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                exception.printStackTrace();
            }
        });

        builder.downloader(okHttpDownloader);
        picassoInstance = builder.build();
        picassoInstance.setLoggingEnabled(true);
    }

    public static Picasso getPicassoInstance(Context context) {

        if (picassoInstance == null) {

            new PicassoCache(context);
            return picassoInstance;
        }

        return picassoInstance;
    }

}