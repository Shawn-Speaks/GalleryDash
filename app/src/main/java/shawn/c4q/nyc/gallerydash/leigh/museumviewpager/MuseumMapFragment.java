package shawn.c4q.nyc.gallerydash.leigh.museumviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import shawn.c4q.nyc.gallerydash.R;

public class MuseumMapFragment extends Fragment {

    MapView mapView;
    private GoogleMap mMap;
    public static boolean mapCreated = false;

    public MuseumMapFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.fragment_map_list, viewGroup, false);
        mapView = (MapView) view.findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);

        mapView.onResume();

            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    mMap = googleMap;
                    mapCreated = true;
                    LatLng sydney = new LatLng(-34, 151);
                    mMap.addMarker(new MarkerOptions().position(sydney).title("Sydney"));
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            });
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        mapCreated = false;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}