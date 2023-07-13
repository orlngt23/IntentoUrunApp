package com.example.urunapp

sealed class BottomBarScreen (
    // restringimos la herencia de la clase a un conjunto
    // de subclases
    val route: String,
    val title: String,
    val icon: Int

        ){
    //el objeto HOME representara la vista hikemap
    object Home: BottomBarScreen(
        //Esto representa la ruta y el id con el que se debe llamar
        // la vista
        route = "HOME",
        title = "HOME",
        icon = R.drawable.logourun
    )
    object User: BottomBarScreen(
        route = "USER",
        title = "USER",
        icon = R.drawable.usuario
    )
    object Progress: BottomBarScreen(
        route = "PROGRESS",
        title = "PROGRESS",
        icon = R.drawable.progreso
    )

}