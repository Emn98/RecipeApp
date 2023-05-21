package com.example.recipeapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeDetail(

    @Json(name = "idMeal")
    var id: Int,

    @Json(name = "strMeal")
    var recipeName: String,

    @Json(name = "strMealThumb")
    var thumbNailPath: String,

    @Json(name = "strCategory")
    var category: String,

    @Json(name = "strYoutube")
    var youtubeLink: String,

    @Json(name = "strIngredient1")
    var ingredient1: String,

    @Json(name = "strIngredient2")
    var ingredient2: String,

    @Json(name = "strIngredient3")
    var ingredient3: String,

    @Json(name = "strIngredient4")
    var ingredient4: String,

    @Json(name = "strIngredient5")
    var ingredient5: String,

    @Json(name = "strIngredient6")
    var ingredient6: String,

    @Json(name = "strIngredient7")
    var ingredient7: String,

    @Json(name = "strIngredient8")
    var ingredient8: String,

    @Json(name = "strIngredient9")
    var ingredient9: String,

    @Json(name = "strIngredient10")
    var ingredient10: String,

    @Json(name = "strIngredient11")
    var ingredient11: String,

    @Json(name = "strIngredient12")
    var ingredient12: String,

    @Json(name = "strIngredient13")
    var ingredient13: String,

    @Json(name = "strIngredient14")
    var ingredient14: String,

    @Json(name = "strIngredient15")
    var ingredient15: String,

    @Json(name = "strIngredient16")
    var ingredient16: String,

    @Json(name = "strIngredient17")
    var ingredient17: String,

    @Json(name = "strIngredient18")
    var ingredient18: String,

    @Json(name = "strIngredient19")
    var ingredient19: String,

    @Json(name = "strIngredient20")
    var ingredient20: String,

    @Json(name = "strMeasure1")
    var strMeasure1: String,

    @Json(name = "strMeasure2")
    var strMeasure2: String,

    @Json(name = "strMeasure3")
    var strMeasure3: String,

    @Json(name = "strMeasure4")
    var strMeasure4: String,

    @Json(name = "strMeasure5")
    var strMeasure5: String,

    @Json(name = "strMeasure6")
    var strMeasure6: String,

    @Json(name = "strMeasure7")
    var strMeasure7: String,

    @Json(name = "strMeasure8")
    var strMeasure8: String,

    @Json(name = "strMeasure9")
    var strMeasure9: String,

    @Json(name = "strMeasure10")
    var strMeasure10: String,

    @Json(name = "strMeasure11")
    var strMeasure11: String,

    @Json(name = "strMeasure12")
    var strMeasure12: String,

    @Json(name = "strMeasure13")
    var strMeasure13: String,

    @Json(name = "strMeasure14")
    var strMeasure14: String,

    @Json(name = "strMeasure15")
    var strMeasure15: String,

    @Json(name = "strMeasure16")
    var strMeasure16: String,

    @Json(name = "strMeasure17")
    var strMeasure17: String,

    @Json(name = "strMeasure18")
    var strMeasure18: String,

    @Json(name = "strMeasure19")
    var strMeasure19: String,

    @Json(name = "strMeasure20")
    var strMeasure20: String,

    ) : Parcelable

