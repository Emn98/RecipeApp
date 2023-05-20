package com.example.recipeapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize


@Parcelize
data class MealCategory(

    @Json(name = "idCategory")
    var id: Int,

    @Json(name = "strCategory")
    var categoryName: String,

    @Json(name = "strCategoryThumb")
    var thumbnailPath: String,

    @Json(name = "strCategoryDescription")
    var categoryDesc: String

) : Parcelable
