package com.example.jenkinsplayground.screens

import android.location.Location
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.LocalHttpClient
import com.example.core.LocationProvider
import com.example.core.RouteCalculator
import com.example.jenkinsplayground.map.MapManager

@Composable
fun MapScreen(paddingValues: PaddingValues, mapManager: MapManager) {
    val context = LocalContext.current
    val httpClient = LocalHttpClient.current
    val locationProvider = remember { LocationProvider(context) }
    val routeCalculator = remember { RouteCalculator() }

    val destination = Location("").apply {
        latitude = 55.751244
        longitude = 37.618423
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("BASE_URL = ${httpClient.basUrl}", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("API_KEY = ${httpClient.apiKey}", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                Toast.makeText(context, "Class $mapManager", Toast.LENGTH_LONG).show()
                val current = locationProvider.getCurrentLocation() ?: return@Button
                val route = routeCalculator.calculateRoute(current, destination)
                mapManager.displayRoute(route)
            }) {
                Text("show route", fontSize = 20.sp)
            }
        }
    }
}