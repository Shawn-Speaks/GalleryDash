package shawn.c4q.nyc.gallerydash.leigh;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shawn.c4q.nyc.gallerydash.R;

/**
 * Created by leighdouglas on 1/31/17.
 */

public class MuseumListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_museum_list, container, false);
        return view;
    }
}
