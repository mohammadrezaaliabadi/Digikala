package com.pureamorous.digikala.ui.screens.home

import android.util.Log
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.pureamorous.digikala.data.model.home.Slider
import com.pureamorous.digikala.data.remote.NetworkResult
import com.pureamorous.digikala.ui.components.CenterBannerItem
import com.pureamorous.digikala.viewmodel.HomeViewModel

@Composable
fun CenterBannerSection(bannerNumber: Int, viewModel: HomeViewModel = hiltViewModel()) {
    var centerBannerList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val centerBannerResult by viewModel.centerBannerItems.collectAsState()

    when (centerBannerResult) {
        is NetworkResult.Success -> {
            centerBannerList = centerBannerResult.data ?: emptyList()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "CenterBannerItem error : ${centerBannerResult.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }

    if (centerBannerList.isNotEmpty()) {
        CenterBannerItem(imageUrl = centerBannerList[bannerNumber - 1].image)
    }
}