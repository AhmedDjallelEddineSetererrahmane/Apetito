package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryEndpoint {

    @GET("Category/{id}")
    fun getCategory(@Path("id") id: Long):Call<Category>

    @GET("Category")
    fun getCategories():Call<List<Category>>

}