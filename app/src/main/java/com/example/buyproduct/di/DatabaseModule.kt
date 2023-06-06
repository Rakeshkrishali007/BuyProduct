package com.example.buyproduct.di

import android.content.Context
import androidx.room.Room
import com.example.buyproduct.db.FakerDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun  provideFakerDB(context:Context):FakerDb
    {
        return Room.databaseBuilder(context, FakerDb::class.java,"FakerDB").build()
    }
}