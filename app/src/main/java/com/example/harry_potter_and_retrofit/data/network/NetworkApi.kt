package com.example.harry_potter_and_retrofit.data.network

import com.example.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.example.harry_potter_and_retrofit.domain.model.Character
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://harry-potter-api-en.onrender.com/characters"

interface SearchCharactersApi {

    @GET
    suspend fun getCharacters(): List<CharacterDto>

    @GET
    suspend fun getCharacterById(@Query("id") id: Int = 1): CharacterDto

//    @GET("/{id}")
//    suspend fun getCharacterByIdPath(@Path("id") id: Int = 1): CharacterDto

}

object RetrofitInstance {

    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    val searchCharactersApi: SearchCharactersApi = retrofit.create(SearchCharactersApi::class.java)
}