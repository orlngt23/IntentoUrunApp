package com.example.urunapp.network.retrofit

import com.example.urunapp.network.service.AuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// URL base del servidor API
const val BASE_URL = "https://urun-api-ad12e71d2e29.herokuapp.com/"

// Objeto singleton para la instancia de Retrofit
object RetrofitInstance {
    // Variable para almacenar el token de autenticación
    private var token = ""

    // Función para establecer el token de autenticación
    fun setToken(token: String) {
        this.token = token
    }

    // Configuración de la instancia de Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)  // Establece la URL base del servidor API
        .addConverterFactory(GsonConverterFactory.create())  // Configura el convertidor de Gson para convertir JSON a objetos
        .build()

    // Función para obtener el servicio de autenticación
    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)  // Crea una implementación del servicio AuthService utilizando Retrofit
    }
}
