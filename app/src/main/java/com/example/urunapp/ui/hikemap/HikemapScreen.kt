package com.example.urunapp.ui.hikemap

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import com.example.urunapp.R
import com.example.urunapp.ui.progress.ImageLogo
import com.example.urunapp.ui.theme.Mycolors
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.urunapp.GoogleFitAPi

@Preview
@Composable
fun HikemapScreen(navController: NavHostController) {
    val context = LocalContext.current
    var stepCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Mycolors.backgroundUrun)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            ImageLogo()
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            resume(context, stepCount)
        }
    }


}

@Composable
fun resume(context: Context, stepCount: Int) {
    val sensorListener = remember {
        object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                if (event.values.isNotEmpty()) {
                    // No es necesario actualizar el valor aquí
                    // El contador de pasos se actualizará a través del listener de Google Fit
                }
            }

            override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
        }
    }

    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

    GoogleFitAPi.initialize(context)
    GoogleFitAPi.setStepCountListener(object : GoogleFitAPi.StepCountListener {
        override fun onStepCountChanged(stepCount: Int) {
           // this@HikemapScreen.stepCount = stepCount
        }
    })

    DisposableEffect(Unit) {
        sensorManager.registerListener(
            sensorListener,
            sensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )

        onDispose {
            sensorManager.unregisterListener(sensorListener)
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Resumen",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (30.sp)
        )
        Row(
            modifier = Modifier
                .width(400.dp)
                .padding(start = 20.dp),
            Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.width(200.dp)) {
                Text(
                    text = stepCount.toString(),
                    color = Mycolors.greenUrun,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (40.sp)
                )
                Text(
                    text = "Calorias(kcal)",
                    color = Color.White,
                    modifier = Modifier.padding(start = 30.dp),
                    fontSize = (15.sp),
                )
            }
            Column(modifier = Modifier.width(200.dp)) {
                Text(
                    text = stepCount.toString(),
                    color = Mycolors.greenUrun,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (40.sp)
                )
                Text(
                    text = "Distancia(km)",
                    color = Color.White,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (15.sp),
                )
            }

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



