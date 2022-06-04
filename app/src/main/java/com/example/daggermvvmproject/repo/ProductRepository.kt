package com.example.daggermvvmproject.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggermvvmproject.model.res.ProductsItem
import com.example.daggermvvmproject.retrofit.FakerAPI
import com.example.daggermvvmproject.roomDB.FakerDB
import com.example.daggermvvmproject.utils.Constants.TAG
import com.example.daggermvvmproject.utils.NetworkUtils
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ProductRepository @Inject constructor(
    private val api: FakerAPI,
    private val database: FakerDB,
    private val networkUtils: NetworkUtils,
    @ApplicationContext private val context: Context,
) {


    private val _product = MutableLiveData<List<ProductsItem>>()

    val product: LiveData<List<ProductsItem>>
        get() = _product

    suspend fun getProduct() {
        if (networkUtils.isOnline(context)) {
            try {

                val productResponse = api.getProducts()

                if (productResponse.isSuccessful && productResponse.body() != null) {
                    Log.d(TAG, "I Got the Response")

                    database.getFakerDAO().insertProduct(productResponse.body()!!)
                    Log.d(TAG, "Put the data into ROOM")

                    _product.postValue(productResponse.body())
                    Log.d(TAG, "Update liveDate")

                } else {
                    _product.postValue(database.getFakerDAO().getProduct())
                    Log.d(TAG, "getProduct: go to failed request")
                }
            } catch (e: Exception) {
                Log.d(TAG, "I am  in Exception and getting the data form ROOM")
                _product.postValue(database.getFakerDAO().getProduct())
                Log.d(TAG, "getProduct: go to Exception")

            }
        }

    }

}


