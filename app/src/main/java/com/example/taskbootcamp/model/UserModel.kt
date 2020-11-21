package com.example.taskbootcamp.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @field:SerializedName("phone")
    val phone: String,

    @field:SerializedName("name")
    val name: Name,

    @field:SerializedName("cell")
    val cell: String,

    @field:SerializedName("picture")
    val picture: Picture
)
