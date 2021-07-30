package com.juliakorolko.fantasticfour.network

import com.juliakorolko.fantasticfour.comicOverview.model.Comic
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ComicApiService {
    @GET("comics/{comicId}")
    suspend fun getComicById(
        @Path("comicId") comicId: Int,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Comic
}

object ComicApi {
    val retrofitService : ComicApiService by lazy { retrofit.create(ComicApiService::class.java) }
}