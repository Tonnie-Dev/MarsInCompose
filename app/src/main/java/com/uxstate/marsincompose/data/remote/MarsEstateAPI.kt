package com.uxstate.marsincompose.data.remote

import com.uxstate.marsincompose.data.remote.dto.EstateDTO
import retrofit2.http.GET

interface MarsEstateAPI {

    @GET
    suspend fun getEstates(): List<EstateDTO>
}