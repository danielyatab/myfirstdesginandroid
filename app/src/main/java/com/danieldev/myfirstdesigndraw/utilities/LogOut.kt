package com.danieldev.myfirstdesigndraw.utilities

import androidx.activity.compose.BackHandler
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController

@Composable
fun LogOut(
    navController: NavController,
    pageDestination: String,
    state: Boolean
) {
    val showDialog = remember { mutableStateOf(state) }
    val currentRoute = currentRoute(navController = navController)

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            title = { Text("Confirmar salida") },
            text = { Text("¿Estás seguro de que quieres volver al Login?") },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                        if(state) navController.navigate(pageDestination)
                    }
                ) {
                    Text("Sí")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                        if(state) navController.popBackStack() else navController.navigate(currentRoute!!)
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }

    BackHandler {
        showDialog.value = !showDialog.value
    }
}

