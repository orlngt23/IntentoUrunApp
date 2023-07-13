package com.example.urunapp.graphs

import android.annotation.SuppressLint
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.urunapp.RetrofitApplication
import com.example.urunapp.SplashScreen
import com.example.urunapp.ui.hikemap.HikemapScreen
import com.example.urunapp.ui.login.ui.LoginScreen
import com.example.urunapp.ui.login.ui.LoginViewModel
import com.example.urunapp.ui.register.ui.RegisterScreen
import com.example.urunapp.ui.register.ui.RegisterViewModel
import com.example.urunapp.ui.start.ui.StartScreen
import com.example.urunapp.ui.welcome.ScreenWelcome

// Anotación que suprime el lint para la advertencia de "UnrememberedGetBackStackEntry"
@SuppressLint("UnrememberedGetBackStackEntry")

// Función de extensión que crea el gráfico de navegación para la autenticación
fun NavGraphBuilder.authNavGraph(navController: NavHostController, app: RetrofitApplication) {

    // Se crean los ViewModelFactory para los ViewModels utilizados en la navegación
    val loginViewModelFactory = viewModelFactory {
        initializer {
            LoginViewModel(app.credentialsRepository)
        }
    }

    val registerViewModelFactory = viewModelFactory {
        initializer {
            RegisterViewModel(app.credentialsRepository)
        }
    }

    // Se utiliza la función de navegación para definir el gráfico de navegación
    // con una ruta y un destino inicial
    navigation(
        route = Graph.AUTHENTICATION, //aca es donde enlazos con root
        startDestination = AuthScreen.SplashScreen.route
    ) {
        // Definición de las diferentes pantallas dentro del gráfico de navegación

        // SplashScreen es la pantalla de presentación
        composable(route = AuthScreen.SplashScreen.route) {
            SplashScreen(NavController = navController)
        }

        // StartScreen es la pantalla de inicio
        composable(route = AuthScreen.StartScreen.route) {
            StartScreen(navController = navController)
        }

        // RegisterScreen es la pantalla de registro de usuario
        composable(route = AuthScreen.RegisterScreen.route) {
            // Se obtiene la entrada de la pila de retroceso para esta pantalla
            val backStackEntry = remember { navController.getBackStackEntry(route = AuthScreen.RegisterScreen.route) }
            //preguntar si es mejor utilizar ViewModel Scope
            RegisterScreen(
                navController = navController,
                // Se obtiene el ViewModel asociado a esta pantalla utilizando el backStackEntry y el ViewModelFactory
                viewModel = ViewModelProvider(backStackEntry, registerViewModelFactory)[RegisterViewModel::class.java]
            )
        }

        // LoginScreen es la pantalla de inicio de sesión de usuario
        composable(route = AuthScreen.LoginScreen.route) {
            // Se obtiene la entrada de la pila de retroceso para esta pantalla
            val backStackEntry = remember { navController.getBackStackEntry(route = AuthScreen.LoginScreen.route) }

            LoginScreen(
                navController = navController,
                // Se obtiene el ViewModel asociado a esta pantalla utilizando el backStackEntry y el ViewModelFactory
                viewModel = ViewModelProvider(backStackEntry, loginViewModelFactory)[LoginViewModel::class.java]
            )
        }

        // WelcomeScreen es la pantalla de bienvenida
        composable(route = AuthScreen.WelcomeScreen.route) {
            ScreenWelcome(navController = navController)
        }

        //Agregando cambiar al momento de hacer el HomeNavGraph
        composable(route = AuthScreen.HikeMap.route) {
          HikemapScreen(navController=navController)
        }
    }
}

// Sealed class que define las pantallas de autenticación y sus rutas
sealed class AuthScreen(val route: String) {
    object SplashScreen : AuthScreen("splash_screen")
    object StartScreen : AuthScreen("start_screen")
    object LoginScreen : AuthScreen("login_screen")
    object RegisterScreen : AuthScreen("register_screen")
    object WelcomeScreen : AuthScreen("welcome_screen")
    //Agregando cambiar al momento de hacer el HomeNavGraph
    object HikeMap: AuthScreen("HikeMap")
}
