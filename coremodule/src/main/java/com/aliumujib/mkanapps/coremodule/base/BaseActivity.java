package com.aliumujib.mkanapps.coremodule.base;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RemoteViews;


import com.aliumujib.mkanapps.R;
import com.aliumujib.mkanapps.coremodule.app.BaseApplication;
import com.aliumujib.mkanapps.coremodule.basemvpcontracts.IBaseView;
import com.aliumujib.mkanapps.coremodule.utils.DialogUtils;
import com.aliumujib.mkanapps.coremodule.utils.SharedHelper;
import com.aliumujib.mkanapps.coremodule.utils.ToastUtils;
import com.aliumujib.mkanapps.coremodule.utils.Utils;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.yayandroid.locationmanager.LocationBaseActivity;
import com.yayandroid.locationmanager.LocationConfiguration;
import com.yayandroid.locationmanager.constants.FailType;
import com.yayandroid.locationmanager.constants.ProviderType;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseActivity extends LocationBaseActivity implements IBaseView {

    public SharedHelper mSharedHelperInstance;
    public ParseUser mCurrentParseUser;
    public Context mContext;
    public static ParseGeoPoint mGeneralParseGeoPoint;
    protected String TAG = getClass().getSimpleName();
    public NotificationManager mNotificationManager;
    public static List<ParseObject> mCategoryTagList = new ArrayList<>();
    public ImageView mLoadingImage;
    public View mEntireScreenView;

    public ParseGeoPoint getmGeneralParseGeoPoint() {
        return mGeneralParseGeoPoint;
    }

    public ParseUser getmCurrentParseUser() {
        return mCurrentParseUser;
    }

    //TODO ALWAYS NAME THE ROOTVIEW OF MAINCONTENT entire_screen_view ALWAYS!

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "" + location);
        mGeneralParseGeoPoint = new ParseGeoPoint(location.getLatitude(), location.getLongitude());
    }

    @Override
    public void onLocationFailed(int failType) {
        switch (failType) {
            case FailType.PERMISSION_DENIED: {
                ToastUtils.shortToast("Couldn't get location, because user didn't give location permission!");
                break;
            }
            case FailType.GP_SERVICES_NOT_AVAILABLE:
            case FailType.GP_SERVICES_CONNECTION_FAIL: {
                ToastUtils.shortToast("Couldn't get location, because Google Play Services is not available!");
                break;
            }
            case FailType.NETWORK_NOT_AVAILABLE: {
                getLocation();
                ToastUtils.shortToast("Couldn't get location, because network is not accessible!");
                break;
            }
            case FailType.TIMEOUT: {
                getLocation();
                ToastUtils.shortToast("Couldn't get location, and timeout!");
            }
            break;
        }
    }


    @Override
    public LocationConfiguration getLocationConfiguration() {
        return new LocationConfiguration()
                .keepTracking(true)
                .askForGooglePlayServices(true)
                .setMinAccuracy(200.0f)
                .setWaitPeriod(ProviderType.GOOGLE_PLAY_SERVICES, 5 * 1000)
                .setWaitPeriod(ProviderType.GPS, 10 * 1000)
                .setWaitPeriod(ProviderType.NETWORK, 5 * 1000)
                .setGPSMessage("Would you like to turn GPS on?")
                .setRationalMessage("Give the permission!");
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void cancelUploadNotifcation(int notificationID) {
        mNotificationManager.cancel(notificationID);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLocation();
        if (ParseUser.getCurrentUser() != null) {
            //doBindService(this);
        }

        Utils.printKeyToLog(this);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        mSharedHelperInstance = BaseApplication.getInstance().getmAppSharedPrefHelper();
        mCurrentParseUser = ParseUser.getCurrentUser();
        mContext = this;

        getLocation();
    }

    public void setupBackNavigationButton(@IdRes int toolbarID) {
        Toolbar toolbar = (Toolbar) findViewById(toolbarID);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    public void setActionBarTitle(String toolbarTitle) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(toolbarTitle);
        }
    }

    public void hideKeyBoard(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void cancelNetWorkOpNotifcation(int notificationID) {
        mNotificationManager.cancel(notificationID);
    }

    public boolean isNetworkAvailable() {
        if (Utils.isNetworkAvailable(mContext)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUserLoggedIn() {
        if (getCurrentUser() != null) {
            return true;
        } else {
            return false;
        }
    }

    public void showContentView() {
        if (mEntireScreenView != null && (mEntireScreenView.getVisibility() == View.INVISIBLE || mEntireScreenView.getVisibility() == View.GONE)) {
            Utils.toggleVisibility(mEntireScreenView);
        } else {
            Log.d(TAG, "cant show: Content view is null");
        }
    }

    public void hideContentView() {
        if (mEntireScreenView != null && mEntireScreenView.getVisibility() == View.VISIBLE) {
            Utils.toggleVisibility(mEntireScreenView);
        } else {
            Log.d(TAG, "cant hide: Content view is null");
        }
    }

    public void showLoadingViewFullScreen() {
        if (mLoadingImage != null && (mLoadingImage.getVisibility() == View.INVISIBLE || mLoadingImage.getVisibility() == View.GONE)) {
            Utils.toggleVisibility(mLoadingImage);
        } else {
            Log.d(TAG, "cant show: loading view is null");
        }
    }

    public void hideLoadingViewFullScreen() {
        if (mLoadingImage != null && mLoadingImage.getVisibility() == View.VISIBLE) {
            Utils.toggleVisibility(mLoadingImage);
        } else {
            Log.d(TAG, "cant show: loading view is null");
        }
    }

    public ParseUser getCurrentUser() {
        if (getmCurrentParseUser() != null) {
            return getmCurrentParseUser();
        } else {
            return null;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }


    private boolean mStatus;
    private final BroadcastReceiver mConnectivityCheckReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            String reason = intent.getStringExtra(ConnectivityManager.EXTRA_REASON);
            boolean isFailover = intent.getBooleanExtra(ConnectivityManager.EXTRA_IS_FAILOVER, false);
            NetworkInfo currentNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            NetworkInfo otherNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_OTHER_NETWORK_INFO);
            Log.i(TAG, "Status : " + noConnectivity + ", Reason :" + reason + ", FailOver :" + isFailover + ", Current Network Info : " + currentNetworkInfo + ", OtherNetwork Info :" + otherNetworkInfo);

            mStatus = noConnectivity;
            Log.d(TAG, "Status :" + mStatus);

            if (mStatus) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
                builder.setMessage("Connection is not Available !");
                builder.setTitle("Info");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();

                    }

                });
                AlertDialog alert = builder.create();
                alert.show();
            } else {

                AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
                builder.setMessage("Connection is Available !");
                builder.setTitle("Info");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();

                    }

                });
                AlertDialog alert = builder.create();
                alert.show();
            }


        }
    };


    public void showUploadNotification(String title, int notificationID) {
        // configure the intent
        Intent intent = new Intent(this, BaseActivity.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
        final Notification notification = new Notification(R.drawable.ic_settings_grey600_48dp, title, System
                .currentTimeMillis());
        notification.flags = notification.flags | Notification.FLAG_ONGOING_EVENT;
        notification.contentView = new RemoteViews(getApplicationContext().getPackageName(),
                R.layout.progress_layout);
        notification.contentIntent = pendingIntent;
        notification.contentView.setImageViewResource(R.id.status_icon, R.drawable.ic_settings_grey600_48dp);
        notification.contentView.setTextViewText(R.id.status_text, title);
        notification.contentView.setProgressBar(R.id.status_progress, 100, 0, true);
        mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(
                getApplicationContext().NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationID, notification);
    }

    @Override
    public void showError(String error) {
        ToastUtils.shortToast(error);
    }

    @Override
    public void showLoading() {
        DialogUtils.loadingDialog(this);
    }

    @Override
    public void hideLoading() {
        DialogUtils.hideLoadingDialog();
    }


}
