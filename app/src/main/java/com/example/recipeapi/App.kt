package com.example.recipeapi

import android.app.Application
import com.example.recipeapi.di.AppComponent
import com.example.recipeapi.di.DaggerAppComponent


class App: Application(){
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()

    }
    fun getComponent()=appComponent
}