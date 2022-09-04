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

    private fun showSubject(subject : String){
        when(subject){
            MAP_STYLE -> {
                val showMapStyle = Intent(this,MapsStyleActivity::class.java)
                startActivity(showMapStyle)
            }
            MAP_TYPE -> {
                val showMapType = Intent(this,MapsTypeActivity::class.java)
                startActivity(showMapType)
            }
            MAP_BUILDING3D -> {
                val showMapBuilding = Intent(this,MapsBuilding3dActivity::class.java)
                startActivity(showMapBuilding)
            }
            MAP_MAXMINZOOM -> {
                val showMapMaxMinZoom = Intent(this,MapsMaxMinZoomActivity::class.java)
                startActivity(showMapMaxMinZoom)
            }
            MAP_UPDATE_CAMERA_POSITION -> {
                val showMapUpdateCameraPosition = Intent(this,MapsUpdateCameraPositionActivity::class.java)
                startActivity(showMapUpdateCameraPosition)
            }
        }

    }

    private val selectedSubject =
        object : OptionSubjectFragment.SetOnClickSubjectListener{
            override fun onClick(subject: String) {
               showSubject(subject)
            }

        }
}