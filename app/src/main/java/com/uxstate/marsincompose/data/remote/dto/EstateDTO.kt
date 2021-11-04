package com.uxstate.marsincompose.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EstateDTO(
    val id: String,
    @Json(name = "img_src")
    val imgSrc: String,
    val price: Int,
    val type: String
)