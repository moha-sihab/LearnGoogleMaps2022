package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsPolygonBinding
import com.sihabudin.learngooglemaps2022.misc.Shapes
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle

class MapsPolygonActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsPolygonBinding
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val shapes by lazy { Shapes() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsPolygonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_POLYGONS
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val purwakartaCity = LatLng(-6.5409041651493345, 107.44525946841557)

        val purwakartaMarker = mMap.addMarker(
            MarkerOptions()
                .position(purwakartaCity)
                .title("Marker in Purwakarta")
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(purwakartaCity, 7f))
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        typeAndStyle.setMapStyle(mMap, this)

        shapes.addPolygon(mMap)
    }


}