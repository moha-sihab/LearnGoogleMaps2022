package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsMarkerDraggingBinding
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import com.sihabudin.learngooglemaps2022.widget.GeneralInfo

class MapsMarkerDraggingActivity : AppCompatActivity(), OnMapReadyCallback,
    GoogleMap.OnMarkerDragListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsMarkerDraggingBinding
    private val typeAndStyle by lazy { TypeAndStyle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsMarkerDraggingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDialogInfo()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_MARKER_DRAGGING

    }

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
        Log.d("drag=", "Start")
    }

    override fun onMarkerDrag(p0: Marker) {
        Log.d("drag=", "Drag")
    }

    override fun onMarkerDragEnd(p0: Marker) {
        Log.d("drag=", "End")
    }

    private fun showDialogInfo() {
        val message = getString(R.string.info_map_enable_marker_dragging)
        GeneralInfo(this).setUp(message) { close, dialog ->
            close.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}