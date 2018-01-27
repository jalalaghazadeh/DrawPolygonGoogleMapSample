package com.mrjalal.drawpolygongooglemapsample;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    private static class DefaultCameraState {
        static double initialLatitude = 32.7554865;
        static double initialLongitude = -117.1411377;
        static float initialZoom = 15;
    }

    @BindView(R.id.map)
    MapView map;
    Unbinder unbinder;

    GoogleMap googleMap;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        unbinder = ButterKnife.bind(this, view);
        map.onCreate(savedInstanceState);
        map.getMapAsync(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        map.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        map.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // add polygon for ZONE-1
        googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(32.7610000, -117.146259), new LatLng(32.7610000, -117.138854), new LatLng(32.755309, -117.138854), new LatLng(32.755283, -117.146289), new LatLng(32.7610000, -117.146259))
                .strokeColor(Color.RED).fillColor(Color.parseColor("#88007ee3")));


        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(DefaultCameraState.initialLatitude, DefaultCameraState.initialLongitude), DefaultCameraState.initialZoom));
    }
}
