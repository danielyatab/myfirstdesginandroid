package com.danieldev.myfirstdesigndraw.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.danieldev.myfirstdesigndraw.ListPages
import com.danieldev.myfirstdesigndraw.Pages
import com.danieldev.myfirstdesigndraw.R
import com.danieldev.myfirstdesigndraw.utilities.currentRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawMenu(
    navController: NavHostController,
    listPages: List<Pages> = ListPages.listItems,
    body: @Composable () -> Unit,
    icon: Boolean,
    setState:(Boolean)->Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MyDrawer(
                drawerState = drawerState,
                scope = scope,
                navController = navController,
                listItems = listPages
            )
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .shadow(elevation = 4.dp),
                    title = {
                        val currentRoute = currentRoute(navController)
                        Text(
                            text = currentRoute.toString().toUpperCase(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Buscar",
                                tint = Color.Black
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                if (icon) {
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                } else {
                                    navController.popBackStack()
                                    setState(true)
                                }
                            },
                            modifier = Modifier.padding(end = 16.dp)
                        ) {
                            if (icon) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Menú",
                                    tint = Color.Black
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Menú",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                )
            },
        ) { contentPading ->
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPading)
            ) {
                body()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    navController: NavHostController,
    listItems: List<Pages>,
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .background(MaterialTheme.colorScheme.background),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.marketphone),
                    modifier = Modifier
                        .size(200.dp),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            val currentRoute = currentRoute(navController)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(7f)
                    .background(Color.Transparent),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                listItems.forEach { page ->
                    DrawerItem(
                        page = page,
                        selected = currentRoute == page.rute,
                        height = 50.dp
                    ) {
                        navController.navigate(page.rute) {
                            //Close Draw Menu
                            launchSingleTop = true
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DrawerItem(
    page: Pages,
    selected: Boolean,
    height: Dp,
    onItemClick: (Pages) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(if (selected) Color.DarkGray.copy(alpha = 0.5f) else Color.White)
            .padding(horizontal = 18.dp)
            .clickable {
                onItemClick(page)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(42.dp),
            imageVector = page.icon,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = page.title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}



