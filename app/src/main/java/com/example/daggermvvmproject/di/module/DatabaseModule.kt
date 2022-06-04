package com.example.daggermvvmproject.di.module

import android.content.Context
import androidx.room.Room
import com.example.daggermvvmproject.roomDB.FakerDB
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun getFakerDB(@ApplicationContext context :Context):FakerDB{
        return Room.databaseBuilder(context,FakerDB::class.java,"FakerDB").build()
    }
}