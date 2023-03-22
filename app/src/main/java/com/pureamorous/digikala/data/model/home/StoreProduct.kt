package com.pureamorous.digikala.data.model.home

data class StoreProduct(
    val _id: String,
    val name: String,
    val seller: String,
    val price: Long,
    val discountPercent: Int,
    val image: String,
)
