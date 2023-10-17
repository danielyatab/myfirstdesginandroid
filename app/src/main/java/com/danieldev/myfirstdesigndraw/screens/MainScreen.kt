package com.danieldev.myfirstdesigndraw.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danieldev.myfirstdesigndraw.Pages
import com.danieldev.myfirstdesigndraw.components.MyDrawMenu
import com.danieldev.myfirstdesigndraw.database.model.ProductViewModel
import com.danieldev.myfirstdesigndraw.screens.inicio.InicioScreen
import com.danieldev.myfirstdesigndraw.screens.ofertas.OfertasScreen
import com.danieldev.myfirstdesigndraw.screens.productos.ProductosScreen
import com.danieldev.myfirstdesigndraw.utilities.LogOut

@Composable
fun MainScreen(
    navGlobalController: NavHostController,
    startDestination: String = Pages.Inicio.rute,
    viewModel: ProductViewModel
) {

    var state by remember{  mutableStateOf(true) }
    var setState: (Boolean) -> Unit = { newState ->
        state = newState
    }

    var navMainController: NavHostController = rememberNavController()
    MyDrawMenu(
        navController = navMainController,
        body = {
            NavHost(navController = navMainController, startDestination = startDestination) {
                composable(Pages.Inicio.rute) {
                    InicioScreen()
                }
                composable(Pages.Ofertas.rute) {
                    OfertasScreen()
                }
                composable(Pages.Productos.rute) {
                    ProductosScreen(viewModel=viewModel)
                }
                composable(Pages.Salir.rute) {
                    LogOut(
                        navController = navGlobalController,
                        pageDestination = "registro",
                        state = true
                    )
                }
            }
            LogOut(navController = navGlobalController, pageDestination = Pages.Salir.rute, state = false)
        },
        icon = state,
        setState = setState
    )
}

