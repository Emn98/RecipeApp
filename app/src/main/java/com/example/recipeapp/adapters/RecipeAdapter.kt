package com.example.recipeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.models.Recipe
import com.example.recipeapp.databinding.RecipeListItemGridBinding

class RecipeAdapter(private val recipeClickListener: RecipeClickListener) :
    ListAdapter<Recipe, RecipeAdapter.ViewHolder>(RecipeDiffCallback()) {

    class ViewHolder(private var binding: RecipeListItemGridBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(Recipe: Recipe, recipeClickListener: RecipeClickListener) {
            binding.recipe = Recipe
            binding.clickListener = recipeClickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipeListItemGridBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecipeAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position), recipeClickListener)
    }

    class RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }

    }
}

class RecipeClickListener(val clickListener: (recipe: Recipe) -> Unit) {
    fun onClick(recipe: Recipe) = clickListener(recipe)
}