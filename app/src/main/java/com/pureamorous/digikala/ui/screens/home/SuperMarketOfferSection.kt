package com.pureamorous.digikala.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.pureamorous.digikala.R
import androidx.hilt.navigation.compose.hiltViewModel
import com.pureamorous.digikala.data.model.home.AmazingItem
import com.pureamorous.digikala.data.remote.NetworkResult
import com.pureamorous.digikala.ui.theme.DigikalaLightGreen
import com.pureamorous.digikala.ui.theme.DigikalaLightRed
import com.pureamorous.digikala.viewmodel.HomeViewModel

@Composable
fun SuperMarketOfferSection(viewModel: HomeViewModel = hiltViewModel()) {

    var superMarketItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val superMarketItemResult by viewModel.superMarketItems.collectAsState()
    when (superMarketItemResult) {
        is NetworkResult.Success -> {
            superMarketItemList = superMarketItemResult.data ?: emptyList()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "superMarketOfferSection error : ${superMarketItemResult.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.DigikalaLightRed)
    ) {
        LazyRow(modifier = Modifier.background(MaterialTheme.colorScheme.DigikalaLightGreen)) {

            item {
                AmazingOfferCard(
                    topImageResId = R.drawable.supermarketamazings,
                    bottomImageResId = R.drawable.fresh
                )
            }

            items(superMarketItemList) { item ->
                AmazingItem(item = item)
            }


            item {
                AmazingShowMoreItem()
            }


        }


    }

}