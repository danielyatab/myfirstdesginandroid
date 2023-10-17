package com.danieldev.myfirstdesigndraw.screens.registro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun RegistroScreen(
    navGlobalController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(modifier = Modifier.size(250.dp).padding(5.dp),imageVector = Icons.Filled.CheckCircle, contentDescription =null, tint = MaterialTheme.colorScheme.onPrimary)
        Text(text = "Thank You For registration", color=MaterialTheme.colorScheme.onPrimary)
        Button(
            onClick = { navGlobalController.navigate("main") },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary)
        ) {
            Text(text = "Go to Your Acces!", color = MaterialTheme.colorScheme.primary)
        }
    }
}