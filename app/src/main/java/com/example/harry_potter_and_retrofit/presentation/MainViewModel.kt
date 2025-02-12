package com.example.harry_potter_and_retrofit.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harry_potter_and_retrofit.data.network.CharacterRepositoryImps
import com.example.harry_potter_and_retrofit.domain.model.CharacterModel
import com.example.harry_potter_and_retrofit.domain.usecase.GetCharacterListUseCase
import com.example.harry_potter_and_retrofit.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(

    private val repository:CharacterRepositoryImps,
    private val getCharacterListUseCase:GetCharacterListUseCase,
    private val getCharacterUseCase: GetCharacterUseCase

) : ViewModel() {

    private var _character: MutableStateFlow<CharacterModel> = MutableStateFlow(
        CharacterModel()
    )
    val character = _character.asStateFlow()

    private var _characterList: MutableStateFlow<List<CharacterModel>> = MutableStateFlow(
        mutableListOf()
    )
    val characterList = _characterList.asStateFlow()


    init {

        viewModelScope.launch {
            try {
                _character.value = getCharacterUseCase.getCharacter(1)
                _characterList.value = getCharacterListUseCase.getCharacterList()
            } catch (t: Throwable) {
                Log.e(TAG, "${t.message}")
            }
        }
    }

    fun randomCharacter() {

        //_character.value = _characterList.value.random()

        viewModelScope.launch {

            val listSize = _characterList.value.size
            _character.value = getCharacterUseCase.getCharacter((1..listSize).random())
        }
    }
}