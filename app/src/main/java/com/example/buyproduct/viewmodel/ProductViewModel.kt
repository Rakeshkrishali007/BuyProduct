package com.example.buyproduct.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buyproduct.model.Products
import com.example.buyproduct.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private  val repository: ProductRepository):ViewModel() {

    val productsLiveData:LiveData<List<Products>>
    get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProductList()
        }
    }

}