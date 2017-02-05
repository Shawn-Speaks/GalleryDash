package shawn.c4q.nyc.gallerydash.jon.avatarcreator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shawn.c4q.nyc.gallerydash.R;


public class AvatarCreatorFragment extends Fragment {


    public AvatarCreatorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_avatar_creator, container, false);
    }

}
