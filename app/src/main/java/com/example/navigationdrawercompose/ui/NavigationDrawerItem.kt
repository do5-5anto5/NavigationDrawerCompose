package com.example.navigationdrawercompose.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.navigationdrawercompose.R

sealed class NavigationDrawerItem(
    val type: NavigationDrawerType,
    val badge: Int,
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
) {

    data object Home : NavigationDrawerItem(
        type = NavigationDrawerType.HOME,
        badge = 0,
        title = R.string.label_home_navigation_drawer_item,
        selectedIcon = R.drawable.home_2_fill,
        unselectedIcon = R.drawable.home_2_line
    )

    data object Search : NavigationDrawerItem(
        type = NavigationDrawerType.SEARCH,
        badge = 0,
        title = R.string.label_search_navigation_drawer_item,
        selectedIcon = R.drawable.search_fill,
        unselectedIcon = R.drawable.search_line
    )

    data object Notification : NavigationDrawerItem(
        type = NavigationDrawerType.NOTIFICATION,
        badge = 0,
        title = R.string.label_notifications_navigation_drawer_item,
        selectedIcon = R.drawable.notification_2_fill,
        unselectedIcon = R.drawable.notification_2_line
    )

    data object Order: NavigationDrawerItem(
        type = NavigationDrawerType.ORDER,
        badge = 0,
        title = R.string.label_orders_navigation_drawer_item,
        selectedIcon = R.drawable.shopping_bag_4_fill,
        unselectedIcon = R.drawable.shopping_bag_4_line
    )

    data object Favorite: NavigationDrawerItem(
        type = NavigationDrawerType.FAVORITE,
        badge = 0,
        title = R.string.label_favorite_navigation_drawer_item,
        selectedIcon = R.drawable.heart_3_fill,
        unselectedIcon = R.drawable.heart_3_line
    )

    enum class NavigationDrawerType {
        HOME,
        SEARCH,
        NOTIFICATION,
        ORDER,
        FAVORITE
    }

    companion object {
        val items = listOf(
            Home,
            Search,
            Notification,
            Order,
            Favorite
        )
    }
}