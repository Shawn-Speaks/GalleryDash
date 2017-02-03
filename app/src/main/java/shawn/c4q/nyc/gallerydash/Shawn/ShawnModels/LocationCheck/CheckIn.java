package shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.LocationCheck;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.ShawnServices.PlacesRetrofitCall;

/**
 * Created by shawnspeaks on 2/2/17.
 */

public class CheckIn implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient mGoogleClient;
    private Activity activity;
    private Context context;

    public CheckIn(Context activityContext, Activity mainActivity) {
        this.activity = mainActivity;
        this.context = activityContext;
    }

    public void initGoogleClient() {
        mGoogleClient = new GoogleApiClient.Builder(activity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mGoogleClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "App may not behave properly", Toast.LENGTH_SHORT).show();
            return;
        }
        Location mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleClient);
        new PlacesRetrofitCall(context, mCurrentLocation);
        mGoogleClient.disconnect();
    }


    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(context, "conection suspended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
