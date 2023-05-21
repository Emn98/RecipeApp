package com.example.recipeapp.network

import com.example.recipeapp.models.MealCategory
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MealCategoryResponse {
    @Json(name = "categories")
    var categories: List<MealCategory> = listOf()
}