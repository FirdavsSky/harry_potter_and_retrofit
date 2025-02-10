package com.example.harry_potter_and_retrofit.domain.repository

interface CharacterRepository {

    fun getCharacters()

    fun getCharacterById(id: Int)
}