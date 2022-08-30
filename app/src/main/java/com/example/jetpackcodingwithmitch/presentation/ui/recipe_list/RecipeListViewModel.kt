package com.example.jetpackcodingwithmitch.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcodingwithmitch.domain.model.Recipe
import com.example.jetpackcodingwithmitch.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

    init {
        newSearch("Chicken")
    }

    fun newSearch(query: String) {
        viewModelScope.launch {
            val get = repository.search(token, 1, query)
            if (get != null) {
                recipes.value = get
            }
        }
    }

}