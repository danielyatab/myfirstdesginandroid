package com.danieldev.myfirstdesigndraw.screens.ofertas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.danieldev.myfirstdesigndraw.components.CardLarge
import com.danieldev.myfirstdesigndraw.components.MyDrawMenu

@Composable
fun OfertasScreen() {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
    ) {
        items(20){
            CardLarge()
        }
    }
}