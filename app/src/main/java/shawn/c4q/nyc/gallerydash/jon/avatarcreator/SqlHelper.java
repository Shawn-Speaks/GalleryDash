package shawn.c4q.nyc.gallerydash.jon.avatarcreator;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nl.qbusict.cupboard.QueryResultIterable;
import shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.Avatar;
import shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.Museum;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;


public class SqlHelper {

    public SqlHelper() {
    }

    public static List<Avatar> selectAllAvatars(SQLiteDatabase db) {
        List<Avatar> avatars = new ArrayList<>();
        try {
            QueryResultIterable<Avatar> itr = cupboard().withDatabase(db).query(Avatar.class).query();
            for (Avatar avatar : itr) {
                avatars.add(avatar);
            }
            itr.close();
        } catch (Exception e) {
            Log.e("Avatar List", "selectAllAvatars: ", e);
        }
        return avatars;
    }

    public static List<Museum> selectAllMuseums(SQLiteDatabase db) {
        List<Museum> museums = new ArrayList<>();
        try {
            QueryResultIterable<Museum> itr = cupboard().withDatabase(db).query(Museum.class).query();
            for (Museum museum : itr) {
                museums.add(museum);
            }
            itr.close();
        } catch (Exception e) {
            Log.e("Museum List", "selectAllMuseums: ", e);
        }
        return museums;
    }

    public Museum getMuseumByName(SQLiteDatabase db, String museumName) {
        return cupboard().withDatabase(db).query(Museum.class).withSelection("museumName = ?", museumName).get();
    }

    public boolean onMuseumExistsInDatabase(SQLiteDatabase db, String museumName) {
        return cupboard().withDatabase(db).query(Museum.class).withSelection("museumName = ?", museumName).get() != null;
    }

    public void incrementVisit(Museum museum){
        int timesCheckedIn = museum.getNumberOfVisits() + 1;
        museum.setNumberOfVisits(timesCheckedIn);
    }

    public void setTimeOfCurrentVisit(Museum museum){
        long currentTime = System.currentTimeMillis();
        museum.setTimeLastVisted(currentTime);
    }

    public static Avatar getAvatar(SQLiteDatabase db) {
        Random rand = new Random();
        Avatar avatar = cupboard().withDatabase(db).get(Avatar.class, rand.nextInt(20));
        return avatar;
    }
}
