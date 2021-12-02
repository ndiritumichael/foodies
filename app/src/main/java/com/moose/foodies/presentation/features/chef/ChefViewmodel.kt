package com.moose.foodies.presentation.features.chef

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moose.foodies.domain.models.Profile
import com.moose.foodies.domain.models.Recipe
import com.moose.foodies.domain.repositories.ChefRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChefViewmodel @Inject constructor(val repository: ChefRepository): ViewModel() {

    private val _chef: MutableLiveData<Profile> = MutableLiveData()
    val chef: LiveData<Profile> = _chef

    private val _recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    val recipes: LiveData<List<Recipe>> = _recipes

    fun getChef(id: String?) {
        viewModelScope.launch {
            if (id == "local"){
                _chef.value = repository.getPrefsChef()
                getRecipes(_chef.value!!._id)
            } else {
                // deep link was used, make the network request
            }
        }
    }

    private fun getRecipes(id: String){

    }
}