package com.example.recipeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipeapp.R
import com.example.recipeapp.adapters.RecipeAdapter
import com.example.recipeapp.adapters.RecipeClickListener
import com.example.recipeapp.databinding.FragmentRecipeListBinding
import com.example.recipeapp.models.MealCategory
import com.example.recipeapp.viewmodels.RecipeListViewModel
import com.example.recipeapp.viewmodels.RecipeListViewModelFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RecipeListFragment : Fragment() {

    private var _binding: FragmentRecipeListBinding? = null

    private lateinit var viewModel: RecipeListViewModel
    private lateinit var viewModelFactory: RecipeListViewModelFactory

    private lateinit var mealCategory: MealCategory


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRecipeListBinding.inflate(inflater)
        mealCategory = RecipeListFragmentArgs.fromBundle(requireArguments()).mealCategory

        val application = requireNotNull(this.activity).application

        viewModelFactory = RecipeListViewModelFactory(application, mealCategory)
        viewModel = ViewModelProvider(this, viewModelFactory)[RecipeListViewModel::class.java]

        val recipeListAdapter = RecipeAdapter(RecipeClickListener { recipe ->
            viewModel.onRecipeItemClicked(recipe)
        })

        binding.recipeListRv.adapter = recipeListAdapter

        viewModel.recipeList.observe(viewLifecycleOwner) { recipeList ->
            recipeList?.let { recipeListAdapter.submitList(recipeList) }
        }


        viewModel.navigateToRecipe.observe(viewLifecycleOwner) { recipe ->
            recipe?.let {
                this.findNavController().navigate(
                    RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailsFragment(recipe, mealCategory)
                )
            }
        }


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recipeListRv.layoutManager = GridLayoutManager(context, 2)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(RecipeListFragmentDirections.actionRecipeListFragmentToMealCategoryListFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
