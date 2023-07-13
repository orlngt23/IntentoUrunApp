package com.example.urunapp.ui.progress

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urunapp.R
import com.example.urunapp.ui.theme.Mycolors

@Preview
@Composable
fun ProgressScreen() {
    // Este Column contiene toda las vistas y esta divido en box
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Mycolors.backgroundUrun)
    ) {
        // Dentro de este box esta la imagen del logo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentAlignment = Alignment.Center
        ) {
            ImageLogo()
        }
        //Dentro de este Box esta la seccion de actividades
        Box(modifier = Modifier.fillMaxWidth()) {
            Activities()
        }
        //Dentro de este Box esta la seccion de Objetivo
        // val progress controla como se va formando el circulo
        Box(modifier = Modifier.fillMaxWidth()) {
            val progress = 0.8f
            Objectives(progress = progress)
        }
        Spacer(modifier = Modifier.height(10.dp))
        //Dentro de aca van los avatares
        Box(modifier = Modifier.fillMaxWidth()) {

            ImageAvatar()
        }

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
fun Activities() {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Actividades",
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = (30.sp)
            )
            Text(
                text = "Ver mas",
                color = Mycolors.greenUrun,
                modifier = Modifier.padding(end = 20.dp),
                fontSize = (15.sp),
                textDecoration = TextDecoration.Underline
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(
                text = "01.05 km",
                color = Mycolors.greenUrun,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = (25.sp)
            )
            Text(
                text = "00:10:15",
                color = Color.White,
                modifier = Modifier.padding(end = 20.dp),
                fontSize = (25.sp),

                )

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(
                text = "01.05 km",
                color = Mycolors.greenUrun,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = (25.sp)
            )
            Text(
                text = "00:10:15",
                color = Color.White,
                modifier = Modifier.padding(end = 20.dp),
                fontSize = (25.sp),

                )

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(
                text = "01.05 km",
                color = Mycolors.greenUrun,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = (25.sp)
            )
            Text(
                text = "00:10:15",
                color = Color.White,
                modifier = Modifier.padding(end = 20.dp),
                fontSize = (25.sp),

                )

        }

    }
}

@Composable
fun Objectives(progress: Float) {
    val strokeWidth = 8.dp
    val startColor = Color.Gray
    val endColor = Mycolors.greenUrun
    val strokeOffset = with(LocalDensity.current) { strokeWidth.toPx() / 2 }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(16.dp)
    )
    {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(start = 20.dp, end = 20.dp)
        ) {
            val innerRadius = (size.minDimension - strokeOffset) / 2
            val sweepAngle = progress * 360f
            val brush = Brush.sweepGradient(
                colors = listOf(startColor, endColor),
                center = Offset(innerRadius + strokeOffset, innerRadius + strokeOffset)
            )
            drawArc(
                brush = brush,
                startAngle = 90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = Offset(strokeOffset, strokeOffset),
                size = Size(innerRadius * 2, innerRadius * 2),
                style = Stroke(width = strokeWidth.toPx())
            )
        }
        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding( end = 25.dp)) {
            Text(
                text = "Esta semana",
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = (25.sp)
            )
            Text(
                text = "20.05",
                color = Mycolors.greenUrun,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = (65.sp)
            )
            Text(
                text = "de 40.1 km",
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = (25.sp)
            )
            
        }

    }
}

@Composable
fun ImageAvatar(){

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Proximo avatar",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (30.sp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp).fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
            )
            
        }

    }

}