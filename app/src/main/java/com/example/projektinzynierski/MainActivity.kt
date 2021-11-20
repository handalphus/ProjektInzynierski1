package com.example.projektinzynierski

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Console

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingPermission")
    fun getLastKnownLocation() {

        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    textViewAltitude.text = location.altitude.toString()
                    textViewLongitude.text = location.longitude.toString()
                    textViewLatitude.text = location.latitude.toString()
                    textViewSpeed.text = "ale zadupiamy"
                }
                else{
                    textViewAltitude.text = "problem"
                }

            }
    }

    private lateinit var  fusedLocationProviderClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getLastKnownLocation()
//        var locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        locationManager.getProvider(LocationManager.GPS_PROVIDER)
//
//        var criteria = Criteria()
//        criteria.accuracy = Criteria.ACCURACY_FINE
//        criteria.isSpeedRequired=true
//
//        var providerName = locationManager.getBestProvider(criteria,true)
//        var gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
//        textViewAccuracy.text = gpsEnabled.toString()

    }
}