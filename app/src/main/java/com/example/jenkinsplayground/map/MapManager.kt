package com.example.jenkinsplayground.map

import android.location.Location

interface MapManager {
    fun initMap()
    fun displayRoute(route: List<Location>)
}