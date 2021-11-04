package com.uxstate.marsincompose.domain.repo

import com.uxstate.marsincompose.data.remote.dto.EstateDTO

interface EstateRepository {


    fun getEstate():List<EstateDTO>
}