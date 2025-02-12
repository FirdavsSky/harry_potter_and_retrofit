package com.example.harry_potter_and_retrofit.data.network

import com.example.harry_potter_and_retrofit.data.network.mapper.CharacterMapper
import com.example.harry_potter_and_retrofit.domain.model.CharacterModel
import com.example.harry_potter_and_retrofit.domain.repository.CharacterRepository

class CharacterRepositoryImps : CharacterRepository {

    private val mapper = CharacterMapper()

    override suspend fun getCharacters(): List<CharacterModel> {

        return mapper.mapListDtoToListModel(
            RetrofitInstance.searchCharactersApi.getCharacters()
        )
    }

    override suspend fun getCharacterById(id: Int): CharacterModel {

        return mapper.mapDtoToModel(
            RetrofitInstance.searchCharactersApi.getCharacterById(id)
        )
    }
}