package com.example.recipeapi.Network

import com.example.recipeapi.RecepeAPI.Model.RecipeResponse
import com.example.recipeapi.RecepeAPI.Model.Response
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RecipeService {
@GET(RECIPE_ENDPOINT)
fun getRecipe(): Observable<RecipeResponse>


}