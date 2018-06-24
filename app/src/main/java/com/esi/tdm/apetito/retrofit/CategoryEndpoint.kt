package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.Category
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CategoryEndpoint {

    @GET("Category/{id}")
    fun getCategory(@Path("id") id: String):Call<Category>

    @GET("Category")
    fun getCategories():Call<List<Category>>


    @POST("Category")
    fun addCategory(@Body category : Category): Call<Category>

    @POST("Category")
    fun addCategories(@Body categories : List<Category>): Call<List<Category>>

}