package com.aliumujib.mkanapps.coremodule.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.alium.mkan_report_data.constants.Constants;


public class CoreSharedHelper {

    protected final SharedPreferences sharedPreferences;
    protected final SharedPreferences.Editor sharedPreferencesEditor;

    private static CoreSharedHelper instance;

    public static CoreSharedHelper getInstance() {
        if (instance == null) {
            throw new NullPointerException("CoreSharedHelper was not initialized!");
        }
        return instance;
    }

    public CoreSharedHelper(Context context) {
        instance = this;
        sharedPreferences = context.getSharedPreferences(Constants.NAME, Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();
    }

    protected void delete(String key) {
        if (sharedPreferences.contains(key)) {
            sharedPreferencesEditor.remove(key).commit();
        }
    }

    protected void savePref(String key, Object value) {
        delete(key);

        if (value instanceof Boolean) {
            sharedPreferencesEditor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            sharedPreferencesEditor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            sharedPreferencesEditor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            sharedPreferencesEditor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            sharedPreferencesEditor.putString(key, (String) value);
        } else if (value instanceof Enum) {
            sharedPreferencesEditor.putString(key, value.toString());
        } else if (value != null) {
            throw new RuntimeException("Attempting to save non-primitive preference");
        }

        sharedPreferencesEditor.commit();
    }

    protected <T> T getPref(String key) {
        return (T) sharedPreferences.getAll().get(key);
    }

    protected <T> T getPref(String key, T defValue) {
        T returnValue = (T) sharedPreferences.getAll().get(key);
        return returnValue == null ? defValue : returnValue;
    }

    public void clearAll() {
        sharedPreferencesEditor.clear();
    }

    public int getUserId() {
        return getPref(Constants.USER_ID, 0);
    }

    public void saveUserId(int id) {
        savePref(Constants.USER_ID, id);
    }

    public String getUserEmail() {
        return getPref(Constants.USER_EMAIL, null);
    }

    public void saveUserEmail(String email) {
        savePref(Constants.USER_EMAIL, email);
    }

    public String getUserPassword() {
        return getPref(Constants.USER_PASSWORD, null);
    }

    public void saveUserPassword(String password) {
        savePref(Constants.USER_PASSWORD, password);
    }

    public String getUserFullName() {
        return getPref(Constants.USER_FULL_NAME, null);
    }

    public void saveUserFullName(String fullName) {
        savePref(Constants.USER_FULL_NAME, fullName);
    }

    public void clearUserData() {
        saveUserId(0);
        saveUserEmail(null);
        saveUserPassword(null);
        saveUserFullName(null);
    }

}