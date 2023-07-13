package com.example.urunapp.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.urunapp.RetrofitApplication


@Composable
fun RootNavigationGraph(navController: NavHostController) {
    // Crea un NavHost que se encargará de la navegación.
    NavHost(
        navController = navController,
        startDestination = Graph.AUTHENTICATION,
        route = Graph.ROOT
    ) {
        // Define la ruta de navegación para la autenticación.
        authNavGraph(navController = navController, app = RetrofitApplication())
    }
}

// Define un objeto llamado Graph que contiene constantes para las rutas de navegación.
object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}
