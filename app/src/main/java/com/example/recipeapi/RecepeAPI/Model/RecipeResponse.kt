package com.example.recipeapi.RecepeAPI.Model

data class RecipeResponse (val message: String,
                          val request: Request,
                          val response: List<Response>)