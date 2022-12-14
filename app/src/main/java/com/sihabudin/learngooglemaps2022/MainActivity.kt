package com.sihabudin.learngooglemaps2022

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sihabudin.learngooglemaps2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChooseSubject.setOnClickListener {
            val dialog = OptionSubjectFragment()
            dialog.show(supportFragmentManager, "Open Option Dialog")
            dialog.setOnClickSubjectListener(selectedSubject)
        }
    }

    private fun showSubject(subject: String) {
        when (subject) {
            MAP_STYLE -> {
                val showMapStyle = Intent(this, MapsStyleActivity::class.java)
                startActivity(showMapStyle)
            }
            MAP_TYPE -> {
                val showMapType = Intent(this, MapsTypeActivity::class.java)
                startActivity(showMapType)
            }
            MAP_BUILDING3D -> {
                val showMapBuilding = Intent(this, MapsBuilding3dActivity::class.java)
                startActivity(showMapBuilding)
            }
            MAP_MAXMINZOOM -> {
                val showMapMaxMinZoom = Intent(this, MapsMaxMinZoomActivity::class.java)
                startActivity(showMapMaxMinZoom)
            }
            MAP_UPDATE_CAMERA_POSITION -> {
                val showMapUpdateCameraPosition =
                    Intent(this, MapsUpdateCameraPositionActivity::class.java)
                startActivity(showMapUpdateCameraPosition)
            }
            MAP_BOUNDARIES -> {
                val showMapBoundaries = Intent(this, MapsBoundariesActivity::class.java)
                startActivity(showMapBoundaries)
            }
            MAP_RESTRICT_SCROLL -> {
                val showMapRestrict = Intent(this, MapsRestrictScrollActivity::class.java)
                startActivity(showMapRestrict)
            }
            MAP_ANIMATE_CAMERA -> {
                val showMapAnimateCamera =
                    Intent(this, MapsAnimateCameraMovementActivity::class.java)
                startActivity(showMapAnimateCamera)
            }
            MAP_SINGLE_LONG_CLICK -> {
                val showMapSingleLongClick = Intent(this, MapsClickEventsActivity::class.java)
                startActivity(showMapSingleLongClick)
            }
            MAP_OBJECT_MARKER -> {
                val showMapObjectMarker = Intent(this, MapsDataObjectMarkerActivity::class.java)
                startActivity(showMapObjectMarker)
            }
            MAP_MARKER_DRAGGING -> {
                val showMapMarkerDragging = Intent(this, MapsMarkerDraggingActivity::class.java)
                startActivity(showMapMarkerDragging)
            }
            MAP_MARKER_CUSTOM -> {
                val showMapMarkerCustom = Intent(this, MapsMarkerCustomizationActivity::class.java)
                startActivity(showMapMarkerCustom)
            }
            MAP_INFO_WINDOW -> {
                val showInfoWindow = Intent(this, MapsInfoWindowActivity::class.java)
                startActivity(showInfoWindow)
            }
            MAP_INFO_WINDOW_CUSTOM -> {
                val showInfoWindowCustom = Intent(this, MapsCustomInfoWindowActivity::class.java)
                startActivity(showInfoWindowCustom)
            }
            MAP_POLYLINES -> {
                val showPolyline = Intent(this, MapsPolylinesActivity::class.java)
                startActivity(showPolyline)
            }
            MAP_POLYGONS -> {
                val showPolygon = Intent(this, MapsPolygonActivity::class.java)
                startActivity(showPolygon)
            }
            MAP_CIRCLE -> {
                val showCircle = Intent(this, MapsCircleActivity::class.java)
                startActivity(showCircle)
            }
            MAP_CUSTOM_POLYLINES -> {
                val showCustomPolyline = Intent(this, MapsCustomPolylineActivity::class.java)
                startActivity(showCustomPolyline)
            }
            MAP_GROUND_OVERLAY -> {
                val showGroundOverlay = Intent(this, MapsGroundOverlayActivity::class.java)
                startActivity(showGroundOverlay)
            }
            MAP_LOCATION_LAYER -> {
                val showLocationLayer = Intent(this, MapsLocationLayerActivity::class.java)
                startActivity(showLocationLayer)
            }

        }

    }

    private val selectedSubject =
        object : OptionSubjectFragment.SetOnClickSubjectListener {
            override fun onClick(subject: String) {
                showSubject(subject)
            }

        }
}