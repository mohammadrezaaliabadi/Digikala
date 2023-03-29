package com.pureamorous.digikala.repository

import com.pureamorous.digikala.data.db.CartDao
import com.pureamorous.digikala.data.model.basket.CartItem
import com.pureamorous.digikala.data.model.home.StoreProduct
import com.pureamorous.digikala.data.remote.BaseApiResponse
import com.pureamorous.digikala.data.remote.BasketApiInterface
import com.pureamorous.digikala.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: BasketApiInterface,
    private val dao: CartDao
) : BaseApiResponse() {
    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }

    suspend fun insertCartItem(cart: CartItem) {
        dao.insertCartItem(cart)
    }


}
