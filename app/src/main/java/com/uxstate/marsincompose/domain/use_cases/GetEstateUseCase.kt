package com.uxstate.marsincompose.domain.use_cases

import com.uxstate.marsincompose.domain.model.Estate
import com.uxstate.marsincompose.domain.repo.EstateRepository
import com.uxstate.marsincompose.utils.Resource
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow
import javax.inject.Inject

class GetEstateUseCase @Inject constructor(repository: EstateRepository){


    operator fun invoke(): Flow<Resource<List<Estate>>> = flow {

        try {
            emit(Resource.Loading())
        }

    }

}