package com.aliumujib.majlis.mkanreport.utils.location;
import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class STLocationRequestService implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    Context context;
    private static final long INTERVAL = 1000 * 10;
    private static final long FASTEST_INTERVAL = 1000 * 5;

    Address geolocation;

    SamLocationListener samLocationListener;


    public STLocationRequestService(Context context) {
        this.context = context;
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);




    }

    public interface SamLocationListener {

        public void onLocationUpdate(Location location, Address address);

    }



    public void executeService(final SamLocationListener samLocationListener) {
        this.samLocationListener=samLocationListener;
        mGoogleApiClient.connect();
        if (mGoogleApiClient.isConnected()) {
            startLocationUpdates();
            Log.d("", "Location update resumed .....................");
        }
    }

    public void getsamlocationlistener(final SamLocationListener samLocationListener){
        this.samLocationListener=samLocationListener;
    }

    @Override
    public void onConnected(Bundle bundle) {
        startLocationUpdates();
        Log.d("", "Connected .....................");
    }

    @Override
    public void onConnectionSuspended(int i) {

    }



    @Override
    public void onLocationChanged(Location location) {
        Log.e("Lat", " " + String.valueOf(location.getLatitude()));
        Log.e("Long", " " + String.valueOf(location.getLongitude()));
        if ((String.valueOf(location.getLatitude())).equals(null)) {

        } else {
            stopLocationUpdates();
            LocationAddress locationAddress = new LocationAddress();

            geolocation = locationAddress.getAddressFromLocation(location.getLatitude(),location.getLongitude(),
                    context);
            Log.e("geolocation", " " + geolocation);

        }

        samLocationListener.onLocationUpdate(location,geolocation);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public void startLocationUpdates() {
        PendingResult<Status> pendingResult = LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
        Log.d("LocationRequestService", "Location update started ..............: ");
    }



    public void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
        Log.d("LocationRequestService", "Location update stopped .......................");
    }

}