package com.uxstate.marsincompose.domain.use_cases

import com.uxstate.marsincompose.data.remote.dto.toEstate
import com.uxstate.marsincompose.domain.model.Estate
import com.uxstate.marsincompose.domain.repo.EstateRepository
import com.uxstate.marsincompose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetEstatesUseCase @Inject constructor(private val repository: EstateRepository){


    operator fun invoke(): Flow<Resource<List<Estate>>> = flow {

        try {
            emit(Resource.Loading())
            val estates = repository.getEstates().map { dto -> dto.toEstate() }

           emit(Resource.Success(estates))
        }
        //thrown when something goes wrong while processing any HTTP request.
        catch (e:HttpException){

            emit(Resource.Error(e.localizedMessage?: "An Expected Error"))
        }
        /* thrown when there is a failure during reading, writing, and searching
          file or directory operations - in this case when there is failure
          to communicate with the server due to lack of internet connection*/
        catch (e: IOException) {

            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }

    }

}