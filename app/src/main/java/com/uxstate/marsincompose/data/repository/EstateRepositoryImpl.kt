package com.uxstate.marsincompose.data.repository

import com.uxstate.marsincompose.data.remote.MarsEstateAPI
import com.uxstate.marsincompose.data.remote.dto.EstateDTO
import com.uxstate.marsincompose.domain.model.Estate
import com.uxstate.marsincompose.domain.repo.EstateRepository
import javax.inject.Inject


//This is the real implementation

//It injects the Mars API dependency into the repo's constructor

//It implements the domain's repo which has the use-cases

class EstateRepositoryImpl @Inject constructor(private val api:MarsEstateAPI):EstateRepository{


    //this suspend method just returns api's getEstates()
    override suspend fun getEstates(): List<EstateDTO> {
      return api.getEstates()
    }

    override suspend fun getEstateById(id: String): EstateDTO {


        val estate = api.getEstates().single{ estateDTO -> estateDTO.id ==id }
        return estate
    }


}