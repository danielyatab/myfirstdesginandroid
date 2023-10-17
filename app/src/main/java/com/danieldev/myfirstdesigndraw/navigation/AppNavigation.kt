package com.danieldev.myfirstdesigndraw.navigation

import android.graphics.pdf.PdfDocument.Page
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danieldev.myfirstdesigndraw.Pages
import com.danieldev.myfirstdesigndraw.database.model.ProductViewModel
import com.danieldev.myfirstdesigndraw.screens.MainScreen
import com.danieldev.myfirstdesigndraw.screens.inicio.InicioScreen
import com.danieldev.myfirstdesigndraw.screens.ofertas.OfertasScreen
import com.danieldev.myfirstdesigndraw.screens.productos.ProductosScreen
import com.danieldev.myfirstdesigndraw.screens.registro.RegistroScreen
import com.danieldev.myfirstdesigndraw.utilities.LogOut

@Composable
fun AppGlobalNavigation(
    navGlobalController: NavHostController = rememberNavController(),
    viewModel: ProductViewModel
) {
    val startDestination = "registro"
    NavHost(navController = navGlobalController, startDestination = startDestination) {
        composable("registro") {
            RegistroScreen(navGlobalController= navGlobalController)
        }
        composable("main") {
            MainScreen(navGlobalController = navGlobalController, viewModel=viewModel)
        }
    }
}

