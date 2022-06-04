package com.example.daggermvvmproject.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggermvvmproject.model.res.ProductsItem

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product :List<ProductsItem>)

    @Query("SELECT * FROM ProductsItem")
    suspend fun getProduct():List<ProductsItem>

}