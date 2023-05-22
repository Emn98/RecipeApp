package com.example.recipeapp.network

import com.example.recipeapp.models.RecipeDetail
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class RecipeDetailResponse {
    @Json(name = "meals")
    var recipeDetail: List<RecipeDetail> = listOf()
}