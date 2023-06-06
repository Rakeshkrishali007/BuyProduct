package com.example.buyproduct.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.buyproduct.model.Products

@Dao
interface FakerDao {

    @Insert
    suspend fun insertProduct(products: List<Products>)

    @Query("SELECT * FROM Products")
    suspend fun getProducts(): List<Products>
}