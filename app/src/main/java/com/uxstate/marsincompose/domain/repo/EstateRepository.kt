package com.uxstate.marsincompose.domain.repo

import com.uxstate.marsincompose.data.remote.dto.EstateDTO

interface EstateRepository {


    suspend fun getEstates():List<EstateDTO>
    suspend fun getEstateById(estateId:String):EstateDTO
}