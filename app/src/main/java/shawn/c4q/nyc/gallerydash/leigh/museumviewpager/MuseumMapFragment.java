package shawn.c4q.nyc.gallerydash.leigh.museumviewpager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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

                if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED){
                        mMap.setMyLocationEnabled(true);
                    }
                }

                LatLng theMet = new LatLng(40.77942354199044, -73.96345111145274);
                LatLng musAfricanArt = new LatLng(40.74634173827231, -73.92822391104288);
                LatLng comicAndCartoon = new LatLng(40.7247979456424, -73.99670247583494);
                LatLng musAfricanDiaspora = new LatLng(40.68524514383062, -73.97442477664784);
                LatLng gug = new LatLng(40.78300947618501,-73.95891102040586);
                LatLng whit = new LatLng(40.773407292902185, -73.96383434736195);
                LatLng bkmus = new LatLng(40.67108321212629,-73.96358506797661);
                LatLng frick = new LatLng(40.77105465350546, -73.96708040539806);
                LatLng rubin = new LatLng(40.74002038014153, -73.99779152534921);
                LatLng newmuseum = new LatLng(40.722346701845474,-73.99283879250072);
                LatLng nathistory = new LatLng(40.78082623457644,-73.97364816377815);
                LatLng ps1 = new LatLng(40.74583946863492, -73.94621241792795);
                LatLng moma = new LatLng(40.76118664102449, -73.97700363152086);


                mMap.addMarker(new MarkerOptions().position(theMet).title("Metropolitan Museum of Art"));
                mMap.addMarker(new MarkerOptions().position(musAfricanArt).title("Museum of African Art"));
                mMap.addMarker(new MarkerOptions().position(comicAndCartoon).title("Museum of Comic and Cartoon Art"));
                mMap.addMarker(new MarkerOptions().position(musAfricanDiaspora).title("Museum of Contemporary African Diaspora Art"));
                mMap.addMarker(new MarkerOptions().position(gug).title("Solomon R. Guggenheim Museum"));
                mMap.addMarker(new MarkerOptions().position(whit).title("Whitney Museum of American Art"));
                mMap.addMarker(new MarkerOptions().position(bkmus).title("Brooklyn Museum"));
                mMap.addMarker(new MarkerOptions().position(frick).title("Frick Collection"));
                mMap.addMarker(new MarkerOptions().position(rubin).title("Rubin Museum of Art"));
                mMap.addMarker(new MarkerOptions().position(newmuseum).title("New Museum of Contemporary Art"));
                mMap.addMarker(new MarkerOptions().position(nathistory).title("American Museum of Natural History"));
                mMap.addMarker(new MarkerOptions().position(ps1).title("P.S. 1 Contemporary Art Center"));
                mMap.addMarker(new MarkerOptions().position(moma).title("Museum of Modern Art (MoMA)"));



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