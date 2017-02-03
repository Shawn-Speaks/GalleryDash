package shawn.c4q.nyc.gallerydash;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import shawn.c4q.nyc.gallerydash.leigh.BottomNavigationViewHelper;
import shawn.c4q.nyc.gallerydash.leigh.museumviewpager.MuseumParentFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bttmNavBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavBar();

    }

    private void initNavBar() {
        bttmNavBar = (BottomNavigationView) findViewById(R.id.main_bttm_navbar);
        bttmNavBar.inflateMenu(R.menu.bottom_nav_menu);

        BottomNavigationViewHelper.disableShift(bttmNavBar);

        bttmNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.action_edit_avatar):


                        break;
                    case (R.id.action_museum_list):
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_main_activity, new MuseumParentFragment())
                                .commit();
                        break;
                    case (R.id.action_check_in):

                        break;
                    case (R.id.action_badge_gallery):

                        break;
                }
                return true;
            }
        });
    }
}
