package com.pureamorous.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pureamorous.digikala.data.model.basket.CartItem
import com.pureamorous.digikala.data.model.basket.CartStatus
import com.pureamorous.digikala.data.model.home.StoreProduct
import com.pureamorous.digikala.data.remote.NetworkResult
import com.pureamorous.digikala.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) : ViewModel() {


    val suggestedList = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())
    val currentCartItems: Flow<List<CartItem>> = repository.currentCartItems
    val nextCartItems:Flow<List<CartItem>> = repository.nextCartItems
    fun getSuggestedItems(){
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItems())
        }
    }

    fun insertCartItem(cart: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCartItem(cart)
        }
    }
    fun removeCartItem(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFromCart(item)
        }
    }

    fun changeCartItemCount(id: String, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCartItemCount(id, newCount)
        }
    }

    fun changeCartItemStatus(id: String, newStatus: CartStatus) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCartItemStatus(id, newStatus)
        }
    }



}
