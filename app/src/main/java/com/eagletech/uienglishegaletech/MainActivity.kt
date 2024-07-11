package com.eagletech.uienglishegaletech

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eagletech.uienglishegaletech.ui.theme.UIEnglishEgaleTechTheme
import com.eagletech.uienglishegaletech.ui.theme.onboarding.ListOnBoardScreen
import com.eagletech.uienglishegaletech.ui.theme.screens.LoginScreen
import com.eagletech.uienglishegaletech.ui.theme.screens.signUp.SignUp03
import com.eagletech.uienglishegaletech.ui.theme.signup.SignUpScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIEnglishEgaleTechTheme {

           MyApp()

            }
        }
    }
}
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "screen1") {
        composable("screen1") { ListOnBoardScreen(navController) }
        composable("screen2") { LoginScreen(modifier = Modifier,navController) }
        composable("screen3") { SignUpScreen(modifier = Modifier,navController) }
    }
}


