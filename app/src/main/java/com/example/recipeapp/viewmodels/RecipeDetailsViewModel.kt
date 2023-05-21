package com.example.recipeapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.recipeapp.models.MealCategory
import com.example.recipeapp.models.Recipe
import com.example.recipeapp.network.MealCategoryResponse
import com.example.recipeapp.network.RecipeResponse
import com.example.recipeapp.network.theMealDBApi
import kotlinx.coroutines.launch

class RecipeDetailsViewModel(application: Application, recipe: Recipe): AndroidViewModel(application) {

}