package com.eagletech.uienglishegaletech

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.eagletech.uienglishegaletech.ui.theme.UIEnglishEgaleTechTheme
import com.eagletech.uienglishegaletech.ui.theme.onboarding.ListOnBoardScreen
import com.eagletech.uienglishegaletech.ui.theme.onboarding.OnBoardingPage
import com.eagletech.uienglishegaletech.ui.theme.screens.LoginScreen
import com.eagletech.uienglishegaletech.ui.theme.widget.OutlinedOtpTextField

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


