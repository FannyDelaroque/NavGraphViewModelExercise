package com.example.navgraphviewmodelexercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.navGraphViewModels
import com.example.navgraphviewmodelexercise.databinding.FragmentRecipeDetailBinding

class RecipeDetailFragment: Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding
    val viewModel: RecipeViewModel by navGraphViewModels(R.id.recipe_navigation)

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_recipe_detail, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindVM()
    }

    private fun bindVM() {
        viewModel.recipeName.observe(viewLifecycleOwner){ name ->
            binding.recipeDetailRecipeNameTextview.text = name
        }
    }
}
