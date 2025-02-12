package com.example.harry_potter_and_retrofit.data.network

import com.example.harry_potter_and_retrofit.data.network.dto.CharacterDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://harry-potter-api-en.onrender.com"

interface SearchCharactersApi {

    @GET("/characters")
    suspend fun getCharacters(): List<CharacterDto>


    @GET("/characters/{id}")
    suspend fun getCharacterById(@Path("id") id: Int = 1): CharacterDto
}

object RetrofitInstance {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()

    val searchCharactersApi: SearchCharactersApi = retrofit.create(SearchCharactersApi::class.java)
}