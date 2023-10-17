package com.danieldev.myfirstdesigndraw.database.model

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.UUID

class ProductViewModel(
    private val dao:ProductDao
): ViewModel() {
    var state by mutableStateOf(ProductState())
        private set

    init {
        viewModelScope.launch {
            dao.getAllProducts().collectLatest {
                state = state.copy(
                    products = it
                )
            }
        }
    }

    fun changeName(name: String) {
        state = state.copy(
            productName = name
        )
    }

    fun changePrice(price: String) {
        state = state.copy(
            productPrice = price
        )
    }

    fun changeCategory(category: String) {
        state = state.copy(
            productCategory = category
        )
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            dao.deleteProduct(product)
        }
    }

    fun editProduct(product: Product, setTextButton: (String)->Unit) {
        state = state.copy(
            productName = product.name,
            productPrice = product.price.toString(),
            productCategory = product.category.toString(),
            productId = product.id
        )
        setTextButton("Confirmar Cambios")
    }

    fun createProduct() {
        val product =
            Product(
                state.productId ?: UUID.randomUUID().toString(),
                state.productName,
                state.productPrice.toDouble(),
                state.productCategory
            )
        viewModelScope.launch {
            dao.insertProduct(product)
        }
        state = state.copy(
            productName = "",
            productPrice = "",
            productCategory = "",
            productId = null
        )
    }
}