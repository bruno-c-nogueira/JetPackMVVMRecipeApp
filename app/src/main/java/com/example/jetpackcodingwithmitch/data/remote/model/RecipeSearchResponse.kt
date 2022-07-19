package com.example.jetpackcodingwithmitch.data.remote.model

import com.example.jetpackcodingwithmitch.data.remote.model.RecipeNetworkEntity

data class RecipeSearchResponse(
    val cont: Int,
    var recipes: List<RecipeNetworkEntity>
)
