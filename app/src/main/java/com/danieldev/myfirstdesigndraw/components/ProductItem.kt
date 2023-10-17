package com.danieldev.myfirstdesigndraw.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danieldev.myfirstdesigndraw.database.model.Product

@Composable
fun ProductItem(
    product: Product,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colorScheme.onPrimary)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .weight(2f),
            imageVector = Icons.Filled.Info,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )

        Column(modifier=Modifier.weight(4f).padding(start = 5.dp), horizontalAlignment = Alignment.Start) {
            Text(text = "${product.name}", color = MaterialTheme.colorScheme.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "S/${product.price}")
            Text(text = "${product.category}")
        }

        Box(modifier=Modifier.weight(4f), contentAlignment = Alignment.CenterEnd) {
            Row(modifier = Modifier.padding(10.dp)) {
                IconButton(
                    onClick = onEdit,
                    modifier = Modifier.background(
                        color = Color.Blue,
                        shape = RoundedCornerShape(5.dp)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                IconButton(
                    onClick = onDelete,
                    modifier = Modifier.background(
                        color = Color(0xffD5573B),
                        shape = RoundedCornerShape(5.dp)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.White
                    )
                }
            }
        }
    }
}
