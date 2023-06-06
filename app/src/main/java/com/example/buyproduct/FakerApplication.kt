package com.example.buyproduct

import android.app.Application
import com.example.buyproduct.di.ApplicationComponent
import com.example.buyproduct.di.DaggerApplicationComponent
import dagger.Component

class  FakerApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}