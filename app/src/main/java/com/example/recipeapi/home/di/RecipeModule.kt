package com.example.recipeapi.home.di

import com.example.recipeapi.Network.RecipeService
import com.example.recipeapi.home.RecipeContract
import com.example.recipeapi.home.RecipePresenter
import dagger.Module
import dagger.Provides


@Module
class RecipeModule(private val view : RecipeContract.View){

    @HomeScope
    @Provides
    fun provideRecipePresenter (recipeService: RecipeService):
            RecipeContract.Presenter{
        return RecipePresenter(recipeService,view)
    }

}