package shawn.c4q.nyc.gallerydash.leigh.service;

import retrofit2.Call;
import retrofit2.http.GET;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumResponse;

/**
 * Created by leighdouglas on 1/31/17.
 */

public interface MuseumService {
    public static String BASE_URL = "https://data.cityofnewyork.us/";

    @GET("api/geospatial/ekax-ky3z?method=export&format=GeoJSON")
    Call<MuseumResponse> getMuseumList();
}
