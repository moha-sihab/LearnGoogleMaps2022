package com.sihabudin.learngooglemaps2022.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewport {
    val bogorCity : CameraPosition = CameraPosition.Builder()
        .target(LatLng(-6.601375025858572, 106.805091965632))
        .zoom(17f)
        .bearing(0f)
        .tilt(45f)
        .build()
}