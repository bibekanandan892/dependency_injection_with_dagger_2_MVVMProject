package com.example.daggermvvmproject.retrofit

import com.example.daggermvvmproject.model.res.ProductsItem
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {
    @GET("products")
    suspend fun getProducts(): Response<List<ProductsItem>>
}