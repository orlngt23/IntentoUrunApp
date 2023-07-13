package com.example.urunapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.urunapp.graphs.RootNavigationGraph

import com.example.urunapp.ui.hikemap.HikemapScreen

import com.example.urunapp.ui.login.ui.LoginScreen
import com.example.urunapp.ui.login.ui.LoginViewModel
import com.example.urunapp.ui.register.ui.RegisterScreen
import com.example.urunapp.ui.start.ui.StartScreen
import com.example.urunapp.ui.theme.URUNAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            URUNAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    RootNavigationGraph(navController = rememberNavController())

                }
            }
        }
    }
}

