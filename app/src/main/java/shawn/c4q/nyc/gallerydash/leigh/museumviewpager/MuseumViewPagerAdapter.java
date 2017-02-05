package shawn.c4q.nyc.gallerydash.leigh.museumviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leighdouglas on 2/2/17.
 */

public class MuseumViewPagerAdapter extends FragmentPagerAdapter {
    static String listTag;
    static String mapTag;

    static final int LIST_INDEX = 0;
    static final int MAP_INDEX = 1;
    private String tabTitles[] = new String[] { "List", "Map" };


    public MuseumViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case LIST_INDEX:
                return new MuseumListFragment();
            case MAP_INDEX:
                return new MuseumMapFragment();
            default:
                throw new IllegalStateException("no more than 2 fragments");
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        switch (position) {
            case 0:
                listTag = fragment.getTag();
                break;
            case 1:
                mapTag = fragment.getTag();
                break;
        }
        return fragment;
    }

}
