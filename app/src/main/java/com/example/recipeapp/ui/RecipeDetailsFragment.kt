package com.example.recipeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recipeapp.databinding.FragmentRecipeDetailsBinding
import com.example.recipeapp.models.MealCategory
import com.example.recipeapp.models.Recipe
import com.example.recipeapp.viewmodels.RecipeDetailsViewModel
import com.example.recipeapp.viewmodels.RecipeDetailsViewModelFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RecipeDetailsFragment : Fragment() {

    private var _binding: FragmentRecipeDetailsBinding? = null

    private lateinit var viewModel: RecipeDetailsViewModel
    private lateinit var viewModelFactory: RecipeDetailsViewModelFactory

    private lateinit var mealCategory: MealCategory
    private lateinit var recipe: Recipe

    private  var youtubeLink : String? = null



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRecipeDetailsBinding.inflate(inflater)
        recipe = RecipeDetailsFragmentArgs.fromBundle(requireArguments()).recipe
        binding.recipe = recipe
        mealCategory = RecipeDetailsFragmentArgs.fromBundle(requireArguments()).mealCategory


        val application = requireNotNull(this.activity).application

        viewModelFactory = RecipeDetailsViewModelFactory(application, recipe)
        viewModel = ViewModelProvider(this, viewModelFactory)[RecipeDetailsViewModel::class.java]

        viewModel.recipeDetail.observe(viewLifecycleOwner) { recipeDetail ->
            recipeDetail?.let {
                binding.recipeDetail = recipeDetail
                var builder: String = ""
                if(recipeDetail.ingredient1 != null && recipeDetail.ingredient1 != "")
                    builder += "• " + recipeDetail.ingredient1 + ": " + recipeDetail.strMeasure1 + "\n"
                if(recipeDetail.ingredient2 != null && recipeDetail.ingredient2 != "")
                    builder += "• " + recipeDetail.ingredient2 + ": " + recipeDetail.strMeasure2 + "\n"
                if(recipeDetail.ingredient3 != null && recipeDetail.ingredient3 != "")
                    builder += "• " + recipeDetail.ingredient3 + ": " + recipeDetail.strMeasure3 + "\n"
                if(recipeDetail.ingredient4 != null && recipeDetail.ingredient4 != "")
                    builder += "• " + recipeDetail.ingredient4 + ": " + recipeDetail.strMeasure4 + "\n"
                if(recipeDetail.ingredient5 != null && recipeDetail.ingredient5 != "")
                    builder += "• " + recipeDetail.ingredient5 + ": " + recipeDetail.strMeasure5 + "\n"
                if(recipeDetail.ingredient6 != null && recipeDetail.ingredient6 != "")
                    builder += "• " + recipeDetail.ingredient6 + ": " + recipeDetail.strMeasure6 + "\n"
                if(recipeDetail.ingredient7 != null && recipeDetail.ingredient7 != "")
                    builder += "• " + recipeDetail.ingredient7 + ": " + recipeDetail.strMeasure7 + "\n"
                if(recipeDetail.ingredient8 != null && recipeDetail.ingredient8 != "")
                    builder += "• " + recipeDetail.ingredient8 + ": " + recipeDetail.strMeasure8 + "\n"
                if(recipeDetail.ingredient9 != null && recipeDetail.ingredient9 != "")
                    builder += "• " + recipeDetail.ingredient9 + ": " + recipeDetail.strMeasure9 + "\n"
                if(recipeDetail.ingredient10 != null && recipeDetail.ingredient10 != "")
                    builder += "• " + recipeDetail.ingredient10 + ": " + recipeDetail.strMeasure10 + "\n"
                if(recipeDetail.ingredient11 != null && recipeDetail.ingredient11 != "")
                    builder += "• " + recipeDetail.ingredient11 + ": " + recipeDetail.strMeasure11 + "\n"
                if(recipeDetail.ingredient12 != null && recipeDetail.ingredient12 != "")
                    builder += "• " + recipeDetail.ingredient12 + ": " + recipeDetail.strMeasure12 + "\n"
                if(recipeDetail.ingredient13 != null && recipeDetail.ingredient13 != "")
                    builder += "• " + recipeDetail.ingredient13 + ": " + recipeDetail.strMeasure13 + "\n"
                if(recipeDetail.ingredient14 != null && recipeDetail.ingredient14 != "")
                    builder += "• " + recipeDetail.ingredient14 + ": " + recipeDetail.strMeasure14 + "\n"
                if(recipeDetail.ingredient15 != null && recipeDetail.ingredient15 != "")
                    builder += "• " + recipeDetail.ingredient15 + ": " + recipeDetail.strMeasure15 + "\n"
                if(recipeDetail.ingredient16 != null && recipeDetail.ingredient16 != "")
                    builder += "• " + recipeDetail.ingredient16 + ": " + recipeDetail.strMeasure16 + "\n"
                if(recipeDetail.ingredient17 != null && recipeDetail.ingredient17 != "")
                    builder += "• " + recipeDetail.ingredient17 + ": " + recipeDetail.strMeasure17 + "\n"
                if(recipeDetail.ingredient18 != null && recipeDetail.ingredient18 != "")
                    builder += "• " + recipeDetail.ingredient18 + ": " + recipeDetail.strMeasure18 + "\n"
                if(recipeDetail.ingredient19 != null && recipeDetail.ingredient19 != "")
                    builder += "• " + recipeDetail.ingredient19 + ": " + recipeDetail.strMeasure19 + "\n"
                if(recipeDetail.ingredient20 != null && recipeDetail.ingredient20 != "")
                    builder += "• " + recipeDetail.ingredient20 + ": " + recipeDetail.strMeasure20 + "\n"

                binding.ingredientsList = builder

                binding.instructions = recipeDetail.recipeDetailsInstructions

                youtubeLink = recipeDetail.youtubeLink?.substringAfterLast("v=")


            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.youtubeBtn.setOnClickListener{
            this.findNavController().navigate(
                RecipeDetailsFragmentDirections.actionRecipeDetailsFragmentToYoutubeVideoFragment(youtubeLink!!)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}