package com.example.harry_potter_and_retrofit.data.network.dto

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


//Dto for Moshi
@JsonClass(generateAdapter = true)
data class CharacterDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "character")
    val name: String,
    @Json(name = "hogwartsHouse")
    val hogwartsHouse: String,
    @Json(name = "image")
    val imageUrl: String
)

////Dto for Gson
//data class CharacterDto(
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("character")
//    val name: String,
//    @SerializedName("hogwartsHouse")
//    val hogwartsHouse: String,
//    @SerializedName("image")
//    val imageUrl: String
//)