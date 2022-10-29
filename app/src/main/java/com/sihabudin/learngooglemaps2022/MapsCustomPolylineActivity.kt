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
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsCustomPolylineBinding
import com.sihabudin.learngooglemaps2022.misc.Shapes
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import kotlinx.coroutines.launch

class MapsCustomPolylineActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsCustomPolylineBinding
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val shapes by lazy { Shapes() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsCustomPolylineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDialogInfo()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_CUSTOM_POLYLINES
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val bogorCity = LatLng(-6.601375025858572, 106.805091965632)

        val bogorMarker = mMap.addMarker(
            MarkerOptions()
                .position(bogorCity)
                .title("Marker in Bogor")
        )

        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        typeAndStyle.setMapStyle(mMap, this)

        lifecycleScope.launch {
            shapes.customAddPolyline(mMap)
            mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(bogorCity, 9f),
                2000,
                object : GoogleMap.CancelableCallback {
                    override fun onFinish() {
                        Toast.makeText(
                            this@MapsCustomPolylineActivity,
                            "Finish",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onCancel() {
                        Toast.makeText(
                            this@MapsCustomPolylineActivity,
                            "Cancel",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }


    }

    private fun showDialogInfo() {
        val message = getString(R.string.info_map_introduction_polyline)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}