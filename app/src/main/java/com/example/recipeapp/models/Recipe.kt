package com.example.recipeapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(

    @Json(name = "idMeal")
    var id: Int,

    @Json(name = "strMeal")
    var recipeName: String,

    @Json(name = "strMealThumb")
    var thumbNailPath: String


) : Parcelable
