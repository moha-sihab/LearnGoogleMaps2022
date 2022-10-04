package com.sihabudin.learngooglemaps2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsCircleBinding
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsPolygonBinding
import com.sihabudin.learngooglemaps2022.misc.CameraAndViewport
import com.sihabudin.learngooglemaps2022.misc.Shapes
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import kotlinx.coroutines.launch

class MapsCircleActivity : AppCompatActivity() , OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsCircleBinding
    private val cameraAndViewport by lazy { CameraAndViewport() }
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val shapes by lazy { Shapes() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsCircleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_CIRCLE
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
                .icon(BitmapDescriptorFactory.defaultMarker(190f)) //hue value from https://www.w3schools.com/colors/colors_hsl.asp
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogorCity, 10f))

        typeAndStyle.setMapStyle(mMap, this)

        shapes.addCircle(mMap)

        lifecycleScope.launch {
        }


    }


}