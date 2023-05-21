package com.example.recipeapp.network

import com.example.recipeapp.models.MealCategory
import com.example.recipeapp.models.Recipe
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class RecipeResponse {
    @Json(name = "meals")
    var recipes: List<Recipe> = listOf()
}