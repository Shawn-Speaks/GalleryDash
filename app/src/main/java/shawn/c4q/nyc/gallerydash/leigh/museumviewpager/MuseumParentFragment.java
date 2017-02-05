package shawn.c4q.nyc.gallerydash.leigh.museumviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shawn.c4q.nyc.gallerydash.R;
import shawn.c4q.nyc.gallerydash.leigh.MuseumListHelper;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumData;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumResponse;
import shawn.c4q.nyc.gallerydash.leigh.service.MuseumService;

/**
 * Created by leighdouglas on 2/2/17.
 */

public class MuseumParentFragment extends Fragment {
    Listener list;
    Listener map;
    private TabLayout tl;
    private ViewPager vp;
    private MuseumViewPagerAdapter museumVPAdapter;
    static String TAG = "Retrofit";

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
        runRetrofitCall();

    }

    private void runRetrofitCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MuseumService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MuseumService service = retrofit.create(MuseumService.class);
        Call<MuseumResponse> call = service.getMuseumList();

        call.enqueue(new Callback<MuseumResponse>() {
            @Override
            public void onResponse(Call<MuseumResponse> call, Response<MuseumResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success");

                        MuseumListHelper museumListHelper = MuseumListHelper.getInstance();
                        museumListHelper.setList(response.body().getFeatures());

                        list = (Listener) getChildFragmentManager().findFragmentByTag(MuseumViewPagerAdapter.listTag);
                        map = (Listener) getChildFragmentManager().findFragmentByTag(MuseumViewPagerAdapter.mapTag);

                        list.updateList(museumListHelper.getMuseumDataList());

                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                        Toast.makeText(getActivity(), "Error downloading data",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<MuseumResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(getActivity(), "Unable to download please connect to internet",
                        Toast.LENGTH_LONG).show();
            }
        });

    }


    public interface Listener {
        void updateList(ArrayList<MuseumData> list);
    }
}
