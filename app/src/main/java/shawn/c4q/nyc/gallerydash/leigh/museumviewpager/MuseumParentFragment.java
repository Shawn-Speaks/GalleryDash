package shawn.c4q.nyc.gallerydash.leigh.museumviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shawn.c4q.nyc.gallerydash.R;

/**
 * Created by leighdouglas on 2/2/17.
 */

public class MuseumParentFragment extends Fragment {

    private TabLayout tl;
    private ViewPager vp;
    private MuseumViewPagerAdapter museumVPAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.museum_parent_fragment, container, false);
        tl = (TabLayout) view.findViewById(R.id.museum_tabs);
        vp = (CustomViewPager) view.findViewById(R.id.museum_pages);
        museumVPAdapter = new MuseumViewPagerAdapter(getChildFragmentManager());
        vp.setAdapter(museumVPAdapter);
        tl.setupWithViewPager(vp);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
