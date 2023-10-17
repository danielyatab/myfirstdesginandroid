package com.danieldev.myfirstdesigndraw.database.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)
    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<Product>>
    @Delete
    suspend fun deleteProduct(product: Product)
}