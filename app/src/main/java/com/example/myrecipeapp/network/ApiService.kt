package com.example.myrecipeapp.network

import com.example.myrecipeapp.model.CategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retroFit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retroFit.create(ApiService::class.java)


interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}