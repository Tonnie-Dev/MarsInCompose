package com.uxstate.marsincompose.presentation.estatedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.uxstate.marsincompose.domain.model.Estate
import com.uxstate.marsincompose.presentation.estatedetails.components.DetailImage
import com.uxstate.marsincompose.presentation.estatedetails.components.PriceHeaderText
import com.uxstate.marsincompose.presentation.estatedetails.components.TypeHeaderText


@Composable
fun EstateDetailsScreen(viewModel: EstateDetailsViewModel = hiltViewModel()) {


    val state by viewModel.state


    state.estate?.let { estate ->


        Column(modifier = Modifier.fillMaxSize()) {

            DetailImage(estate = estate)
            TypeHeaderText(estate = estate)
            PriceHeaderText(estate = estate)
        }

    }



}