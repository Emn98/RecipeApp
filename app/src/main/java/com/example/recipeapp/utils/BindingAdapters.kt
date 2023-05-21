package com.example.recipeapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("mealCategoryImageUrl")
fun bindMealCategoryImage(imgView: ImageView, imgUrl: String){
    imgUrl.let { imagePath ->
        Glide
            .with(imgView)
            .load(imagePath)
            .into(imgView);
    }
}