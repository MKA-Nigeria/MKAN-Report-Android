package com.aliumujib.majlis.mkanreport.app;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.alium.mkan_report_data.constants.Constants;
import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.utils.SharedHelper;
import com.crashlytics.android.Crashlytics;
import com.parse.Parse;
import com.parse.ParseInstallation;

import butterknife.ButterKnife;
import in.myinnos.customfontlibrary.TypefaceUtil;
import io.fabric.sdk.android.Fabric;

public class BaseApplication extends MultiDexApplication {

    protected static BaseApplication instance;
    protected static String TAG = BaseApplication.class.getSimpleName();
    private SharedHelper mAppSharedPrefHelper;

    public static BaseApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        instance = this;
        reInitPArse(instance);

        //TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/raleway-regular.ttf");

        ButterKnife.setDebug(true);
    }

    public static Context getContext() {
        return getInstance();
    }

    private void reInitPArse(Context context) {
        Parse.initialize(new Parse.Configuration.Builder(context)
                .applicationId(getString(R.string.parse_application_id))
                .clientKey(getString(R.string.parse_client_secret))
                .server(getString(R.string.parse_server_url)).enableLocalDataStore()
                .build()
        );

        Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);

        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(Constants.USER_PASSWORD, "USER");
        installation.saveInBackground(e -> {
            if (e == null) {
                Log.d(TAG, "Success saving install");
            } else {
                e.printStackTrace();
                Log.d(TAG, e.getLocalizedMessage());
            }
        });

    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    public synchronized SharedHelper getmAppSharedPrefHelper() {
        return mAppSharedPrefHelper == null
                ? mAppSharedPrefHelper = new SharedHelper(this)
                : mAppSharedPrefHelper;
    }


    public BaseApplication() {
        super();
    }
}