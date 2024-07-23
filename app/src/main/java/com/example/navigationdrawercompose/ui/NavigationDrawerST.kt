package com.example.navigationdrawercompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationdrawercompose.ui.theme.NavigationDrawerComposeTheme
import com.example.navigationdrawercompose.ui.theme.PrimaryColorLight

@Composable
fun NavigationDrawerST(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    items: List<NavigationDrawerItem>,
    drawerIndex: Int,
    onClick: (Int) -> Unit = {}
) {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.size(16.dp))
                items.forEachIndexed { index, drawerItem ->
                    androidx.compose.material3.NavigationDrawerItem(
                        label = {
                            Text(text = stringResource(id = drawerItem.title))
                        },
                        selected = index == drawerIndex,
                        onClick = { onClick(index) },
                        modifier = Modifier.padding(
                            NavigationDrawerItemDefaults.ItemPadding
                        ),
                        icon = {
                            Icon(
                                painter = if (index == drawerIndex) {
                                    painterResource(id = drawerItem.selectedIcon)
                                } else {
                                    painterResource(id = drawerItem.unselectedIcon)
                                },
                                contentDescription = null
                            )
                        },
                        badge = {
                            if (drawerItem.badge > 0) {
                                Box(
                                    modifier = Modifier
                                        .size(20.dp)
                                        .background(Color.Red, RoundedCornerShape(4.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = drawerItem.badge.toString(),
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            color = Color.White
                                        )
                                    )
                                }
                            }
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = PrimaryColorLight,
                            unselectedContainerColor = Color.Transparent
                        )
                    )
                }
            }
        },
        modifier = modifier,
        drawerState = drawerState
    ) {
    }
}

@Preview
@Composable
private fun NavigationDrawerYTPreview() {
    NavigationDrawerComposeTheme {
        val drawerState = rememberDrawerState(DrawerValue.Open)
        var drawerIndex by remember { mutableIntStateOf(0) }

        NavigationDrawerST(
            drawerState = drawerState,
            items = NavigationDrawerItem.items,
            drawerIndex = drawerIndex,
            onClick = {
                drawerIndex = it
            }
        )
    }
}