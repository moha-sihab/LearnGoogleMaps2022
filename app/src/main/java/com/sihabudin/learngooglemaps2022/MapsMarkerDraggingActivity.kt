package com.sihabudin.learngooglemaps2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsDataObjectMarkerBinding
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsMarkerDraggingBinding
import com.sihabudin.learngooglemaps2022.misc.CameraAndViewport
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle

class MapsMarkerDraggingActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsMarkerDraggingBinding
    private val cameraAndViewport by lazy { CameraAndViewport() }
    private val typeAndStyle by lazy { TypeAndStyle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsMarkerDraggingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_MARKER_DRAGGING

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val bogorCity = LatLng(-6.601375025858572, 106.805091965632)

        val bogorMarker = mMap.addMarker(
            MarkerOptions()
                .position(bogorCity)
                .title("Marker in Bogor")
                .draggable(true)
        )
        if (bogorMarker != null) {
            bogorMarker.tag = "Tugu Kujang"
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogorCity, 10f))
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        typeAndStyle.setMapStyle(mMap, this)

        mMap.setOnMarkerDragListener(this)

    }

    override fun onMarkerDragStart(p0: Marker) {
        Log.d("drag=","Start")
    }

    override fun onMarkerDrag(p0: Marker) {
        Log.d("drag=","Drag")
    }

    override fun onMarkerDragEnd(p0: Marker) {
        Log.d("drag=","End")
    }
}