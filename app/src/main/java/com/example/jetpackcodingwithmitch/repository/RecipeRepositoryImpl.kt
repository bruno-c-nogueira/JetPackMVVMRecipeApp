package com.example.jetpackcodingwithmitch.repository

import com.example.jetpackcodingwithmitch.data.remote.api.RecipeService
import com.example.jetpackcodingwithmitch.data.remote.mapper.RecipeNetworkMapper
import com.example.jetpackcodingwithmitch.domain.model.Recipe
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeService: RecipeService,
    private val mapper: RecipeNetworkMapper
): RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe>? {
        return mapper.toDomainList(recipeService.search(token, page, query)?.results)
    }

    override suspend fun get(token: String, id: Int): Recipe? {
        return recipeService.get(token, id)?.let { mapper.mapFromEntity(it) }
    }
}