package com.example.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.harry_potter_and_retrofit.data.network.CharacterRepositoryImps
import com.example.harry_potter_and_retrofit.domain.usecase.GetCharacterListUseCase
import com.example.harry_potter_and_retrofit.domain.usecase.GetCharacterUseCase

class MainViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)){

            val repo = CharacterRepositoryImps()
            val getCharacterUseCase = GetCharacterUseCase(repo)
            val getCharacterListUseCase = GetCharacterListUseCase(repo)
            return MainViewModel(repo,getCharacterListUseCase,getCharacterUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}