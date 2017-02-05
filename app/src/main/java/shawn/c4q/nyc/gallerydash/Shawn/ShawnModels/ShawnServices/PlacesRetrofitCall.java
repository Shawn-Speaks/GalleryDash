package shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.ShawnServices;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.GooglePlacesResponse;
import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.LocationCheck.ConvertMuseumsNameToID;
import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.Results;

import static android.content.ContentValues.TAG;

/**
 * Created by shawnspeaks on 2/3/17.
 */

public class PlacesRetrofitCall {

    private ArrayList<Results> results = new ArrayList<>();
    private GooglePlacesUrlJsonBuilder mUrlBuilder;
    private Context mContext;
    public int museumID;

    public PlacesRetrofitCall(Context context, Location location) {
        this.mContext = context;

        final String[] VENUE_TYPE_ARRAY = {"museum"};
        final String API_KEY = "AIzaSyDvMOgWEVV1tAANpjDO05ajNJ6ZSkLfuQk";
        final String radiusFromCurrentLocation = "1500";
        mUrlBuilder = GooglePlacesUrlJsonBuilder.getInstance();

        String locationString = String.valueOf(location.getLatitude())+","+String.valueOf(location.getLongitude());
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
                    Toast.makeText(mContext, "No museum nearby", Toast.LENGTH_SHORT).show();
                if(results.size() != 0) {
                    ConvertMuseumsNameToID converter = new ConvertMuseumsNameToID(results.get(0).getName());
                }
//                    converter.museumID          NUMBER

                }else
                    Toast.makeText(mContext, "You're close to " + results.get(0).getName(), Toast.LENGTH_SHORT).show();




            }

            @Override
            public void onFailure(Call<GooglePlacesResponse> call, Throwable t) {
                Log.d(TAG, "retrofit call failure");
            }
        });
    }

}
