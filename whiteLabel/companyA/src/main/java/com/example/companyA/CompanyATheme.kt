package com.example.companyA

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun CompanyATheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = CompanyAPrimary,
            secondary = CompanyASecondary
        ),
        typography = Typography(),
        content = content
    )
}