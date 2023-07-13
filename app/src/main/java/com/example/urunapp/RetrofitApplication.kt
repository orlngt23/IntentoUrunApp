package com.example.urunapp

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.urunapp.network.retrofit.RetrofitInstance
import com.example.urunapp.network.service.AuthService
import com.example.urunapp.repository.CredentialsRepository;

class RetrofitApplication : Application() {

    // Se define una propiedad "prefs" de tipo SharedPreferences utilizando la delegación by lazy
    // para inicializarla de forma perezosa.
    // Esta propiedad se utiliza para acceder a las preferencias compartidas de la aplicación.
    private val prefs: SharedPreferences by lazy {
        applicationContext.getSharedPreferences("Retrofit", Context.MODE_PRIVATE)
    }

    // Función privada que se utiliza para obtener el servicio de API utilizando RetrofitInstance.
    // Configura el token de autenticación utilizando la función setToken() de RetrofitInstance
    // y devuelve el servicio de inicio de sesión (LoginService) utilizando
    // la función getLoginService() de RetrofitInstance.
    private fun getAPIService() = with(RetrofitInstance) {
        //setToken(getToken())
        getLoginService()
    }

    // Función que devuelve el token de autenticación almacenado en las preferencias compartidas.
    // Si no se encuentra un token almacenado, se devuelve la cadena "TOKEN" por defecto.
    fun getToken(): String = prefs.getString(USER_TOKEN, "TOKEN")!!

    // Propiedad "credentialsRepository" de tipo CredentialsRepository que se inicializa de forma perezosa
    // utilizando el resultado de la función getAPIService() como argumento.
    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getAPIService())
    }

    // Función para guardar el token de autenticación en las preferencias compartidas.
    // Recibe un token de autenticación como parámetro y lo guarda utilizando un editor de preferencias compartidas.
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    // Sección de constantes de la clase.
    // USER_TOKEN es una constante que se utiliza como clave para almacenar y recuperar el
    // token de autenticación en las preferencias compartidas.
    companion object {
        const val USER_TOKEN = "user_token"
    }
}
