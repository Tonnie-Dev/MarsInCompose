package com.uxstate.marsincompose.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.uxstate.marsincompose.domain.model.Estate

@JsonClass(generateAdapter = true)
data class EstateDTO(
    val id: String,
    @Json(name = "img_src")
    val imgSrc: String,
    val price: Int,
    val type: String
)



//extension function to convert DTO to Model Object
fun EstateDTO.toEstate():Estate{

    return Estate(
        id = id,
        imgSrc = imgSrc,
        price = price,
        type = type
    )
}