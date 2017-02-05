package shawn.c4q.nyc.gallerydash.jon.avatarcreator;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nl.qbusict.cupboard.QueryResultIterable;
import shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.Avatar;

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

    public static Avatar getAvatar(SQLiteDatabase db) {
        Random rand = new Random();
        Avatar avatar = cupboard().withDatabase(db).get(Avatar.class);
        return avatar;
    }
}
