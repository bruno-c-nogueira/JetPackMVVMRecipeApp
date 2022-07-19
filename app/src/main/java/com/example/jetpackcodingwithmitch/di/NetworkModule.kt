package com.example.jetpackcodingwithmitch.di

import com.example.jetpackcodingwithmitch.data.remote.api.RecipeService
import com.example.jetpackcodingwithmitch.data.remote.mapper.RecipeNetworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder().baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
    }

    @Singleton
    @Provides
    fun provideRecipeService(builder: Retrofit.Builder): RecipeService{
        return builder.build().create(RecipeService::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofitLogs(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Singleton
    @Provides
    fun provideRecipeProvider() = RecipeNetworkMapper()

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideToken() = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
}