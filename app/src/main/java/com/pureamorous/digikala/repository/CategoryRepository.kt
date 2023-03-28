package com.pureamorous.digikala.repository

import com.pureamorous.digikala.data.model.category.SubCategory
import com.pureamorous.digikala.data.remote.BaseApiResponse
import com.pureamorous.digikala.data.remote.CategoryApiInterface
import com.pureamorous.digikala.data.remote.NetworkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: CategoryApiInterface) :
    BaseApiResponse() {
    suspend fun getSubCategories(): NetworkResult<SubCategory> =
        safeApiCall { api.getSubcategories() }
}