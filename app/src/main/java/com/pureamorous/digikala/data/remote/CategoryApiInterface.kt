package com.pureamorous.digikala.data.remote

import com.pureamorous.digikala.data.model.ResponseResult
import com.pureamorous.digikala.data.model.category.SubCategory
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApiInterface {
    @GET("v1/getSubCategories")
    suspend fun getSubcategories(): Response<ResponseResult<SubCategory>>
}