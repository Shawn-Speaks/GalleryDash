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
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.GooglePlacesResponse;
import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.Results;
import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.ShawnServices.GooglePlacesUrlJsonBuilder;

import static android.content.ContentValues.TAG;

/**
 * Created by shawnspeaks on 2/2/17.
 */

public class CheckIn implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private Location mCurrentLocation;
    private Activity activity;
    private Context context;

    private GooglePlacesUrlJsonBuilder mUrlBuilder;
    private GoogleApiClient mGoogleClient;

    public ArrayList<Results> results = new ArrayList<>();




    public CheckIn(Context activityContext, Activity mainActivity) {
        this.activity = mainActivity;
        this.context = activityContext;
    }

    public void makePlacesRetroFitCall(Location location) {
        final String[] VENUE_TYPE_ARRAY = {"museum"};
        final String API_KEY = "AIzaSyDvMOgWEVV1tAANpjDO05ajNJ6ZSkLfuQk";
        final String radiusFromCurrentLocation = "50";
        mUrlBuilder = GooglePlacesUrlJsonBuilder.getInstance();

        String locationString = String.valueOf(mCurrentLocation.getLatitude())+","+String.valueOf(mCurrentLocation.getLongitude());

        Log.d(TAG, "LATTITUDE IS " + String.valueOf(mCurrentLocation.getLatitude()));
        Log.d(TAG, "LONGITUDE IS " + String.valueOf(mCurrentLocation.getLongitude()));

        mUrlBuilder.addToMap("location", locationString);
        mUrlBuilder.addToMap("key", API_KEY);
        mUrlBuilder.addToMap("type", VENUE_TYPE_ARRAY[0]);
        mUrlBuilder.addToMap("radius", radiusFromCurrentLocation);
        Call<GooglePlacesResponse> call = mUrlBuilder.listJSON();
        call.enqueue(new Callback<GooglePlacesResponse>() {
            @Override
            public void onResponse(Call<GooglePlacesResponse> call, Response<GooglePlacesResponse> response) {
                Log.d(TAG, "SUCCESS !");
                GooglePlacesResponse gPlaceResponse = response.body();
                results = gPlaceResponse.getResults();
               if(gPlaceResponse.getStatus().equals("ZERO_RESULTS")){
                   Toast.makeText(context, "No museum nearby", Toast.LENGTH_SHORT).show();
               }else
                   Toast.makeText(context, "You're close to " + results.get(0).getName(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<GooglePlacesResponse> call, Throwable t) {
                Log.d(TAG, "retrofit call failure");
            }
        });
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
        mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleClient);
        makePlacesRetroFitCall(mCurrentLocation);
    }


    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(context, "conection suspended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
