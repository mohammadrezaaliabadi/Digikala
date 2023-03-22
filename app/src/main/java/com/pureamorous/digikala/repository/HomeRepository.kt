package com.pureamorous.digikala.repository

import com.pureamorous.digikala.data.model.home.AmazingItem
import com.pureamorous.digikala.data.model.home.MainCategory
import com.pureamorous.digikala.data.model.home.Slider
import com.pureamorous.digikala.data.model.home.StoreProduct
import com.pureamorous.digikala.data.remote.BaseApiResponse
import com.pureamorous.digikala.data.remote.HomeApiInterface
import com.pureamorous.digikala.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse() {

    suspend fun getSlider(): NetworkResult<List<Slider>> = safeApiCall { api.getSlider() }

    suspend fun getAmazingItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall { api.getAmazingItems() }

    suspend fun getAmazingSuperMarketItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall { api.getAmazingSuperMarketItems() }

    suspend fun getProposalBanners(): NetworkResult<List<Slider>> =
        safeApiCall { api.getProposalBanners() }

    suspend fun getCategories(): NetworkResult<List<MainCategory>> =
        safeApiCall {
            api.getCategories()
        }

    suspend fun getCenterBanners(): NetworkResult<List<Slider>> =
        safeApiCall { api.getCenterBanners() }

    suspend fun getBestSellerItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getBestSellerItems()
        }


}