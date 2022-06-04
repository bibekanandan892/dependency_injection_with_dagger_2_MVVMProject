package com.example.daggermvvmproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggermvvmproject.model.res.ProductsItem
import com.example.daggermvvmproject.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productRepository: ProductRepository) :ViewModel() {

    val products : LiveData<List<ProductsItem>>
    get() = productRepository.product


    fun getData(){
        viewModelScope.launch(Dispatchers.IO){
            productRepository.getProduct()
        }
    }


}