package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sihabudin.learngooglemaps2022.misc.CameraAndViewport
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_type_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        typeAndStyle.setMapType(item, mMap)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val bogorCity = LatLng(-6.601375025858572, 106.805091965632)
        val jakartaCity = LatLng(-6.188369827059872, 106.8230155321853)
        mMap.addMarker(
            MarkerOptions()
                .position(bogorCity)
                .title("Marker in Bogor")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogorCity,10f))

        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        typeAndStyle.setMapStyle(mMap, this)
        lifecycleScope.launch{
            delay(4000L)
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.jakartaCity),2000, object : GoogleMap.CancelableCallback{
                override fun onFinish() {
                    Toast.makeText(this@MapsActivity,"Finish",Toast.LENGTH_LONG).show()
                }

                override fun onCancel() {
                    Toast.makeText(this@MapsActivity,"Cancel",Toast.LENGTH_LONG).show()
                }
            })
            mMap.setLatLngBoundsForCameraTarget(cameraAndViewport.jakartaBounds)
        }
    }
}