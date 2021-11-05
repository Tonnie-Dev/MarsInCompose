package com.uxstate.marsincompose.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.uxstate.marsincompose.domain.model.Estate
import com.uxstate.marsincompose.domain.use_cases.GetEstatesUseCase
import com.uxstate.marsincompose.presentation.estatelist.EstateListState
import com.uxstate.marsincompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EstateViewModel @Inject constructor(private val useCase: GetEstatesUseCase):ViewModel() {


    var state = mutableStateOf(EstateListState())


    //restrict writes to this ViewModel Class
    private set


    // use the injected GetEstatesUseCase Class which calls invoke implicitly

    //this returns a flow of Resource Objects


    /*we call ON-each to iterate on each element this flow emits*/

    private fun getEstates(){

     useCase().onEach {
           result ->


         when(result){


             is Resource.Success -> {

                 state.value = EstateListState(estates = result.data?: emptyList())
             }
             is Resource.Loading -> {

                 state.value = EstateListState(isLoading = true)
             }
             is Resource.Error -> {


                 state.value = EstateListState(error = result.message?: "An Expected Error Occurred")
             }
         }
     }

    }


}