package com.fastandroid.ecosantander


import com.google.gson.annotations.SerializedName

data class LugarTuristicoItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("punctuation")
    val punctuation: String,
    @SerializedName("urlPicture")
    val urlPicture: String

)