package com.uxstate.marsincompose.presentation.estatelist

import com.uxstate.marsincompose.domain.model.Estate

data class EstateListState(
    val isLoading: Boolean = false,
    val estates: List<Estate> = emptyList(),
    val error: String = ""
)
