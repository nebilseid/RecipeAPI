package com.example.recipeapi.di

import com.example.recipeapi.Network.RecipeService
import dagger.Component
import javax.inject.Singleton


@Component(modules = [NetworkModule::class])

@Singleton
interface AppComponent {
    fun recipeService(): RecipeService

}