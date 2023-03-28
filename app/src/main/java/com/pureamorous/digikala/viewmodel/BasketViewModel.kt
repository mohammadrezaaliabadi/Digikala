package com.pureamorous.digikala.viewmodel

import androidx.lifecycle.ViewModel
import com.pureamorous.digikala.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) : ViewModel() {


}
