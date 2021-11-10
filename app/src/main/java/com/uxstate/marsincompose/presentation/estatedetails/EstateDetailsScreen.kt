package com.uxstate.marsincompose.presentation.estatedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.uxstate.marsincompose.domain.model.Estate
import com.uxstate.marsincompose.presentation.estatedetails.components.DetailImage
import com.uxstate.marsincompose.presentation.estatedetails.components.PriceHeaderText
import com.uxstate.marsincompose.presentation.estatedetails.components.TypeHeaderText
import timber.log.Timber


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

    Box(modifier = Modifier.fillMaxSize()) {


        if (state.isLoading){

            CircularProgressIndicator(modifier = Modifier.align(Center))
        }

        if (state.error.isNotBlank()){

            Text(text = state.error, color = MaterialTheme.colors.error)
        }
    }


}