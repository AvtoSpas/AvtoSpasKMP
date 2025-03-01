package com.example.avtospaskmp.android

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.compose.rememberNavController
import com.example.avtospaskmp.android.navigation.NavigationGraph

import com.example.avtospaskmp.android.screens.theme.OnDarkColorScheme
import com.example.avtospaskmp.android.screens.theme.OnLightColorScheme

class MainActivity : ComponentActivity() {
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Why?
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent {
            val configuration = LocalConfiguration.current
            val isDarkTheme by remember(configuration) {
                derivedStateOf {
                    (configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
                }
            }
            val navController = rememberNavController()

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val colorScheme = remember(isDarkTheme) { if (isDarkTheme) OnDarkColorScheme else OnLightColorScheme }
                    NavigationGraph(
                        navController = navController,
                        colorScheme = colorScheme,
                    )
                }
            }
        }
    }
}




