package shawn.c4q.nyc.gallerydash.leigh;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shawn.c4q.nyc.gallerydash.R;
import shawn.c4q.nyc.gallerydash.leigh.galleryrecyclerview.GalleryAdapter;
import shawn.c4q.nyc.gallerydash.leigh.museumrecyclerview.MuseumAdapter;

/**
 * Created by leighdouglas on 2/4/17.
 */

public class GalleryFragment extends Fragment {

    private RecyclerView galleryRV;
    private GalleryAdapter galleryAdapter;
    private static String TAG = "Retrofit";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        galleryRV = (RecyclerView) view.findViewById(R.id.gallery_rv);
        galleryAdapter = new GalleryAdapter();
        galleryRV.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        galleryRV.setAdapter(galleryAdapter);
        return view;
    }
}
