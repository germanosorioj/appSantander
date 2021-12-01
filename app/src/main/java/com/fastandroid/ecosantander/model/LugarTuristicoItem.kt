package com.fastandroid.ecosantander.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LugarTuristicoItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("punctuation")
    val punctuation: String,
    @SerializedName("urlPicture")
    val urlPicture: String

):Serializable