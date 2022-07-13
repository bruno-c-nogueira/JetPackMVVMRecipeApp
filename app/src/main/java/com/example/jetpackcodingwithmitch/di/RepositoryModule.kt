package com.example.jetpackcodingwithmitch.di

import com.example.jetpackcodingwithmitch.data.remote.api.RecipeService
import com.example.jetpackcodingwithmitch.data.remote.mapper.RecipeNetworkMapper
import com.example.jetpackcodingwithmitch.repository.RecipeRepository
import com.example.jetpackcodingwithmitch.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        mapper: RecipeNetworkMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService, mapper
        )
    }
}