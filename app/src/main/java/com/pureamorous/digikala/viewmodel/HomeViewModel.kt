package com.pureamorous.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pureamorous.digikala.data.model.home.AmazingItem
import com.pureamorous.digikala.data.model.home.MainCategory
import com.pureamorous.digikala.data.model.home.Slider
import com.pureamorous.digikala.data.model.home.StoreProduct
import com.pureamorous.digikala.data.remote.NetworkResult
import com.pureamorous.digikala.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val amazingItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val banners = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val superMarketItems =
        MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val categories = MutableStateFlow<NetworkResult<List<MainCategory>>>(NetworkResult.Loading())
    val centerBannerItems = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val bestSellerItems = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())
    val mostVisitedItems = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())
    val mostFavoriteItems = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    suspend fun getSlider() {
        viewModelScope.launch {
            launch {
                slider.emit(repository.getSlider())
            }

            launch {
                amazingItems.emit(repository.getAmazingItems())
            }
            launch {
                banners.emit(repository.getProposalBanners())
            }
            launch {
                superMarketItems.emit(repository.getAmazingSuperMarketItems())
            }

            launch {
                centerBannerItems.emit(repository.getCenterBanners())
            }

            launch {
                bestSellerItems.emit(repository.getBestSellerItems())
            }

            launch {
                mostVisitedItems.emit(repository.getMostVisitedItems())
            }

            launch {
                mostFavoriteItems.emit(repository.getMostFavoriteItems())
            }


        }
    }
}