package com.danieldev.myfirstdesigndraw.screens.productos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danieldev.myfirstdesigndraw.components.ProductItem
import com.danieldev.myfirstdesigndraw.database.model.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductosScreen(
    viewModel: ProductViewModel
) {
    val state = viewModel.state
    var textButton by remember { mutableStateOf("Agregar Producto") }
    var setTextButton: (String) -> Unit = { newText ->
        textButton = newText
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Mis Productos", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item(){
                Column(verticalArrangement = Arrangement.spacedBy(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    TextField(
                        value = state.productName,
                        onValueChange = { viewModel.changeName(it) },
                        placeholder = { Text(text = "Nombre del producto") }
                    )
                    TextField(
                        value = state.productPrice,
                        onValueChange = { viewModel.changePrice(it) },
                        placeholder = { Text(text = "Precio") }
                    )
                    TextField(
                        value = state.productCategory,
                        onValueChange = { viewModel.changeCategory(it) },
                        placeholder = { Text(text = "Categoria") }
                    )
                    Button(
                        onClick = {
                            viewModel.createProduct()
                            if (textButton != "Agregar Producto") {
                                textButton = "Agregar Producto"
                            }
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(text = textButton, color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.products) {
                ProductItem(product = it, modifier = Modifier.fillMaxWidth(), onEdit = {
                    viewModel.editProduct(it, setTextButton = setTextButton)
                }, onDelete = {
                    viewModel.deleteProduct(it)
                })
            }
        }
    }
}