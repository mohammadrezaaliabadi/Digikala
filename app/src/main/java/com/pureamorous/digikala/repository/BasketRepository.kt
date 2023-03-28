package com.pureamorous.digikala.repository

import com.pureamorous.digikala.data.remote.BaseApiResponse
import com.pureamorous.digikala.data.remote.BasketApiInterface
import javax.inject.Inject

class BasketRepository @Inject constructor(private val api: BasketApiInterface) : BaseApiResponse() {



}
