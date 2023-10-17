package com.danieldev.myfirstdesigndraw.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danieldev.myfirstdesigndraw.R

@Composable
fun CardItem(index: Int) {
    Card(modifier = Modifier
        .width(120.dp)
        .height(200.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp)
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
                Text(text = "Producto ${index}")
            }
            Image(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .weight(7f)
                    .clip(RoundedCornerShape(8.dp)),
                painter = painterResource(id = R.drawable.xiamoi),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "$12.5")
                Button(onClick = { }) {
                    Text(text = "Buy",color=MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
    }
}