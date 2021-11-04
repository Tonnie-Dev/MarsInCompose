package com.uxstate.marsincompose.data.remote

import com.uxstate.marsincompose.data.remote.dto.EstateDTO
import retrofit2.http.GET

interface MarsEstatesAPI {

    @GET
    suspend fun getEstates(): List<EstateDTO>
}