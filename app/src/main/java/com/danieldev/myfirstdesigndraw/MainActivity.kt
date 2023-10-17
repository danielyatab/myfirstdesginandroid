package com.danieldev.myfirstdesigndraw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.danieldev.myfirstdesigndraw.database.model.ProductDatabase
import com.danieldev.myfirstdesigndraw.database.model.ProductViewModel
import com.danieldev.myfirstdesigndraw.navigation.AppGlobalNavigation
import com.danieldev.myfirstdesigndraw.ui.theme.MyFirstDesignDrawTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstDesignDrawTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database =
                        Room.databaseBuilder(this, ProductDatabase::class.java, "product_db")
                            .build()
                    val dao = database.dao
                    val viewModel by viewModels<ProductViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return ProductViewModel(dao) as T
                            }
                        }
                    })
                    AppGlobalNavigation(viewModel = viewModel)
                }
            }
        }
    }
}

