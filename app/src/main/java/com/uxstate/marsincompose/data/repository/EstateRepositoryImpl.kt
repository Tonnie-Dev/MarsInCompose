package com.uxstate.marsincompose.data.repository

import com.uxstate.marsincompose.data.remote.MarsEstateAPI
import com.uxstate.marsincompose.data.remote.dto.EstateDTO
import com.uxstate.marsincompose.domain.repo.EstateRepository
import javax.inject.Inject


//this is the real implementation

//It injects the API dependency into the repo's constructor

//It implements the domain's repo which has the use-cases

class EstateRepositoryImpl @Inject constructor(private val api:MarsEstateAPI):EstateRepository{


    //this suspend method just returns api's getEstates()
    override suspend fun getEstate(): List<EstateDTO> {
      return api.getEstates()
    }


}