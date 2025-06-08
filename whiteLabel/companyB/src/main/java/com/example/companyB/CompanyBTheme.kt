package com.example.companyB

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun CompanyBTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = CompanyBPrimary,
            secondary = CompanyBSecondary
        ),
        typography = Typography(),
        content = content
    )
}