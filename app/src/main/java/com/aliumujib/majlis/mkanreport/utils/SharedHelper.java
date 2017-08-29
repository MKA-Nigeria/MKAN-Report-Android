package com.aliumujib.majlis.mkanreport.utils;

import android.content.Context;

import com.alium.mkan_report_data.constants.Constants;


public class SharedHelper extends CoreSharedHelper {


    public SharedHelper(Context context) {
        super(context);
    }

    public boolean isShownUserAgreement() {
        return getPref(Constants.USER_AGREEMENT, false);
    }

    public void saveShownUserAgreement(boolean save) {
        savePref(Constants.USER_AGREEMENT, save);
    }

    public boolean isSavedRememberMe() {
        return getPref(Constants.REMEMBER_ME, false);
    }

    public void saveSavedRememberMe(boolean save) {
        savePref(Constants.REMEMBER_ME, save);
    }

    public boolean isEnablePushNotifications() {
        return getPref(Constants.ENABLING_PUSH_NOTIFICATIONS, true);
    }

    public void saveEnablePushNotifications(boolean enable) {
        savePref(Constants.ENABLING_PUSH_NOTIFICATIONS, enable);
    }

    public boolean getEnableFriendsSwitch() {
        return getPref(Constants.SHOW_ONLY_FRIENDS, false);
    }

    public void saveEnableFriendsSwitch(boolean enable) {
        savePref(Constants.SHOW_ONLY_FRIENDS, enable);
    }

    public boolean getDiscoverEnabledSwitch() {
        return getPref(Constants.DISCOVER_ENABLED, false);
    }

    public void saveDiscoverEnabledSwitch(boolean enable) {
        savePref(Constants.DISCOVER_ENABLED, enable);
    }
}