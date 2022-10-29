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
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsAnimateCameraMovementBinding
import com.sihabudin.learngooglemaps2022.misc.CameraAndViewport
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsAnimateCameraMovementActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsAnimateCameraMovementBinding
    private val cameraAndViewport by lazy { CameraAndViewport() }
    private val typeAndStyle by lazy { TypeAndStyle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsAnimateCameraMovementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDialogInfo()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_ANIMATE_CAMERA

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

        lifecycleScope.launch {
            delay(4000L)
            mMap.animateCamera(
                CameraUpdateFactory.newCameraPosition(cameraAndViewport.jakartaCity),
                2000,
                object : GoogleMap.CancelableCallback {
                    override fun onFinish() {
                        Toast.makeText(
                            this@MapsAnimateCameraMovementActivity,
                            "Finish",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onCancel() {
                        Toast.makeText(
                            this@MapsAnimateCameraMovementActivity,
                            "Cancel",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
            mMap.setLatLngBoundsForCameraTarget(cameraAndViewport.jakartaBounds)
        }

    }

    private fun showDialogInfo() {
        val message = getString(R.string.info_map_animate_camera_movement)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}