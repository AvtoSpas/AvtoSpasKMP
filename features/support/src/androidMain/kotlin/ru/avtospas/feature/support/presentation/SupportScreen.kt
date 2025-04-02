package ru.avtospas.feature.support.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SupportScreen(onNavigateToMainScreen: () -> Unit) {
    Column {
        Text(text = "SupportScreen")
    }
}