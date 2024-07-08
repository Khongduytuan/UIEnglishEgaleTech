package com.eagletech.uienglishegaletech

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.eagletech.uienglishegaletech.ui.theme.UIEnglishEgaleTechTheme
import com.eagletech.uienglishegaletech.ui.theme.screens.LoginScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIEnglishEgaleTechTheme {
                LoginScreen()

            }
        }
    }
}


