package com.example.t017_googlemaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.t017_googlemaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    Button btn_maptype , btn_zoomin , btn_zoomout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_maptype = findViewById(R.id.btn_maptype);
        btn_zoomin = findViewById(R.id.btn_zoomin);
        btn_zoomout = findViewById(R.id.btn_zoomout);

        btn_maptype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
                   mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
               }
               else {
                   mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
               }
            }
        });

        btn_zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });

        btn_zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(19.23381371400445, 73.12209680557305);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Raheja Cpmplex"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15f));
    }
}