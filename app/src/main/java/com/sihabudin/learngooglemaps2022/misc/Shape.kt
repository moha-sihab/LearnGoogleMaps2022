package com.sihabudin.learngooglemaps2022.misc

import android.graphics.Color
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.sihabudin.learngooglemaps2022.R
import kotlinx.coroutines.delay

class Shapes {
    private val bogorCity = LatLng(-6.601375025858572, 106.805091965632)
    private val jakartaCity = LatLng(-6.188369827059872, 106.8230155321853)
    private val bandungCity = LatLng(-6.91472969449106, 107.64180786769849)
    private val subangCity = LatLng(-6.571054645923424, 107.79012329176588)

    private val cilegonCity = LatLng(-5.976282319311091, 106.02342445221866)
    private val ciletukKalapaCity = LatLng(-6.7800406893976986, 105.68541161738685)
    private val tasikCity = LatLng(-7.364400684356497, 108.20485716276912)
    private val indramayuCity = LatLng(-6.330607356726136, 108.30820933875762)

    private val p0 = bogorCity
    private val p1 = jakartaCity
    private val p2 = subangCity
    private val p3 = bandungCity

    private val p00 = cilegonCity
    private val p01 = ciletukKalapaCity
    private val p02 = tasikCity
    private val p03 = indramayuCity

    suspend fun addPolyline(mMap : GoogleMap){
        val polyline = mMap.addPolyline(PolylineOptions().apply {
            add(bogorCity,jakartaCity)
            width(5f)
            color(Color.RED)
        })

        delay(5000)

        val newList = listOf(
            bogorCity,jakartaCity,bandungCity,bogorCity
        )

        polyline.points = newList
    }

    fun addPolygon(map : GoogleMap){
        val polygon = map.addPolygon(
            PolygonOptions().apply {
                add(p0,p1,p2,p3)
                fillColor(R.color.black)
                strokeColor(Color.YELLOW)
                zIndex(1f)
                addHole(listOf(p00,p01,p02,p03))
            }
        )
    }
}