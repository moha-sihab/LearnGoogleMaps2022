package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsPolylinesBinding
import com.sihabudin.learngooglemaps2022.misc.Shapes
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import kotlinx.coroutines.launch

class MapsPolylinesActivity : AppCompatActivity(), OnMapReadyCallback,
    GoogleMap.OnPolylineClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsPolylinesBinding
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val shapes by lazy { Shapes() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsPolylinesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDialogInfo()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_POLYLINES
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val bogorCity = LatLng(-6.601375025858572, 106.805091965632)

        val bogorMarker = mMap.addMarker(
            MarkerOptions()
                .position(bogorCity)
                .title("Marker in Bogor")
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogorCity, 10f))
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        typeAndStyle.setMapStyle(mMap, this)
        mMap.setOnPolylineClickListener(this)
        lifecycleScope.launch {
            shapes.addPolyline(mMap)
        }


    }

    override fun onPolylineClick(polyline: Polyline) {
        Toast.makeText(this, "Test Polylines Click", Toast.LENGTH_LONG).show()
    }

    private fun showDialogInfo() {
        val message = getString(R.string.info_map_introduction_polyline)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}