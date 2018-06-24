package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.Binary
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BinaryEndpoint {

    @GET("Binary/{id}")
    fun getBinary(@Path("id") id: String):Call<Binary>

    @GET("Binary")
    fun getBinaries():Call<List<Binary>>

    @POST("Binary")
    fun addBinary(@Body binary : Binary): Call<Binary>

    @POST("Binary")
    fun addBinaries(@Body binary : List<Binary>): Call<List<Binary>>

}