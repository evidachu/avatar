package com.example.project1androidui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.project1androidui.navigation.AppNavigation
import com.example.project1androidui.ui.theme.Project1AndroidUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1AndroidUITheme {
                AppNavigation()  // 🚀 Panggil navigasi, bukan Greeting lagi
            }
        }
    }
}
