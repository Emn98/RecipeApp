package com.example.recipeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipeapp.adapters.CategoryClickListener
import com.example.recipeapp.adapters.MealCategoryAdapter
import com.example.recipeapp.databinding.FragmentMealCategoryListBinding
import com.example.recipeapp.viewmodels.MealCategoryListViewModel
import com.example.recipeapp.viewmodels.MealCategoryListViewModelFactory



/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MealCategoryListFragment : Fragment() {

    private lateinit var viewModel: MealCategoryListViewModel
    private lateinit var viewModelFactory: MealCategoryListViewModelFactory


    private var _binding: FragmentMealCategoryListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMealCategoryListBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        viewModelFactory = MealCategoryListViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[MealCategoryListViewModel::class.java]

        val mealCategoryListAdapter = MealCategoryAdapter(CategoryClickListener { category ->
            viewModel.onMealCategoryItemClicked(category)
        })

        binding.mealCategoriesListRv.adapter = mealCategoryListAdapter

        viewModel.mealCategoryList.observe(viewLifecycleOwner) { mealCategoryList ->
            mealCategoryList?.let { mealCategoryListAdapter.submitList(mealCategoryList) }
        }


        viewModel.navigateToMealCategory.observe(viewLifecycleOwner) { mealCategory ->
            mealCategory?.let {
                this.findNavController().navigate(
                   MealCategoryListFragmentDirections.actionMealCategoryListFragmentToRecipeListFragment(mealCategory)
                )
            }
        }



        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mealCategoriesListRv.layoutManager = GridLayoutManager(context, 2)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}