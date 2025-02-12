package com.example.harry_potter_and_retrofit.domain.usecase

import com.example.harry_potter_and_retrofit.domain.model.CharacterModel
import com.example.harry_potter_and_retrofit.domain.repository.CharacterRepository

class GetCharacterUseCase(
    private val repo: CharacterRepository
) {

    suspend fun getCharacter(id: Int = 1): CharacterModel{
        return repo.getCharacterById(id)
    }
}