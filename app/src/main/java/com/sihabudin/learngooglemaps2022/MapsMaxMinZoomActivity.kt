package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsMaxMinZoomBinding
import com.sihabudin.learngooglemaps2022.widget.GeneralInfo

class MapsMaxMinZoomActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsMaxMinZoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsMaxMinZoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDialogInfo()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_MAXMINZOOM
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val jakartaCity = LatLng(-6.188369827059872, 106.8230155321853)

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jakartaCity, 10f))

        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        mMap.setMaxZoomPreference(17f)
        mMap.setMinZoomPreference(14f)

    }

    private fun showDialogInfo() {
        val message = getString(R.string.info_map_max_min_zoom)
        GeneralInfo(this).setUp(message) { close, dialog ->
            close.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}