package com.uxstate.marsincompose.presentation.estatedetails

import com.uxstate.marsincompose.domain.model.Estate

data class EstateDetailsState(val isLoading: Boolean = false,
                              val estate: Estate? = null,
                              val error: String = "") {
}