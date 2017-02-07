package shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.ShawnServices;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
import shawn.c4q.nyc.gallerydash.jon.avatarcreator.MuseumDatabaseHelper;
import shawn.c4q.nyc.gallerydash.jon.avatarcreator.SqlHelper;
import shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.Museum;

import static android.content.ContentValues.TAG;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by shawnspeaks on 2/3/17.
 */

public class PlacesRetrofitCall {

    public int museumID;
    private ArrayList<Results> results = new ArrayList<>();
    private GooglePlacesUrlJsonBuilder mUrlBuilder;
    private Context mContext;

    public PlacesRetrofitCall(Context context, Location location) {
        this.mContext = context;

        final String[] VENUE_TYPE_ARRAY = {"museum"};
        final String API_KEY = "AIzaSyDvMOgWEVV1tAANpjDO05ajNJ6ZSkLfuQk";
        final String radiusFromCurrentLocation = "1500";
        mUrlBuilder = GooglePlacesUrlJsonBuilder.getInstance();

        String locationString = String.valueOf(location.getLatitude()) + "," + String.valueOf(location.getLongitude());
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
                if (gPlaceResponse.getStatus().equals("ZERO_RESULTS")) {
                    Toast.makeText(mContext, "No museum nearby", Toast.LENGTH_SHORT).show();
                    if (results.size() != 0) {
                        ConvertMuseumsNameToID converter = new ConvertMuseumsNameToID(results.get(0).getName());
                    }
//                    converter.museumID          NUMBER

                } else {
                    String museumName = results.get(0).getName();
                    Toast.makeText(mContext, "You're close to " + museumName, Toast.LENGTH_SHORT).show();
                    updateMuseum(museumName);
                }
            }

            @Override
            public void onFailure(Call<GooglePlacesResponse> call, Throwable t) {
                Log.d(TAG, "retrofit call failure");
            }
        });
    }

    private void updateMuseum(String museumName) {
        MuseumDatabaseHelper museumDbHelper = MuseumDatabaseHelper.getInstance(mContext);
        SQLiteDatabase db = museumDbHelper.getWritableDatabase();
        SqlHelper sqlHelper = new SqlHelper();
        if (!sqlHelper.onMuseumExistsInDatabase(db, museumName)) {
            Museum museum = new Museum(museumName);
            sqlHelper.incrementVisit(museum);
            sqlHelper.setTimeOfCurrentVisit(museum);
            cupboard().withDatabase(db).put(museum);
        } else{
            Museum museum = sqlHelper.getMuseumByName(db, museumName);
            sqlHelper.incrementVisit(museum);
            sqlHelper.setTimeOfCurrentVisit(museum);
            cupboard().withDatabase(db).put(museum);
        }
    }

}
