package com.example.daggermvvmproject.model.res

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductsItem(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)