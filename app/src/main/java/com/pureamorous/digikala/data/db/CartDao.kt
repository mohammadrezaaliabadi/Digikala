package com.pureamorous.digikala.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.pureamorous.digikala.data.model.basket.CartItem

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCartItem(cart: CartItem)
}