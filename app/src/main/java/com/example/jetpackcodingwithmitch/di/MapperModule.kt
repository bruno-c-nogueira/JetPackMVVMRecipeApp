package com.example.jetpackcodingwithmitch.di

import com.example.jetpackcodingwithmitch.data.remote.mapper.RecipeNetworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideRecipeProvider() = RecipeNetworkMapper()
}