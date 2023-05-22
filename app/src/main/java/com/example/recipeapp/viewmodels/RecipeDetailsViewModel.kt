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
import com.example.recipeapp.models.RecipeDetail
import com.example.recipeapp.network.MealCategoryResponse
import com.example.recipeapp.network.RecipeDetailResponse
import com.example.recipeapp.network.RecipeResponse
import com.example.recipeapp.network.theMealDBApi
import kotlinx.coroutines.launch

class RecipeDetailsViewModel(application: Application, recipe: Recipe): AndroidViewModel(application) {
    private val _recipeDetail = MutableLiveData<RecipeDetail?>()
    val recipeDetail: LiveData<RecipeDetail?>
        get(){
            return _recipeDetail
        }
    init {
        getRecipes(recipe.id)
        Log.d("TESTTEST", "hej")
    }

    fun getRecipes(recipeId: Int){
        viewModelScope.launch {
            try {
                val recipeDetailResponse : RecipeDetailResponse  = theMealDBApi.recipeListRetrofitService.getRecipeDetail(i=recipeId)
                _recipeDetail.value = recipeDetailResponse.recipeDetail[0]
            } catch (e : java.lang.Exception) {
                _recipeDetail.value = null
                Log.e("API_CALL", "API call failed: ${e.message}", e)
            }
        }
    }
}