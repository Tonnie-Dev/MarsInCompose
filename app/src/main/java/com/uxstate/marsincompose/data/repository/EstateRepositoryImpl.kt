package com.uxstate.marsincompose.data.repository

import com.uxstate.marsincompose.data.remote.MarsEstateAPI
import com.uxstate.marsincompose.data.remote.dto.EstateDTO
import com.uxstate.marsincompose.domain.repo.EstateRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//This is the real implementation

//It injects the Mars API dependency into the repo's constructor

//It implements the domain's repo which has the use-cases

class EstateRepositoryImpl @Inject constructor(private val api:MarsEstateAPI):EstateRepository{


    //this suspend method just returns api's getEstates()
    override suspend fun getEstates(): List<EstateDTO> {
      return api.getEstates()
    }

    override suspend fun getEstateById(estateId: String): EstateDTO {

Timber.i("The passedId is $estateId")
        return api.getEstates().first { estateDTO -> estateDTO.id == estateId }
    }


}