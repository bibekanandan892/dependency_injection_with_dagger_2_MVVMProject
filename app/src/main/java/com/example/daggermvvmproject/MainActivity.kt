package com.example.daggermvvmproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvmproject.databinding.ActivityMainBinding
import com.example.daggermvvmproject.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]

        binding.mainViewModel=mainViewModel
        binding.lifecycleOwner=this


    }
}