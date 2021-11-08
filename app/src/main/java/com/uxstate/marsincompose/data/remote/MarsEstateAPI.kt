package com.uxstate.marsincompose.data.remote

import com.uxstate.marsincompose.data.remote.dto.EstateDTO
import retrofit2.http.GET

interface MarsEstateAPI {

    @GET("realestate")
    suspend fun getEstates(): List<EstateDTO>
}


//https://android-kotlin-fun-mars-server.appspot.com/realestate