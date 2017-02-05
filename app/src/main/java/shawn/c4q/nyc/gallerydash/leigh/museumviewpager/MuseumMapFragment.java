package shawn.c4q.nyc.gallerydash.leigh.museumviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import shawn.c4q.nyc.gallerydash.R;
import shawn.c4q.nyc.gallerydash.leigh.MuseumListHelper;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumData;

public class MuseumMapFragment extends Fragment implements MuseumParentFragment.Listener {

    MapView mapView;
    private GoogleMap mMap;
    private List<MuseumData> markers = new ArrayList<>();

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
                mMap.setMyLocationEnabled(true);
                LatLng theMet = new LatLng(40.77942354199044, -73.96345111145274);
                LatLng musAfricanArt = new LatLng(40.74634173827231, -73.92822391104288);
                LatLng comicAndCartoon = new LatLng(40.7247979456424, -73.99670247583494);
                LatLng musAfricanDiaspora = new LatLng(40.68524514383062, -73.97442477664784);

                mMap.addMarker(new MarkerOptions().position(theMet).title("Metropolitan Museum of Art"));
                mMap.addMarker(new MarkerOptions().position(musAfricanArt).title("Museum of African Art"));
                mMap.addMarker(new MarkerOptions().position(comicAndCartoon).title("Museum of Comic and Cartoon Art"));
                mMap.addMarker(new MarkerOptions().position(musAfricanDiaspora).title("Museum of Contemporary African Diaspora Art"));

                CameraPosition cameraPosition = new CameraPosition.Builder().target(theMet).zoom(12).build();
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
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


    @Override
    public void updateList(ArrayList<MuseumData> list) {
        Log.d("Marker", "we made it to this point");
        if (mMap != null) {
            for (MuseumData museum : list) {
                Double lat = museum.getGeometry().getCoordinates().get(0);
                Double lng = museum.getGeometry().getCoordinates().get(1);
                LatLng position = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions().position(position).title("hello"));
                Log.d("Marker", "this should run a bunch of times");
            }
        }
    }
}