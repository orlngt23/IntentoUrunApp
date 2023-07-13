package com.example.urunapp.ui.start.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.urunapp.R
import com.example.urunapp.graphs.AuthScreen
import com.example.urunapp.ui.register.ui.HeaderImage


@Composable
fun StartScreen(navController: NavController) {
    Box(
        Modifier
            .fillMaxSize()

            .background(Color(0xFF1E1E1E))
    ) {
        start(Modifier.align(Alignment.Center), navController)

    }
}

@Preview
@Composable
fun start(modifier: Modifier, navController: NavController) {

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        RegisterButton(navController)
        Spacer(modifier = Modifier.padding(12.dp))
        LoginButton(navController)
        Spacer(modifier = Modifier.padding(12.dp))

    }
}

@Composable
fun LoginButton(navController: NavController) {
    Button(
        onClick = {navController.navigate(AuthScreen.LoginScreen.route)},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFCCFF00),
            disabledContainerColor = Color.Green,
            contentColor = Color(0xFF1E1E1E),
            disabledContentColor = Color(0xFFCCFF00)
        )
    ) {
        Text(
            text = "Iniciar Sesion",

            )
    }
}



@Composable
fun HeaderImage(Modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo1),
        contentDescription = "Header",
        modifier = Modifier
    )
}


@Composable
fun RegisterButton(navController: NavController) {
    Button(
        onClick = { navController.navigate(AuthScreen.RegisterScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFCCFF00),
            disabledContainerColor = Color.Green,
            contentColor = Color(0xFF1E1E1E),
            disabledContentColor = Color(0xFFCCFF00)
        )
    ) {
        Text(
            text = "Registrarse",

            )
    }
}
