package com.aliumujib.majlis.mkanreport.app;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.alium.mkan_report_data.constants.Constants;
import com.aliumujib.majlis.mkanreport.utils.SharedHelper;
import com.parse.Parse;
import com.parse.ParseInstallation;

import butterknife.ButterKnife;
import in.myinnos.customfontlibrary.TypefaceUtil;

public class BaseApplication extends MultiDexApplication {

    protected static BaseApplication instance;
    protected static  String TAG = BaseApplication.class.getSimpleName();
    private SharedHelper mAppSharedPrefHelper;

    public static BaseApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        reInitPArse(instance);

        //TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/raleway-regular.ttf");

        ButterKnife.setDebug(true);
    }

    public static Context getContext(){
        return getInstance();
    }


    private static void reInitPArse(Context context) {
        Parse.initialize(new Parse.Configuration.Builder(context)
                .applicationId("cOQnuaZtNny7A9frIGyFQ4CBocOQGiTbUVBX3jEM")
                .clientKey("hC0ktOlFf4zpzAtaILFsGtyOmZMs6wLTmQ4psKVY")
                .server("https://parseapi.back4app.com/").enableLocalDataStore()
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