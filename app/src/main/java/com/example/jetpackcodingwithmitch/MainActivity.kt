package com.example.jetpackcodingwithmitch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackcodingwithmitch.data.remote.api.RecipeService
import com.example.jetpackcodingwithmitch.repository.RecipeRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository : RecipeRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {

        val get = repository.get("Token 9c8b06d329136da358c2d00e76946b0111ce2c48", 583)
            println(get)
        }

//        val service = Retrofit.Builder().baseUrl("https://food2fork.ca/api/recipe/").addConverterFactory(
//            GsonConverterFactory.create())
//            .build().create(RecipeService::class.java)
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = service.get("Token 9c8b06d329136da358c2d00e76946b0111ce2c48", 583)
//            Log.d("Main", response?.pk.toString())
//        }

    }
}


