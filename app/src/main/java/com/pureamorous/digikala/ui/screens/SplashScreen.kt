package com.pureamorous.digikala.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pureamorous.digikala.R
import com.pureamorous.digikala.navigation.Screen
import com.pureamorous.digikala.ui.components.Loading3Dots
import com.pureamorous.digikala.ui.theme.splashBg
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash()
    LaunchedEffect(true) {
        delay(2500)
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }
}

@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.splashBg)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(250.dp),
            painter = painterResource(id = R.drawable.digi_logo),
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(100.dp), contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_txt_white),
                contentDescription = null,
                modifier = Modifier.height(30.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp), contentAlignment = Alignment.BottomCenter
        ) {
            Loading3Dots(false)
        }
    }
}