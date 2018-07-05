package com.aliumujib.mkanmedia.app;

import com.aliumujib.mkanapps.coremodule.app.BaseApplication;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by ABDUL-MUJEEB ALIU on 09/12/2017.
 */

public class MediaApplication extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();

      initCrashlytics();
    }


    protected void initCrashlytics() {
        Fabric.with(this, new Crashlytics());
    }

}
