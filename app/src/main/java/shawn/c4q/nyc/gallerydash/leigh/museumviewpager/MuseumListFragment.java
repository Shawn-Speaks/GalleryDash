package shawn.c4q.nyc.gallerydash.leigh.museumviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shawn.c4q.nyc.gallerydash.R;
import shawn.c4q.nyc.gallerydash.leigh.MuseumListHelper;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumData;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumResponse;
import shawn.c4q.nyc.gallerydash.leigh.museumrecyclerview.MuseumAdapter;
import shawn.c4q.nyc.gallerydash.leigh.service.MuseumService;

/**
 * Created by leighdouglas on 1/31/17.
 */

public class MuseumListFragment extends Fragment implements MuseumParentFragment.Listener{

    private RecyclerView museumRV;
    private MuseumAdapter museumAdapter;
    private static String TAG = "Retrofit";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_museum_list, container, false);
        museumRV = (RecyclerView) view.findViewById(R.id.museum_rv);
        museumAdapter = new MuseumAdapter();
        museumRV.setLayoutManager(new LinearLayoutManager(view.getContext()));
        museumRV.setAdapter(museumAdapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void updateList(ArrayList<MuseumData> list) {
        museumAdapter.setMuseumList(list);

    }
}

