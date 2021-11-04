package com.uxstate.marsincompose.data.remote

import retrofit2.http.GET

interface MarsEstatesAPI {

    @GET
    suspend fun getEstates(): List<EstateDTO>
}