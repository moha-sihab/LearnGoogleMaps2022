package com.sihabudin.learngooglemaps2022.misc

import android.content.Context
import android.util.Log
import android.view.MenuItem
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions
import com.sihabudin.learngooglemaps2022.R

class TypeAndStyle {

    fun setMapStyle(googleMap: GoogleMap, context: Context, item: MenuItem) {
        try {
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    context,
                    when (item.itemId) {
                        R.id.aubergine_map -> {
                            R.raw.style_map_aubergine
                        }
                        R.id.dark_map -> {
                            R.raw.style_map_dark
                        }
                        R.id.night_map -> {
                            R.raw.style_map_night
                        }
                        R.id.retro_map -> {
                            R.raw.style_map_retro
                        }
                        R.id.silver_map -> {
                            R.raw.style_map_silver
                        }
                        else -> {
                            R.raw.style_map_standard
                        }
                    }

                )
            )

            if (!success) {
                Log.d("Maps", "Failed to add style.")
            }
        } catch (e: Exception) {
            Log.d("Maps", e.toString())
        }
    }

    fun setMapType(item: MenuItem, mMap: GoogleMap) {
        when (item.itemId) {
            R.id.normal_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            }

            R.id.hybrid_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
            }

            R.id.satellite_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }

            R.id.terrain_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }

            R.id.none_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NONE
            }


        }
    }
}