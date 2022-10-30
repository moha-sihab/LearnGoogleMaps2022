package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsCustomInfoWindowBinding
import com.sihabudin.learngooglemaps2022.misc.CustomInfoAdapter
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import com.sihabudin.learngooglemaps2022.widget.GeneralInfo

class MapsCustomInfoWindowActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsCustomInfoWindowBinding
    private val typeAndStyle by lazy { TypeAndStyle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsCustomInfoWindowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDialogInfo()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_INFO_WINDOW_CUSTOM
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val bogorCity = LatLng(-6.601375025858572, 106.805091965632)

        val bogorMarker = mMap.addMarker(
            MarkerOptions()
                .position(bogorCity)
                .title("Marker in Bogor")
                .snippet("Bogor Kota Tegar Beriman")
        )


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogorCity, 10f))
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        mMap.setInfoWindowAdapter(CustomInfoAdapter(this))

        typeAndStyle.setMapStyle(mMap, this)

    }

    private fun showDialogInfo() {
        val message = getString(R.string.info_map_info_window_custom)
        GeneralInfo(this).setUp(message) { close, dialog ->
            close.setOnClickListener {
                dialog.dismiss()
            }
        }
    }


}