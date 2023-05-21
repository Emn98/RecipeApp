package com.example.recipeapp.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.models.MealCategory
import com.example.recipeapp.models.Recipe

class RecipeDetailsViewModelFactory(private val application: Application, private val recipe: Recipe) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeDetailsViewModel::class.java)) {
            return RecipeDetailsViewModel(application, recipe) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}
