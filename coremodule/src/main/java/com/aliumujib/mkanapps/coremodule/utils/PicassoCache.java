package com.aliumujib.mkanapps.coremodule.utils;

/**
 * Created by Abdul-Mujeeb Aliu on 11/6/2015.
 */

import android.content.Context;


import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;


public class PicassoCache {

    private static Picasso picassoInstance = null;

    private PicassoCache(Context context) {

        Cache cache = new Cache(new File(context.getCacheDir(), "http-cache"), 10 * 1024 * 1024);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(provideCacheInterceptor())
                .cache(cache)
                .build();

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.listener((picasso, uri, exception) -> exception.printStackTrace());

        Downloader downloader = new OkHttp3Downloader(okHttpClient);


        builder.downloader(downloader);
        picassoInstance = builder.build();
        picassoInstance.setLoggingEnabled(true);
    }

    Interceptor provideCacheInterceptor () {
        return new Interceptor() {
            @Override
            public Response intercept (Interceptor.Chain chain) throws IOException {
                Response response = chain.proceed( chain.request() );
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxAge( 2, TimeUnit.MINUTES )
                        .build();

                return response.newBuilder()
                        .header("Cache-Control", cacheControl.toString() )
                        .build();
            }
        };
    }

    public static Picasso getPicassoInstance(Context context) {

        if (picassoInstance == null) {

            new PicassoCache(context);
            return picassoInstance;
        }

        return picassoInstance;
    }

}