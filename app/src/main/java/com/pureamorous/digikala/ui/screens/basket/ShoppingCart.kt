package com.pureamorous.digikala.ui.screens.basket


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pureamorous.digikala.data.model.basket.CartItem
import com.pureamorous.digikala.data.model.basket.CartStatus
import com.pureamorous.digikala.ui.theme.darkText
import com.pureamorous.digikala.ui.theme.spacing
import com.pureamorous.digikala.viewmodel.BasketViewModel
import com.pureamorous.digikala.R


@Composable
fun ShoppingCart(viewModel: BasketViewModel = hiltViewModel()) {

    val cartDetail = viewModel.cartDetail.collectAsState()
    val currentCartItemsState: BasketScreenState<List<CartItem>> by viewModel.currentCartItems
        .collectAsState(BasketScreenState.Loading)


    var currentCartItems by remember {
        mutableStateOf(emptyList<CartItem>())
    }



    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 60.dp),
        ) {


            when (currentCartItemsState) {
                is BasketScreenState.Success -> {
                    if ((currentCartItemsState as BasketScreenState.Success<List<CartItem>>).data.isEmpty()) {
                        item { EmptyBasketShopping() }
                        item { SuggestListSection() }
                    } else {

                        items((currentCartItemsState as BasketScreenState.Success<List<CartItem>>).data) { item ->
                            CartItemCard(item, CartStatus.CURRENT_CART)
                        }

                        item {
                            CartPriceDetailSection(cartDetail.value)
                        }
                    }
                }
                is BasketScreenState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .height(LocalConfiguration.current.screenHeightDp.dp - 60.dp)
                                .fillMaxWidth()
                                .padding(vertical = MaterialTheme.spacing.small),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(R.string.please_wait),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.darkText,
                            )
                        }
                    }
                }
                is BasketScreenState.Error -> {
                    Log.e("3636", "err")
                }
            }


        }

        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp)
        ) {
            BuyProcessContinue(cartDetail.value.payablePrice)
        }
    }
}
