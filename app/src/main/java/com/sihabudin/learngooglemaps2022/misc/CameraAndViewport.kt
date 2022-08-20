package com.sihabudin.learngooglemaps2022.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewport {
    val bogorCity: CameraPosition = CameraPosition.Builder()
        .target(LatLng(-6.601375025858572, 106.805091965632))
        .zoom(17f)
        .bearing(0f)
        .tilt(45f)
        .build()

    val jakartaCity: CameraPosition = CameraPosition.Builder()
        .target(LatLng(-6.188369827059872, 106.8230155321853))
        .zoom(17f)
        .bearing(0f)
        .tilt(45f)
        .build()

    val jakartaBounds = LatLngBounds(
        LatLng(-6.309622740849423, 106.80408639524843), //South
        LatLng(-6.183804438242485, 106.82217107313902) //north

    )
}