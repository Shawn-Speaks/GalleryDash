package shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.ShawnServices;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.GooglePlacesResponse;

/**
 * Created by shawnspeaks on 2/1/17.
 */

public class GooglePlacesUrlJsonBuilder {


    private static final String googleBaseUrl = "https://maps.googleapis.com/";
    private  static GooglePlacesUrlJsonBuilder instance;
    private static GooglePlacesApiService service;
    private Map<String, String> queryData = new HashMap<>();

    public static GooglePlacesUrlJsonBuilder getInstance(){
        if(instance == null){
            instance = new GooglePlacesUrlJsonBuilder();
        }

        return instance;
    }

    public void addToMap(String key, String value){
        queryData.put(key, value);
    }

    private GooglePlacesUrlJsonBuilder(){
        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(googleBaseUrl)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();

        service = retrofit.create(GooglePlacesApiService.class);
    }

    public Call<GooglePlacesResponse> listJSON(){
        return service.listJSON(queryData);
    }




}
