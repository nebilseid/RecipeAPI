package com.example.recipeapi.home

import com.example.recipeapi.RecepeAPI.Model.RecipeResponse
import com.example.recipeapi.RecepeAPI.Model.Response

interface RecipeContract {
    interface View {
        fun showResults(results:List<Response>)
        fun showError(message: String)
    }

    interface Presenter {
        fun getRecipe()
    }
}