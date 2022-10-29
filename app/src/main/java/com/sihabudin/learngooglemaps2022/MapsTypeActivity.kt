package com.sihabudin.learngooglemaps2022

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsTypeBinding
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import com.sihabudin.learngooglemaps2022.widget.GeneralInfo

class MapsTypeActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsTypeBinding
    private val typeAndStyle by lazy { TypeAndStyle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDialogInfo()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_TYPE
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

        val jakartaCity = LatLng(-6.188369827059872, 106.8230155321853)

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jakartaCity, 10f))

        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }

    }

    private fun showDialogInfo() {
        val message = getString(R.string.info_map_type)
        GeneralInfo(this).setUp(message) { close, dialog ->
            close.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}