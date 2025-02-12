package com.example.harry_potter_and_retrofit.domain.model

data class CharacterModel(
    val id: Int = 0,
    val name: String = "Unknown",
    val hogwartsHouse: String = "Slytherin",
    val imageUrl: String = ""
)