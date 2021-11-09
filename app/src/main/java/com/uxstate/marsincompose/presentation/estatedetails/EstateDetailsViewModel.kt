package com.uxstate.marsincompose.presentation.estatedetails

import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.marsincompose.domain.use_cases.GetMarsEstateUseCase
import com.uxstate.marsincompose.utils.Constants
import com.uxstate.marsincompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EstateDetailsViewModel @Inject constructor(
    private val usecase: GetMarsEstateUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {


    var state = mutableStateOf(EstateDetailsState())
        //restrict writes
        private set


    init {
        savedStateHandle.get<String>(Constants.ESTATE_ID)?.let { id ->


            getEstate(id)
        }

    }


    private fun getEstate(id: String) {

        usecase(id).onEach {

            result ->

            when(result){


                is Resource.Loading -> {

                    state.value = EstateDetailsState(isLoading = true)


                }
                is Resource.Error -> {

                    state.value = EstateDetailsState( error = result.message ?: "An Expected Error Occurred")
                }
                is Resource.Success -> {


                    state.value = EstateDetailsState(estate = result.data)
                }

            }
        }.launchIn(viewModelScope)


    }

}

