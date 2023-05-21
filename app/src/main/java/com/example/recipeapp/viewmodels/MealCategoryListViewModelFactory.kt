package com.example.recipeapp.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MealCategoryListViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealCategoryListViewModel::class.java)) {
            return MealCategoryListViewModel(application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}
