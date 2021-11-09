package com.uxstate.marsincompose.presentation.estatelist.components

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.marsincompose.domain.model.Estate
import com.uxstate.marsincompose.domain.use_cases.GetEstatesUseCase
import com.uxstate.marsincompose.presentation.estatelist.EstateListState
import com.uxstate.marsincompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class EstateViewModel @Inject constructor(private val useCase: GetEstatesUseCase):ViewModel() {


    var state = mutableStateOf(EstateListState())


    //restrict writes to this ViewModel Class
    private set


    init {
        getEstates()
        Timber.i("inside the initblock")
    }

    // use the injected GetEstatesUseCase Class which calls invoke implicitly

    //this returns a flow of Resource Objects


    /*we call ON-each to iterate on each element this flow emits*/

    private fun getEstates(){
Timber.i("getEstates Called")
     useCase().onEach {
           result ->


         when(result){


             is Resource.Success -> {

                 state.value = EstateListState(estates = result.data?: emptyList())

                 Timber.i("StateIsSuccess")
                 Timber.i("The loaded Estates are ${state.value}")
             }
             is Resource.Loading -> {

                 state.value = EstateListState(isLoading = true)
                 Timber.i("StateIsLoading")
                 Timber.i("The loaded Estates are ${state.value}")
             }
             is Resource.Error -> {


                 state.value = EstateListState(error = result.message?: "An Expected Error Occurred")
                 Timber.i("StateIsError")
                 Timber.i("The loaded Estates are ${state.value}")

             }
         }
     }.launchIn(viewModelScope)

    }


}