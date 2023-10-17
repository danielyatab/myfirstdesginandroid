package com.danieldev.myfirstdesigndraw

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Pages(var rute:String, var title:String, var icon: ImageVector){
    object Inicio:Pages(rute="inicio", title = "Inicio", icon = Icons.Filled.Home)
    object Ofertas:Pages(rute="ofertas", title = "Ofertas", icon = Icons.Filled.Notifications)
    object Productos:Pages(rute="productos", title = "Productos", icon = Icons.Filled.ShoppingCart)
    object Salir:Pages(rute="salir", title = "Salir", icon = Icons.Filled.ExitToApp)
}
