package shawn.c4q.nyc.gallerydash.jon.avatarcreator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.Museum;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class MuseumDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "museum.db";
    private static final int DATABASE_VERSION = 1;
    private static MuseumDatabaseHelper instance;

    public static synchronized MuseumDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new MuseumDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private MuseumDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        cupboard().register(Museum.class);
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