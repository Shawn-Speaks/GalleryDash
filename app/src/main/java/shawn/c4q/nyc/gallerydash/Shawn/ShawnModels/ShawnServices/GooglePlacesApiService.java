package shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.ShawnServices;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.GooglePlacesResponse;

/**
 * Created by shawnspeaks on 2/1/17.
 */

public interface GooglePlacesApiService {

    @GET("maps/api/place/textsearch/json")
    Call<GooglePlacesResponse> listJSON(@QueryMap Map<String, String> mapName);


}
