package com.example.recipeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.models.MealCategory
import com.example.recipeapp.databinding.MealCategoryListItemGridBinding

class MealCategoryAdapter(private val categoryClickListener: CategoryClickListener) :
    ListAdapter<MealCategory, MealCategoryAdapter.ViewHolder>(MealCategoryDiffCallback()) {

    class ViewHolder(private var binding: MealCategoryListItemGridBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mealCategory: MealCategory, categoryClickListener: CategoryClickListener) {
            binding.mealCategory = mealCategory
            binding.clickListener = categoryClickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MealCategoryListItemGridBinding.inflate(layoutInflater, parent, false)
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

    override fun onBindViewHolder(holder: MealCategoryAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position), categoryClickListener)
    }

    class MealCategoryDiffCallback : DiffUtil.ItemCallback<MealCategory>() {
        override fun areItemsTheSame(oldItem: MealCategory, newItem: MealCategory): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MealCategory, newItem: MealCategory): Boolean {
            return oldItem == newItem
        }

    }
}

class CategoryClickListener(val clickListener: (mealCategory: MealCategory) -> Unit) {
    fun onClick(mealCategory: MealCategory) = clickListener(mealCategory)
}