package com.pureamorous.digikala.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pureamorous.digikala.R
import com.pureamorous.digikala.ui.theme.selectedBottomBar
import com.pureamorous.digikala.ui.theme.unSelectedBottomBar

@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem(

            name = stringResource(id = R.string.home),
            route = Screen.Home.route,
            selectedIcon = painterResource(id = R.drawable.home_fill),
            deSelectedIcon = painterResource(id = R.drawable.home_outline)
        ),
        BottomNavItem(
            name = stringResource(id = R.string.category),
            route = Screen.Category.route,
            selectedIcon = painterResource(id = R.drawable.category_fill),
            deSelectedIcon = painterResource(id = R.drawable.category_outline)
        ),
        BottomNavItem(
            name = stringResource(id = R.string.basket),
            route = Screen.Basket.route,
            selectedIcon = painterResource(id = R.drawable.cart_fill),
            deSelectedIcon = painterResource(id = R.drawable.cart_outline)
        ),
        BottomNavItem(
            name = stringResource(id = R.string.my_digikala),
            route = Screen.Profile.route,
            selectedIcon = painterResource(id = R.drawable.user_fill),
            deSelectedIcon = painterResource(id = R.drawable.user_outline)
        )
    )
    
    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map { it.route }
    
    if (showBottomBar){
        BottomNavigation(modifier=Modifier, backgroundColor = Color.White, elevation = 5.dp) {
            items.forEachIndexed { index, item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(selected =selected , onClick = { onItemClick(item) },
                    selectedContentColor = androidx.compose.material.MaterialTheme.colors.selectedBottomBar,
                    unselectedContentColor = androidx.compose.material.MaterialTheme.colors.unSelectedBottomBar,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (selected) {
                            Icon(
                                modifier = Modifier.height(24.dp),
                                painter = item.selectedIcon,
                                contentDescription = item.name
                            )
                        } else {
                            Icon(
                                modifier = Modifier.height(24.dp),
                                painter = item.deSelectedIcon,
                                contentDescription = item.name
                            )
                        }
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }
                })
            }
            
        }
    }
}