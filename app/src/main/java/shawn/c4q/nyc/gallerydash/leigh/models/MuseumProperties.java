package shawn.c4q.nyc.gallerydash.leigh.models;

import java.net.URL;

import retrofit2.http.Url;

/**
 * Created by leighdouglas on 1/31/17.
 */

public class MuseumProperties {
    private String name;
    private String city;
    private String tel;
    private double zip;
    private String address1;
    private String url;

    public String getName(){
        return name;

    }
}
