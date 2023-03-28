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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.pureamorous.digikala.R
import com.pureamorous.digikala.data.model.home.AmazingItem
import com.pureamorous.digikala.data.remote.NetworkResult
import com.pureamorous.digikala.ui.theme.DigikalaLightRed
import com.pureamorous.digikala.util.Constants
import com.pureamorous.digikala.viewmodel.HomeViewModel

@Composable
fun AmazingOfferSection(viewModel: HomeViewModel = hiltViewModel()) {
    var amazingItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }
    val amazingItemResult by viewModel.amazingItems.collectAsState()
    when (amazingItemResult) {
        is NetworkResult.Success -> {

            amazingItemList = amazingItemResult.data ?: emptyList()
            loading = false
            Log.e("3636", "item : ${amazingItemList[0].name}")

        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "AmazingOfferSection error : ${amazingItemResult.message}")

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
        LazyRow(modifier = Modifier.background(MaterialTheme.colorScheme.DigikalaLightRed)) {
            item {
                AmazingOfferCard(R.drawable.amazings, R.drawable.box)
            }
            items(amazingItemList) { item ->
                AmazingItem(item = item)
            }
            item {
                AmazingShowMoreItem()
            }

        }

    }

}

@Composable
fun AmazingLogoChangeByLanguage(): Painter {
    return if (Constants.USER_LANGUAGE == Constants.ENGLISH_LANG) {
        painterResource(id = R.drawable.amazing_en)
    } else {
        painterResource(id = R.drawable.amazings)
    }
}

