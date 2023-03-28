package com.pureamorous.digikala.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pureamorous.digikala.data.model.basket.CartItem


@Database(entities = [CartItem::class], version = 1, exportSchema = false)
abstract class DigikalaDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}
