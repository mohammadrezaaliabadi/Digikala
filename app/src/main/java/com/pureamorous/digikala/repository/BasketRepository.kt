package com.pureamorous.digikala.repository

import com.pureamorous.digikala.data.model.home.StoreProduct
import com.pureamorous.digikala.data.remote.BaseApiResponse
import com.pureamorous.digikala.data.remote.BasketApiInterface
import com.pureamorous.digikala.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(private val api: BasketApiInterface) : BaseApiResponse() {
    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }



}
