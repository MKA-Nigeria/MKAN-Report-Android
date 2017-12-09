package com.aliumujib.majlis.mkan_report_app.app;

import com.aliumujib.mkanapps.coremodule.app.BaseApplication;

import butterknife.ButterKnife;

/**
 * Created by ABDUL-MUJEEB ALIU on 08/12/2017.
 */

public class ReportApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        ButterKnife.setDebug(true);
    }
}
