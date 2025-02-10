package com.example.harry_potter_and_retrofit.data.network

import retrofit2.http.GET

interface SearchCharacters {

    @GET("")
    fun getCharacters()

    fun getCharacterById(id: Int)

}