package com.aliumujib.mkanapps.coremodule.utils;


import com.aliumujib.mkanapps.BuildConfig;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 * <p>
 */

public abstract class BaseNetworkHandler {

    private Retrofit retrofit;

    /*************************************
     * INIT METHODS
     *************************************/

    protected void initService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(createApiKeyQueryInterceptor())
                .addInterceptor(createLoggingInterceptor())
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(getBaseURL())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .client(client)
                .build();

        initVariables();
    }

    /*************************************
     * VARIABLES
     *************************************/


    /*************************************
     * ABSTRACT METHODS
     *************************************/
    protected abstract void initVariables();

    protected abstract Gson getGson();

    protected abstract String getBaseURL();

    protected abstract Interceptor createApiKeyQueryInterceptor();

    private HttpLoggingInterceptor createLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return interceptor;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
