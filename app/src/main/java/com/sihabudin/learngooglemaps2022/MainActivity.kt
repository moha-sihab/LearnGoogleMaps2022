package com.sihabudin.learngooglemaps2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sihabudin.learngooglemaps2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMapType.setOnClickListener {
            val showMapType = Intent(this,MapsTypeActivity::class.java)
            startActivity(showMapType)
        }

        binding.btnMapStyle.setOnClickListener {
            val showMapStyle = Intent(this,MapsStyleActivity::class.java)
            startActivity(showMapStyle)
        }

        binding.btnMapBuilding3d.setOnClickListener {
            val showMapBuilding = Intent(this,MapsBuilding3dActivity::class.java)
            startActivity(showMapBuilding)
        }

        binding.btnMapMaxMinZoom.setOnClickListener {
            val showMapMaxMinZoom = Intent(this,MapsMaxMinZoomActivity::class.java)
            startActivity(showMapMaxMinZoom)
        }

        binding.btnMapUpdateCameraPosition.setOnClickListener {
            val showMapUpdateCameraPosition = Intent(this,MapsUpdateCameraPositionActivity::class.java)
            startActivity(showMapUpdateCameraPosition)
        }
    }
}