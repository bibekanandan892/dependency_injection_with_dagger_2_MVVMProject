package com.example.daggermvvmproject.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggermvvmproject.model.res.ProductsItem

@Database(entities = [ProductsItem::class], version = 1)
abstract class FakerDB : RoomDatabase(){
    abstract fun getFakerDAO(): FakerDAO
}