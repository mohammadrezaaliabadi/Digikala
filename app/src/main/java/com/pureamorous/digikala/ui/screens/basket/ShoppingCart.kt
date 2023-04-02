package com.pureamorous.digikala.ui.screens.basket


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pureamorous.digikala.data.model.basket.CartItem
import com.pureamorous.digikala.data.model.basket.CartStatus
import com.pureamorous.digikala.viewmodel.BasketViewModel
import kotlinx.coroutines.flow.collectLatest


@Composable
fun ShoppingCart(viewModel: BasketViewModel = hiltViewModel()) {
    var currentCartItems by remember {
        mutableStateOf(emptyList<CartItem>())
    }

    LaunchedEffect(true) {
        viewModel.currentCartItems.collectLatest { list ->
            currentCartItems = list
        }
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 60.dp),
    ) {
        if (currentCartItems.isEmpty()){
            item { EmptyBasketShopping() }
            item { SuggestListSection() }
        }else{
            items(currentCartItems){item -> 
                CartItemCard(item = item,CartStatus.CURRENT_CART)
            }
        }


    }

}
