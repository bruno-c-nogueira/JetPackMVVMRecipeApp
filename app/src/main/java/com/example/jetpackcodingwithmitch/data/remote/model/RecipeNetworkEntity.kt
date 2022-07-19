package com.example.jetpackcodingwithmitch.data.remote.model

data class RecipeNetworkEntity(
    val cooking_instructions: String?,
    val date_added: String?,
    val date_updated: String?,
    val description: String?,
    val featured_image: String?,
    val ingredients: List<String?>?,
    val pk: Int?,
    val publisher: String?,
    val rating: Int?,
    val source_url: String?,
    val title: String?
)