package shawn.c4q.nyc.gallerydash;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.LocationCheck.CheckIn;
import shawn.c4q.nyc.gallerydash.leigh.BottomNavigationViewHelper;
import shawn.c4q.nyc.gallerydash.leigh.GalleryFragment;
import shawn.c4q.nyc.gallerydash.leigh.museumviewpager.MuseumParentFragment;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bttmNavBar;
    int previousItemId;
    CheckIn checkIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavBar();
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.fragment_main_activity, new MuseumParentFragment())
                    .commit();
        }
    }

    private void initNavBar() {
        bttmNavBar = (BottomNavigationView) findViewById(R.id.main_bttm_navbar);
        bttmNavBar.inflateMenu(R.menu.bottom_nav_menu);

        BottomNavigationViewHelper.disableShift(bttmNavBar);

        bttmNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == previousItemId) {
                    return true; //stops user from clicking the same item in navigation bar (stops multiple fragment/retrofit/etc calls)
                }
                switch (item.getItemId()) {
                    case (R.id.action_edit_avatar):

                        break;

                    case (R.id.action_museum_list):
                        getSupportFragmentManager().beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.fragment_main_activity, new MuseumParentFragment())
                                .commit();
                        break;
                    case (R.id.action_check_in):
                        if (isDeviceOnline()) {
                            checkIn = new CheckIn(getApplicationContext(), MainActivity.this);
                            checkIn.initGoogleClient();
                        } else
                            Toast.makeText(MainActivity.this, "Feature not available offline", Toast.LENGTH_SHORT).show();
                        break;

                    case (R.id.action_badge_gallery):
                        getSupportFragmentManager().beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.fragment_main_activity, new GalleryFragment())
                                .commit();
                        break;
                }
                previousItemId = item.getItemId();
                return true;
            }
        });
    }

    private boolean isDeviceOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netWorkInfo = connectivityManager.getActiveNetworkInfo();
        return netWorkInfo != null && netWorkInfo.isConnected();
    }

}
