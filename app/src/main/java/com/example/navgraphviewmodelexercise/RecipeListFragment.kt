package com.example.navgraphviewmodelexercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.navgraphviewmodelexercise.databinding.FragmentRecipeListBinding

class RecipeListFragment: Fragment() {

    private lateinit var binding: FragmentRecipeListBinding
    val viewModel: RecipeViewModel by navGraphViewModels(R.id.recipe_navigation)

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_recipe_list,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        bindVM()
    }

    private fun initUI() {
        binding.recipeListButton.setOnClickListener { goToDetailRecipe() }
    }

    private fun goToDetailRecipe() {
        findNavController().navigate(R.id.recipe_detail_fragment)
    }

    private fun bindVM() {
        viewModel.recipeName.observe(viewLifecycleOwner){ name ->
            binding.recipeListRecipeNameTextview.text = name
        }
    }
}