package com.pureamorous.digikala.ui.screens.basket

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pureamorous.digikala.ui.theme.selectedBottomBar
import com.pureamorous.digikala.viewmodel.BasketViewModel
import com.pureamorous.digikala.R
import com.pureamorous.digikala.ui.theme.digikalaRed
import com.pureamorous.digikala.ui.theme.spacing

@Composable
fun BasketScreen(navController: NavHostController) {

    Basket(navController = navController)
}

@Composable
fun Basket(navController: NavHostController, viewModel: BasketViewModel = hiltViewModel()) {
    val currentCartItemsCount by viewModel.currentCartItemsCount.collectAsState(initial = 0)
    val nextCartItemsCount by viewModel.nextCartItemsCount.collectAsState(0)
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val tabTitles = listOf(
        stringResource(id = R.string.cart),
        stringResource(id = R.string.next_cart_list)
    )

    Column {
        TabRow(
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.medium),
            selectedTabIndex = selectedTabIndex,
            contentColor = MaterialTheme.colorScheme.digikalaRed,
            containerColor = Color.White, indicator = { line ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(line[selectedTabIndex])
                        .height(3.dp)
                        .background(Color.Red)
                )
            }) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = (selectedTabIndex == index),
                    onClick = {
                        selectedTabIndex = index
                    },
                    selectedContentColor = MaterialTheme.colorScheme.digikalaRed,
                    unselectedContentColor = Color.Gray,
                    text = {
                        Row {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold,
                            )
                            val cartCounter = if (index == 0) {
                                currentCartItemsCount
                            } else {
                                nextCartItemsCount
                            }

                            if (cartCounter > 0) {
                                Spacer(modifier = Modifier.width(10.dp))
                                SetBadgeToTab(
                                    selectedTabIndex = selectedTabIndex,
                                    index = index,
                                    cartCounter = cartCounter
                                )
                            }

                        }
                    }
                )

            }
        }
        when (selectedTabIndex) {
            0 -> ShoppingCart()
            1 -> NextShoppingList()
        }

    }
}
