package shawn.c4q.nyc.gallerydash.Shawn.ShawnModels;

import java.util.ArrayList;

/**
 * Created by shawnspeaks on 2/1/17.
 */

public class GooglePlacesResponse {

    private ArrayList<Results> results;
    private String status;

    public ArrayList<Results> getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }
}
