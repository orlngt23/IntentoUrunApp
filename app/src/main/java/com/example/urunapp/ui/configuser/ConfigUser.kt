package com.example.urunapp.ui.configuser

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urunapp.R
import com.example.urunapp.ui.theme.Mycolors
import com.example.urunapp.ui.welcome.ImageLogo

@Preview
@Composable
fun ConfigScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Mycolors.backgroundUrun)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentAlignment = Alignment.TopCenter,

            ) {
            ImageLogo()
        }
        ConfigPersonal()
        Spacer(modifier = Modifier.height(20.dp))
        More()
    }
}

    @Composable
    fun ImageLogo() {
        Image(
            painter = painterResource(id = R.drawable.logotextohorizontal),
            contentDescription = "Logo",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )

    }

@Composable
fun  ConfigPersonal(){
    Column() {
        Text(
            text = "Ajustes personales",
            color = Color.White,
            modifier = Modifier.padding(start = 70.dp, bottom = 30.dp, top = 30.dp),
            textAlign = TextAlign.Justify,
            fontSize = (30.sp)
        )

        Button(
            onClick = { /* Acción del segundo botón */ },
            modifier = Modifier
                .padding(start = 50.dp)
                .width(300.dp)
                .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
            colors = ButtonDefaults.buttonColors( Mycolors.backgroundUrun)
        ) {
            Text(text = "Editar perfil", color = Color.White)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { /* Acción del segundo botón */ },
            modifier = Modifier
                .padding(start = 50.dp)
                .width(300.dp)
                .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
            colors = ButtonDefaults.buttonColors( Mycolors.backgroundUrun)
        ) {
            Text(text = "Cuenta", color = Color.White)
        }
    }

}

@Composable
fun  More(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Más",
            color = Color.White,
            modifier = Modifier.padding(start = 60.dp, bottom = 30.dp, top = 30.dp),
            textAlign = TextAlign.Justify,
            fontSize = (30.sp)
        )

        Button(
            onClick = { /* Acción del segundo botón */ },
            modifier = Modifier
                .padding(start = 50.dp)
                .width(300.dp)
                .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
            colors = ButtonDefaults.buttonColors( Mycolors.backgroundUrun)
        ) {
            Text(text = "Terminos y condiciones", color = Color.White)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { /* Acción del segundo botón */ },
            modifier = Modifier
                .padding(start = 50.dp)
                .width(300.dp)
                .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
            colors = ButtonDefaults.buttonColors( Mycolors.backgroundUrun)
        ) {
            Text(text = "Politica de privacidad", color = Color.White)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { /* Acción del segundo botón */ },
            modifier = Modifier
                .padding(start = 50.dp)
                .width(300.dp)
                .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
            colors = ButtonDefaults.buttonColors( Mycolors.backgroundUrun)
        ) {
            Text(text = "Ayuda", color = Color.White)
        }

        Button(
            onClick = { /* Acción del segundo botón */ },
            modifier = Modifier
                .padding(top = 20.dp, start = 50.dp)
                .width(200.dp)
                .background(Mycolors.greenUrun, RoundedCornerShape(16.dp))
                .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
            colors = ButtonDefaults.buttonColors( Mycolors.greenUrun)
        ) {
            Text(text = "Cerrar sesión", color = Mycolors.backgroundUrun,modifier = Modifier.scale(1.2f) )
        }
    }

}
