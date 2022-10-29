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
import com.sihabudin.learngooglemaps2022.databinding.ActivityMapsStyleBinding
import com.sihabudin.learngooglemaps2022.misc.TypeAndStyle
import com.sihabudin.learngooglemaps2022.widget.GeneralInfo

class MapsStyleActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsStyleBinding
    private val typeAndStyle by lazy { TypeAndStyle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsStyleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDialogInfo()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title = MAP_STYLE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_style_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        typeAndStyle.setMapStyle(mMap, this, item)
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
        val message = getString(R.string.info_map_style)
        GeneralInfo(this).setUp(message) { close, dialog ->
            close.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

}
