package com.uxstate.marsincompose.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.uxstate.marsincompose.domain.use_cases.GetEstatesUseCase
import com.uxstate.marsincompose.presentation.estatelist.EstateListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EstateViewModel @Inject constructor(private val useCase: GetEstatesUseCase):ViewModel() {


    var state = mutableStateOf(EstateListState())


    //restrict writes to this ViewModel Class
    private set


    private fun getEstates(){

        

    }


}