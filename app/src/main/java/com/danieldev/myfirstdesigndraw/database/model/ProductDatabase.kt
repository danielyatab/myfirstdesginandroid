package com.danieldev.myfirstdesigndraw.database.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract val dao: ProductDao
}