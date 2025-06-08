package com.example.jenkinsplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.example.companyA.CompanyATheme
import com.example.core.HttpClient
import com.example.core.LocalHttpClient
import com.example.jenkinsplayground.map.MapboxNavigationManager
import com.example.jenkinsplayground.screens.MapScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val mapManager = MapboxNavigationManager()
        val httpClient = HttpClient(BuildConfig.BASE_URL, BuildConfig.API_KEY)

        setContent {
            CompositionLocalProvider(LocalHttpClient provides httpClient) {
                CompanyATheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MapScreen(innerPadding, mapManager)
                    }
                }
            }

        }
    }
}
