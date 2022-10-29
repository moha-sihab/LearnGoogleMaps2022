package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsCircleBinding
import com.sihabudin.learngooglemaps2022.misc.Shapes
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import kotlinx.coroutines.launch

class MapsCircleActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsCircleBinding
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val shapes by lazy { Shapes() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsCircleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_CIRCLE
    }

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