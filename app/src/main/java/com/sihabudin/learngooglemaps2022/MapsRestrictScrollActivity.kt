package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsRestrictScrollBinding
import com.sihabudin.learngooglemaps2022.misc.CameraAndViewport
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import com.sihabudin.learngooglemaps2022.widget.GeneralInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsRestrictScrollActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsRestrictScrollBinding
    private val cameraAndViewport by lazy { CameraAndViewport() }
    private val typeAndStyle by lazy { TypeAndStyle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsRestrictScrollBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDialogInfo()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_RESTRICT_SCROLL
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.apply {
            isZoomControlsEnabled = false
            isZoomGesturesEnabled = false
        }

        typeAndStyle.setMapStyle(mMap, this)

        lifecycleScope.launch {
            delay(4000L)
            mMap.moveCamera(
                CameraUpdateFactory.newLatLngBounds(
                    cameraAndViewport.jakartaBounds,
                    100
                )
            )
            mMap.setLatLngBoundsForCameraTarget(cameraAndViewport.jakartaBounds)
        }

    }

    private fun showDialogInfo() {
        val message = getString(R.string.info_map_restrict_scroll_activity)
        GeneralInfo(this).setUp(message) { close, dialog ->
            close.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}