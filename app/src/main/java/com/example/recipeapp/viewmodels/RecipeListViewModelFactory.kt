package com.example.recipeapp.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.models.MealCategory

class RecipeListViewModelFactory(private val application: Application, private val mealCategory: MealCategory) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeListViewModel::class.java)) {
            return RecipeListViewModel(application, mealCategory) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}
