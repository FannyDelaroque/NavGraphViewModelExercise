package com.example.navgraphviewmodelexercise

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecipeViewModel: ViewModel() {

    var recipeName = MutableLiveData<String>()
    init {
        recipeName.value = "Risotto aux champignons"
    }
}