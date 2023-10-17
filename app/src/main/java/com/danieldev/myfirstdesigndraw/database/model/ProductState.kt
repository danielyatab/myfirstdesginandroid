package com.danieldev.myfirstdesigndraw.database.model

data class ProductState(
    val products: List<Product> = emptyList(),
    val productName: String = "",
    val productPrice: String = "",
    val productCategory: String = "",
    val productId: String? = null,
)
