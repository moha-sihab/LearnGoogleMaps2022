package com.sihabudin.learngooglemaps2022.misc

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlay
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.sihabudin.learngooglemaps2022.R

class Overlays {
    private val bogorCity = LatLng(-6.601375025858572, 106.805091965632)

    fun addGroundOverlay(map: GoogleMap) : GroundOverlay?{
        return map.addGroundOverlay(
            GroundOverlayOptions().apply {
                position(bogorCity, 10000f,10000f)
                image(BitmapDescriptorFactory.fromResource(R.drawable.gmaps))
            }
        )
    }
}