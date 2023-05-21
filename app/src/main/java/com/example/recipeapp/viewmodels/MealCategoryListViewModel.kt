package com.example.recipeapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.recipeapp.models.MealCategory
import com.example.recipeapp.network.MealCategoryResponse
import com.example.recipeapp.network.theMealDBApi
import kotlinx.coroutines.launch

class MealCategoryListViewModel(application: Application): AndroidViewModel(application) {
    private val _mealCategoryList = MutableLiveData<List<MealCategory>>()
    val mealCategoryList: LiveData<List<MealCategory>>
        get(){
            return _mealCategoryList
        }

    private val _navigateToMealCategory = MutableLiveData<MealCategory?>()
    val navigateToMealCategory: LiveData<MealCategory?>
        get() {
            return _navigateToMealCategory
        }

    init {
        getMealCategories()
    }

    fun getMealCategories(){
        viewModelScope.launch {
            try {
                val MealCategoryResponse: MealCategoryResponse = theMealDBApi.recipeListRetrofitService.getMealCategories()
                    _mealCategoryList.value = MealCategoryResponse.categories
            } catch (e : java.lang.Exception) {
                _mealCategoryList.value = arrayListOf()
            }
        }
    }

    fun onMealCategoryItemClicked(mealCategory: MealCategory){
        _navigateToMealCategory.value = mealCategory
    }

    fun onMealCategoryRecipesNagivated(){
        _navigateToMealCategory.value = null
    }


}