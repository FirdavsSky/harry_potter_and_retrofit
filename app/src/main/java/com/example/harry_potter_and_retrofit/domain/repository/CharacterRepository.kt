package com.example.harry_potter_and_retrofit.domain.repository

import com.example.harry_potter_and_retrofit.domain.model.Character

interface CharacterRepository {

    fun getCharacters(): List<Character>

    fun getCharacterById(id: Int): Character
}