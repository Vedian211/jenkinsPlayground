package com.example.core

import androidx.compose.runtime.compositionLocalOf

class HttpClient(val basUrl: String, val apiKey: String) {

    suspend fun makeRequest(): String = ""
}

val LocalHttpClient = compositionLocalOf<HttpClient> { error("No default impl of HttpClient") }