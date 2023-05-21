package com.example.recipeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipeapp.adapters.RecipeAdapter
import com.example.recipeapp.adapters.RecipeClickListener
import com.example.recipeapp.databinding.FragmentRecipeDetailsBinding
import com.example.recipeapp.databinding.FragmentRecipeListBinding
import com.example.recipeapp.models.MealCategory
import com.example.recipeapp.models.Recipe
import com.example.recipeapp.viewmodels.RecipeDetailsViewModel
import com.example.recipeapp.viewmodels.RecipeDetailsViewModelFactory
import com.example.recipeapp.viewmodels.RecipeListViewModel
import com.example.recipeapp.viewmodels.RecipeListViewModelFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RecipeDetailsFragment : Fragment() {

    private var _binding: FragmentRecipeDetailsBinding? = null

    private lateinit var viewModel: RecipeDetailsViewModel
    private lateinit var viewModelFactory: RecipeDetailsViewModelFactory

    private lateinit var mealCategory: MealCategory
    private lateinit var recipe: Recipe


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRecipeDetailsBinding.inflate(inflater)
        recipe = RecipeDetailsFragmentArgs.fromBundle(requireArguments()).recipe
        mealCategory = RecipeDetailsFragmentArgs.fromBundle(requireArguments()).mealCategory


        val application = requireNotNull(this.activity).application

        viewModelFactory = RecipeDetailsViewModelFactory(application, recipe)
        viewModel = ViewModelProvider(this, viewModelFactory)[RecipeDetailsViewModel::class.java]



        /*
        viewModel.navigateToRecipe.observe(viewLifecycleOwner) { recipe ->
            recipe?.let {
                this.findNavController().navigate(
                    MealCategoryListFragmentDirections.actionRecipeListFragmentToRecipeDetailFragment(recipe)
                )
            }
        }
        */



        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recipeDetailsRv.layoutManager = GridLayoutManager(context, 2)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(RecipeDetailsFragmentDirections.actionRecipeDetailsFragmentToRecipeListFragment(mealCategory))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}