package com.pureamorous.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pureamorous.digikala.navigation.BottomNavigationBar
import com.pureamorous.digikala.navigation.SetupNavGraph
import com.pureamorous.digikala.ui.theme.DigikalaTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaTheme {
                navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController, onItemClick = {
                            navController.navigate(it.route)
                        })
                    }
                ) {
                    SetupNavGraph(navController = navController)
                }

            }
        }
    }
}

