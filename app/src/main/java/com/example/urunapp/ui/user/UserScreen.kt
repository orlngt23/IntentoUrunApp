package com.example.urunapp.ui.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urunapp.R
import com.example.urunapp.ui.theme.Mycolors
import com.example.urunapp.ui.welcome.ImageLogo

@Preview
@Composable
fun ScreenUser() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Mycolors.backgroundUrun)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 20.dp),
            contentAlignment = Alignment.TopCenter,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                ImageLogo()
                Box(
                    modifier = Modifier
                        .width(75.dp)
                        .fillMaxHeight()
                        .padding(end = 20.dp)
                ) {
                    ImageConfig()

                }

            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                ImagePanel()
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Followers()
            }
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            NameAndNationality()
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Avatares()
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Resumen()
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
fun ImageConfig() {
    IconButton(onClick = { /*TODO*/ }) {
        Image(
            painter = painterResource(id = R.drawable.config),
            contentDescription = "Configuracion",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )
    }

}

@Composable
fun ImagePanel() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)

        )
        Image(
            painter = painterResource(id = R.drawable.userurun),
            contentDescription = "imagen de usuario",
            modifier = Modifier
                .size(125.dp)
                .offset(x = 40.dp, y = 230.dp)
        )
    }

}

@Composable
fun Followers() {
    Row(modifier = Modifier.width(200.dp), Arrangement.SpaceBetween) {
        Column(modifier = Modifier.width(100.dp)) {
            Text(
                text = "10",
                color = Mycolors.greenUrun,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = (20.sp)
            )
            Text(
                text = "Seguidores",
                color = Color.White,

                fontSize = (15.sp),
            )
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "10",
                color = Mycolors.greenUrun,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = (20.sp)
            )
            Text(
                text = "Seguidos",
                color = Color.White,
                modifier = Modifier.padding(end = 20.dp),
                fontSize = (15.sp),
            )


        }
    }
}

@Composable
fun NameAndNationality() {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = "Aida Turcios",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (40.sp)
        )
        Text(
            text = "El Salvador",
            color = Mycolors.greenUrun,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (25.sp)
        )

    }
}

@Composable
fun Avatares() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Avatares",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (30.sp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
        ) {
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

@Composable
fun Resumen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Resumen",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (30.sp)
        )
        Row(modifier = Modifier.width(400.dp).padding(start = 20.dp), Arrangement.SpaceBetween) {
            Column(modifier = Modifier.width(200.dp)) {
                Text(
                    text = "20.45",
                    color = Mycolors.greenUrun,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (40.sp)
                )
                Text(
                    text = "Total de km",
                    color = Color.White,
                    modifier = Modifier.padding(start = 30.dp),
                    fontSize = (15.sp),
                )
            }
            Column(modifier = Modifier.width(200.dp)) {
                Text(
                    text = "20.45",
                    color = Mycolors.greenUrun,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (40.sp)
                )
                Text(
                    text = "Total de horas",
                    color = Color.White,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (15.sp),
                )
            }


            }
        }

}


