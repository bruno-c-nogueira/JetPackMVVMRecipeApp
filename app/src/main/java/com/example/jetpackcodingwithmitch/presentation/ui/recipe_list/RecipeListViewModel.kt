package com.example.jetpackcodingwithmitch.presentation.ui.recipe_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcodingwithmitch.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
) :
    ViewModel() {

    fun getToken() {
        viewModelScope.launch {
            val get = repository.get(token, 583)
            println(get)
        }
    }


}