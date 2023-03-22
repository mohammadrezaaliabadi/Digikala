package com.pureamorous.digikala.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple200 = Color(0xFFed1b34)
val Purple500 = Color(0xFFCE3C4D)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val ColorScheme.splashBg: Color
    @Composable
    get() = Color(0xFFed1b34)

val ColorScheme.selectedBottomBar: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFF43474C) else Color(0xFFCFD4DA)

val ColorScheme.unSelectedBottomBar: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFFA4A1A1) else Color(0xFF575A5E)
val ColorScheme.bottomBar: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFFFFFFFF) else Color(0xFF303235)


val ColorScheme.searchBarBg: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFFF1F0EE) else Color(0xFF303235)
val ColorScheme.darkText: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFF414244) else Color(0xFFD8D8D8)

val ColorScheme.amber:Color
    @Composable
    get() =  Color(0xffFFBF00)

val ColorScheme.grayCategory:Color
    @Composable
    get() = Color(0xFFF1F0EE)

val ColorScheme.DigikalaLightRed:Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xffef4056) else Color(0xFF8D2633)
val ColorScheme.DigikalaLightRedText:Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xffef4056) else Color(0xFFFFFFFF)

val ColorScheme.DigikalaDarkRed: Color
    @Composable
    get() = Color(0xFFe6123d)

val ColorScheme.semiDarkText: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFF5C5E61) else Color(0xFFD8D8D8)


val ColorScheme.DarkCyan: Color
    @Composable
    get() = Color(0xFF0fabc6)

val ColorScheme.DigikalaLightGreen: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xff86bf3c) else Color(0xFF3A531A)





