package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsClickEventsBinding
import com.sihabudin.learngooglemaps2022.misc.CameraAndViewport
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsClickEventsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsClickEventsBinding
    private val cameraAndViewport by lazy { CameraAndViewport() }
    private val typeAndStyle by lazy { TypeAndStyle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsClickEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_SINGLE_LONG_CLICK
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

        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        typeAndStyle.setMapStyle(mMap, this)

        lifecycleScope.launch {
            delay(4000L)
            mMap.animateCamera(
                CameraUpdateFactory.newCameraPosition(cameraAndViewport.jakartaCity),
                2000,
                object : GoogleMap.CancelableCallback {
                    override fun onFinish() {
                        Toast.makeText(this@MapsClickEventsActivity, "Finish", Toast.LENGTH_LONG)
                            .show()
                    }

                    override fun onCancel() {
                        Toast.makeText(this@MapsClickEventsActivity, "Cancel", Toast.LENGTH_LONG)
                            .show()
                    }
                })

        }
        onMapClicked()
        onMapLongClicked()
    }

    private fun onMapClicked() {
        mMap.setOnMapClickListener {
            Toast.makeText(this@MapsClickEventsActivity, "Single Click", Toast.LENGTH_LONG).show()
        }
    }

    private fun onMapLongClicked() {
        mMap.setOnMapLongClickListener {
            Toast.makeText(
                this@MapsClickEventsActivity,
                "${it.longitude} ${it.latitude}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}