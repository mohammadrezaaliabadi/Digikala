package com.pureamorous.digikala.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pureamorous.digikala.navigation.Screen
import com.pureamorous.digikala.ui.theme.Purple200
import com.pureamorous.digikala.ui.theme.Purple40

@Composable
fun ChangeStatusBarColor(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()
    val statusBarColor = if (!isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }

    when (navBackStackEntry?.destination?.route) {
        Screen.Splash.route -> {
            SideEffect {
                systemUiController.setStatusBarColor(color = Purple200)
            }
        }
        else -> {
            SideEffect {
                systemUiController.setStatusBarColor(color = statusBarColor)
            }

        }
    }
}