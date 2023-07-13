package com.example.urunapp

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.fitness.Fitness
import com.google.android.gms.fitness.FitnessOptions
import com.google.android.gms.fitness.data.DataType
import com.google.android.gms.fitness.data.Field




object GoogleFitAPi {
    interface StepCountListener {
        fun onStepCountChanged(stepCount: Int)
    }
    private const val FITNESS_PERMISSIONS_REQUEST_CODE = 1
    private var stepCountListener: StepCountListener? = null

    @Composable
    fun initialize(context: Context) {
        val fitnessOptions = FitnessOptions.builder()
            .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
            .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
            // Agrega otros tipos de datos que necesites
            .build()

        val account = GoogleSignIn.getLastSignedInAccount(context)

        if (!GoogleSignIn.hasPermissions(account, fitnessOptions)) {
            GoogleSignIn.requestPermissions(
                context as Activity,
                FITNESS_PERMISSIONS_REQUEST_CODE,
                account,
                fitnessOptions
            )
        } else {
            // La API de Google Fit está lista para ser utilizada
            // Puedes realizar otras acciones aquí

            // Registra el listener de contador de pasos
            registerStepCountListener()
        }
    }

    fun setStepCountListener(listener: StepCountListener) {
        stepCountListener = listener
    }

    @Composable
    private fun registerStepCountListener() {
        val fitnessOptions = FitnessOptions.builder()
            .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
            .build()

        val account = GoogleSignIn.getAccountForExtension(LocalContext.current, fitnessOptions)

        Fitness.getHistoryClient(LocalContext.current, account)
            .readDailyTotal(DataType.TYPE_STEP_COUNT_DELTA)
            .addOnSuccessListener { dataSet ->
                val totalSteps = if (dataSet.isEmpty) 0 else dataSet.dataPoints[0].getValue(Field.FIELD_STEPS).asInt()
                stepCountListener?.onStepCountChanged(totalSteps)
            }
            .addOnFailureListener { e ->
                Log.e("GoogleFitAPi", "Failed to read step count", e)
            }
    }
}
