package shawn.c4q.nyc.gallerydash.jon.avatarcreator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.Avatar;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class AvatarDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "avatar.db";
    private static final int DATABASE_VERSION = 1;
    private static AvatarDatabaseHelper instance;

    public static synchronized AvatarDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new AvatarDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private AvatarDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        cupboard().register(Avatar.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
    }
}