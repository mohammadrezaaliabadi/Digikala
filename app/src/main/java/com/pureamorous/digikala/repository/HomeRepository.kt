package com.pureamorous.digikala.repository

import com.pureamorous.digikala.data.model.home.Slider
import com.pureamorous.digikala.data.remote.BaseApiResponse
import com.pureamorous.digikala.data.remote.HomeApiInterface
import com.pureamorous.digikala.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse() {

    suspend fun getSlider(): NetworkResult<List<Slider>> = safeApiCall { api.getSlider() }
}