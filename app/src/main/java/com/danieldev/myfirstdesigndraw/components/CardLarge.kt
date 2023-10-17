package com.danieldev.myfirstdesigndraw.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danieldev.myfirstdesigndraw.R

@Composable
fun CardLarge() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(5.dp)
            .shadow(elevation = 8.dp)
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        Image(
            modifier = Modifier
                .weight(3f)
                .padding(5.dp),
            painter = painterResource(id = R.drawable.xiamoi),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.weight(7f).padding(5.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Producto en oferta",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Terminos y condiciones", color = Color.DarkGray, fontSize = 10.sp)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                for (i in 0..3) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                }
                Icon(imageVector = Icons.Filled.FavoriteBorder, contentDescription = null)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "$123.3")
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )) {
                    Text(text = "Buy", color= MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
    }
}