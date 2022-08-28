package com.example.jetpackcodingwithmitch.di

import android.content.Context
import co.infinum.retromock.Retromock
import com.example.jetpackcodingwithmitch.data.remote.api.RecipeService
import com.example.jetpackcodingwithmitch.data.remote.mapper.RecipeNetworkMapper
import com.example.jetpackcodingwithmitch.ResourceBodyFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

    @Singleton
    @Provides
    fun provideRecipeService(retroMock: Retromock): RecipeService{
        return retroMock.create(RecipeService::class.java)
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

    @Singleton
    @Provides
    fun provideRetroMock(retrofit: Retrofit, @ApplicationContext context: Context): Retromock = Retromock.Builder().defaultBodyFactory(
        ResourceBodyFactory(context)
    ).retrofit(retrofit).build()
}