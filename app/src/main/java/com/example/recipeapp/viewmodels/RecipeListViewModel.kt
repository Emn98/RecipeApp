package com.example.recipeapp.viewmodels

import android.app.Application
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

class RecipeListViewModel(application: Application, mealCategory: MealCategory): AndroidViewModel(application) {
    private val _recipeList = MutableLiveData<List<Recipe>>()
    val recipeList: LiveData<List<Recipe>>
        get(){
            return _recipeList
        }

    private val _navigateToRecipe = MutableLiveData<Recipe?>()
    val navigateToRecipe: LiveData<Recipe?>
        get() {
            return _navigateToRecipe
        }

    init {
        getRecipes(mealCategory.categoryName)
    }

    fun getRecipes(categoryName: String){
        viewModelScope.launch {
            try {
                val recipeResponse: RecipeResponse = theMealDBApi.recipeListRetrofitService.getRecipesByCategory(categoryName)
                    _recipeList.value = recipeResponse.recipes
            } catch (e : java.lang.Exception) {
                _recipeList.value = arrayListOf()
            }
        }
    }

    fun onRecipeItemClicked(recipe: Recipe){
        _navigateToRecipe.value = recipe
    }

    fun onRecipeNavigated(){
        _navigateToRecipe.value = null
    }


}