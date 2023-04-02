package com.pureamorous.digikala.data.db

import androidx.room.*
import com.pureamorous.digikala.data.model.basket.CartItem
import com.pureamorous.digikala.data.model.basket.CartStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCartItem(cart: CartItem)

    @Query("select * from shopping_cart where cartStatus=:status")
    fun getAllItems(status: CartStatus): Flow<List<CartItem>>

    @Delete
    suspend fun removeFromCart(item: CartItem)

    @Query("update shopping_cart set count=:newCount where itemId=:id")
    suspend fun changeCountCartItem(id: String, newCount: Int)

    @Query("update shopping_cart set cartStatus=:newCartStatus where itemId=:id")
    suspend fun changeStatusCart(id: String, newCartStatus: CartStatus)

}