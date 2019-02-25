package com.example.recipeapi.home.di

import com.example.recipeapi.di.AppComponent
import com.example.recipeapi.home.MainActivity
import dagger.Component


@Component(dependencies = [AppComponent::class],modules =[RecipeModule::class])
@HomeScope

interface RecipeComponent {
    fun inject (mainActivity: MainActivity)
}