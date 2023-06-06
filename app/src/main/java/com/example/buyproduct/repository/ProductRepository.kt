package com.example.buyproduct.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.buyproduct.db.FakerDb
import com.example.buyproduct.model.Products
import com.example.buyproduct.retrofit.FakerApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val  fakerApi: FakerApi,private val fakerDb: FakerDb) {

    private val _products =MutableLiveData<List<Products>>()
    val products:LiveData<List<Products>>
    get() = _products

    suspend fun getProductList()
    {
        val result = fakerApi.getProducts()

        if(result.isSuccessful && result.body() != null){
            fakerDb.getFakerDao().insertProduct(result.body()!!)
            _products.postValue(result.body())
        }
    }
}