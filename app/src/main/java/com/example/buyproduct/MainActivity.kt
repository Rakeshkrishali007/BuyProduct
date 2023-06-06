package com.example.buyproduct

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buyproduct.adapter.ProductAdapter
import com.example.buyproduct.databinding.ActivityMainBinding
import com.example.buyproduct.model.Products
import com.example.buyproduct.viewmodel.ProductViewModel
import com.example.buyproduct.viewmodel.ProductViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var productViewModel: ProductViewModel
    lateinit var productAdapter: ProductAdapter
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var productViewModelFactory: ProductViewModelFactory

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productsRecyclerview.layoutManager = LinearLayoutManager(this)


        (application as  FakerApplication).applicationComponent.inject(this)

        productViewModel = ViewModelProvider(this,productViewModelFactory)[ProductViewModel::class.java]

        productViewModel.productsLiveData.observe(this, Observer {

            productAdapter = ProductAdapter(it as ArrayList<Products>, this)
            binding.productsRecyclerview.adapter = productAdapter

        })


    }
}