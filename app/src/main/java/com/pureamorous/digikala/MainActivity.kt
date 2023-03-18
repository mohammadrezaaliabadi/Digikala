package com.pureamorous.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pureamorous.digikala.navigation.BottomNavigationBar
import com.pureamorous.digikala.navigation.SetupNavGraph
import com.pureamorous.digikala.ui.components.AppConfig
import com.pureamorous.digikala.ui.components.ChangeStatusBarColor
import com.pureamorous.digikala.ui.theme.DigikalaTheme
import com.pureamorous.digikala.util.Constants.ENGLISH_LANG
import com.pureamorous.digikala.util.Constants.USER_LANGUAGE
import com.pureamorous.digikala.util.LocaleUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaTheme {
                navController = rememberNavController()
                ChangeStatusBarColor(navController = navController)
                AppConfig()
                Log.e("3636", USER_LANGUAGE)
                LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)
                val direction = if (USER_LANGUAGE == ENGLISH_LANG) {
                    androidx.compose.ui.unit.LayoutDirection.Ltr
                } else {
                    androidx.compose.ui.unit.LayoutDirection.Rtl
                }

                CompositionLocalProvider(LocalLayoutDirection provides direction) {
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
}

