package com.danieldev.myfirstdesigndraw.screens.inicio

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.danieldev.myfirstdesigndraw.components.CardItem
import com.danieldev.myfirstdesigndraw.components.MyDrawMenu

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InicioScreen() {
    var i =1
    LazyVerticalGrid(
        modifier = Modifier.padding(10.dp),
        columns = GridCells.Adaptive(minSize = 135.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp), // Espacio vertical entre filas
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(12) {
            CardItem(i)
            i++
        }
    }
}


