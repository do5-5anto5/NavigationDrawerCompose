package com.example.navigationdrawercompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.navigationdrawercompose.ui.theme.NavigationDrawerComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationDrawerComposeTheme {
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                var drawerIndex by remember { mutableIntStateOf(0) }
                val scope = rememberCoroutineScope()

                NavigationDrawerST(
                    drawerState = drawerState,
                    items = NavigationDrawerItem.items,
                    drawerIndex = drawerIndex,
                    content = {
                        Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = { },
                                    navigationIcon = {
                                        IconButton(
                                            onClick = {
                                                if (drawerState.isClosed) {
                                                    scope.launch {
                                                        drawerState.open()
                                                    }
                                                }
                                            },
                                            content = {
                                                Icon(
                                                    imageVector = Icons.Default.Menu,
                                                    contentDescription = null
                                                )
                                            }
                                        )
                                    }
                                )
                            },
                            content = { paddingValues ->
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(paddingValues),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(id = NavigationDrawerItem.items[drawerIndex].title)
                                    )
                                }
                            }
                        )
                    },
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            drawerIndex = it
                        }
                    }
                )
            }
        }
    }
}