package com.example.buyproduct.retrofit

import com.example.buyproduct.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend  fun getProducts():Response<List<Products>>
}